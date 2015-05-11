/*
 * Created on 18/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.methods;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.Bits;
import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;
import com.antiaction.classfile.ITraceHandler;
import com.antiaction.classfile.attributes.AttributeAbstract;
import com.antiaction.classfile.attributes.Attribute_Code;
import com.antiaction.classfile.attributes.Attribute_Deprecated;
import com.antiaction.classfile.attributes.Attribute_Exceptions;
import com.antiaction.classfile.attributes.Attribute_Signature;
import com.antiaction.classfile.attributes.Attribute_Synthetic;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Method extends BuildingBlockAbstract {

	protected ITraceHandler traceHandler;

	public int access_flags;

	public boolean bAbstract = false;

	public int name_index;
	public ConstantPool_Utf8 name_cp;
	public String name;

	public int descriptor_index;
	public ConstantPool_Utf8 descriptor_cp;
	public String descriptor_string;

	public Attributes attributes;

	public Attribute_Code codeAttr = null;

	public Attribute_Deprecated deprecatedAttr = null;

	public Attribute_Exceptions exceptionsAttr = null;

	public Attribute_Synthetic syntheticAttr = null;

	public Attribute_Signature signatureAttr = null;

	public Method(ITraceHandler traceHandler) {
		this.traceHandler = traceHandler;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		if ( traceHandler != null ) {
			traceHandler.addIndex( cfs.index, this );
		}
		cfs.assert_unexpected_eof( 8 );

		access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		name_cp = cfs.cf.constantpool.getUtf8( name_index );
		name = name_cp.utf8;

		descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		descriptor_cp = cfs.cf.constantpool.getUtf8( descriptor_index );
		descriptor_string = descriptor_cp.utf8;

		// debug
		//System.out.println( "Method: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

		validate_access_flags( cfs );

		//IDescriptor descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

		// debug
		//System.out.println( "attributes count: " + attributes_count );

		attributes = new Attributes( traceHandler );
		attributes.disassemble( cfs );

		AttributeAbstract attribute;
		for ( int i=0; i<attributes.attributes_list.size(); ++i ) {
			attribute = attributes.attributes_list.get( i );
			if ( "Code".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				codeAttr = (Attribute_Code)attribute;
			}
			else if ( "Deprecated".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				deprecatedAttr = (Attribute_Deprecated)attribute;
			}
			else if ( "Exceptions".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				exceptionsAttr = (Attribute_Exceptions)attribute;
			}
			else if ( "Synthetic".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				syntheticAttr = (Attribute_Synthetic)attribute;
			}
			else if ( "Signature".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				signatureAttr = (Attribute_Signature)attribute;
			}
			else if ( "RuntimeVisibleAnnotations".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				// TODO
			}
			else if ( "RuntimeInvisibleAnnotations".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				// TODO
			}
			else if ( "RuntimeVisibleParameterAnnotations".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				// TODO
			}
			else if ( "RuntimeInvisibleParameterAnnotations".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				// TODO
			}
			else if ( "AnnotationDefault".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				// TODO
			}
			else {
				throw new ClassFileException( "Unexpected method attribute (" + attribute.attribute_name + ")" );
			}
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		name_cp.resolve();
		name_index = name_cp.index;
		descriptor_cp.resolve();
		descriptor_index = descriptor_cp.index;
		attributes.resolve();
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(access_flags >> 8) );
		out.write( (byte)(access_flags & 255) );
		out.write( (byte)(name_index >> 8) );
		out.write( (byte)(name_index & 255) );
		out.write( (byte)(descriptor_index >> 8) );
		out.write( (byte)(descriptor_index & 255) );
		attributes.assemble( out );
	}

	public void validate_access_flags(ClassFileState cfs) throws ClassFileException {
		// Check against supported access flags.
		if ( (access_flags & ~Constants.METHOD_ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid method access flags: 0x" + Integer.toHexString( access_flags & ~Constants.METHOD_ACCESS_FLAGS_MASK ) );
		}

		// debug
		//System.out.println( "Method: " + name );

		if ( cfs.cf.bClass ) {
			if ( name.startsWith( "<" ) & name.endsWith( ">" ) ) {
				if ( "<clinit>".compareTo( name ) == 0 ) {
				}
				else if ( "<init>".compareTo( name ) == 0 ) {
				}
				else {
					throw new ClassFileException( "No" );
				}
			}
			else {
				if ( Bits.bitstobits[ access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ] > 1 ) {
					throw new ClassFileException( "Invalid class method access flags: 0x" + Integer.toHexString( access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
				}
				if ( (access_flags & Constants.ACC_ABSTRACT) == Constants.ACC_ABSTRACT ) {
					bAbstract = true;
					if ( !cfs.cf.bAbstract ) {
						throw new ClassFileException( "Method not declared in abstract class" );
					}
					if ( (access_flags & (Constants.ACC_PRIVATE | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNCHRONIZED | Constants.ACC_NATIVE | Constants.ACC_STRICT)) != 0 ) {
						throw new ClassFileException( "Invalid class abstract method access flags: 0x" + Integer.toHexString( access_flags & (Constants.ACC_PRIVATE | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNCHRONIZED | Constants.ACC_NATIVE | Constants.ACC_STRICT) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
					}
				}
			}
		}
		else if ( cfs.cf.bInterface ) {
			if ( name.startsWith( "<" ) & name.endsWith( ">" ) ) {
				if ( "<clinit>".compareTo( name ) == 0 ) {
				}
				else {
					throw new ClassFileException( "No" );
				}
			}
			else {
				if ( (access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT )) != ( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT ) ) {
					throw new ClassFileException( "Invalid interface method access flags combination: 0x" + Integer.toHexString( access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT ) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
				}
				if ( (access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT | Constants.ACC_BRIDGE | Constants.ACC_VARARGS | Constants.ACC_SYNTHETIC )) != 0 ) {
					throw new ClassFileException( "Invalid interface method access flags combination: 0x" + Integer.toHexString( access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT | Constants.ACC_BRIDGE | Constants.ACC_VARARGS | Constants.ACC_SYNTHETIC ) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
				}
			}
		}
		else {
			throw new ClassFileException( "Unknown method access flags combination: 0x" + Integer.toHexString( access_flags ) );
		}
	}

}
