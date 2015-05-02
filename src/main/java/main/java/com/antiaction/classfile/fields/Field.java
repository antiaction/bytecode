/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.fields;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.Bits;
import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;
import com.antiaction.classfile.IDescriptor;
import com.antiaction.classfile.ITraceHandler;
import com.antiaction.classfile.attributes.AttributeAbstract;
import com.antiaction.classfile.attributes.Attribute_ConstantValue;
import com.antiaction.classfile.attributes.Attribute_Deprecated;
import com.antiaction.classfile.attributes.Attribute_Signature;
import com.antiaction.classfile.attributes.Attribute_Synthetic;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;
import com.antiaction.classfile.descriptors.Descriptors;

public class Field extends BuildingBlockAbstract {

	protected ITraceHandler traceHandler;

	public int access_flags;

	public int name_index;
	public ConstantPool_Utf8 name_cp;
	public String name;

	public int descriptor_index;
	public ConstantPool_Utf8 descriptor_cp;
	public String descriptor_string;
	public IDescriptor descriptor;

	public Attributes attributes;

	public Attribute_ConstantValue constantValueAttr = null;

	public Attribute_Deprecated deprecatedAttr = null;

	public Attribute_Synthetic syntheticAttr = null;

	public Attribute_Signature signatureAttr = null;

	public Field(ITraceHandler traceHandler) {
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
		descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

		// debug
		//System.out.println( "Field: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

		validate_access_flags( cfs );

		// debug
		//System.out.println( "attributes count: " + attributes_count );

		attributes = new Attributes( traceHandler );
		attributes.disassemble( cfs );

		AttributeAbstract attribute;
		for ( int i=0; i<attributes.attributes_list.size(); ++i ) {
			attribute = attributes.attributes_list.get( i );
			if ( "ConstantValue".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				constantValueAttr = (Attribute_ConstantValue)attribute;
			}
			else if ( "Deprecated".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
				deprecatedAttr = (Attribute_Deprecated)attribute;
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
			else {
				throw new ClassFileException( "Unexpected field attribute (" + attribute.attribute_name + ")" );
			}
		}

	}

	@Override
	public void resolve() throws ClassFileException {
		name_cp.buildResolve();
		name_index = name_cp.index;
		descriptor_cp.buildResolve();
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
		if ( (access_flags & ~Constants.FIELD_ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~Constants.FIELD_ACCESS_FLAGS_MASK ) );
		}

		if ( cfs.cf.bClass ) {
			// Class fields can at most have one of the following flags set.
			if ( Bits.bitstobits[ access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ] > 1 ) {
				throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ) );
			}

			// Class fields can not have both flags set at the same time.
			if ( (access_flags & ( Constants.ACC_FINAL | Constants.ACC_VOLATILE )) == ( Constants.ACC_FINAL | Constants.ACC_VOLATILE ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( Constants.ACC_FINAL | Constants.ACC_VOLATILE ) ) );
			}
		}
		else if ( cfs.cf.bInterface ) {
			// Interface fields must have these three flags set.
			if ( (access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL )) != ( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL ) ) {
				throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL ) ) );
			}

			// Interface fields can optionally have this field set.
			if ( (access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNTHETIC )) != 0 ) {
				throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNTHETIC ) ) );
			}
		}
		else {
			throw new ClassFileException( "Unknown field access flags combination: 0x" + Integer.toHexString( access_flags ) );
		}
	}

}
