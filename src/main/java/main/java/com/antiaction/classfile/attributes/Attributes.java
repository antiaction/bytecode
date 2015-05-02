/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;
import com.antiaction.classfile.ITraceHandler;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Attributes extends BuildingBlockAbstract {

	protected ITraceHandler traceHandler;

	protected ClassFile cf;

	public List<AttributeAbstract> attributes_list = new ArrayList<AttributeAbstract>();

	protected Map<String, AttributeAbstract> attributes_map = new HashMap<String, AttributeAbstract>();

	protected Attribute_SourceFile sourceFile_attr = null;

	public Attributes(ITraceHandler traceHandler) {
		this.traceHandler = traceHandler;
	}

	public static Attributes createInstance(ClassFile cf) {
		Attributes attributes = new Attributes( null );
		attributes.cf = cf;
		return attributes;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		if ( traceHandler != null ) {
			traceHandler.addIndex( cfs.index, this );
		}

		cfs.assert_unexpected_eof( 2 );

		int attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		int traceIndex;

		// debug
		//System.out.println( "attributes count: " + attributes_count );

		int attribute_name_index;
		ConstantPool_Utf8 attribute_name_cp;
		String attribute_name;
		int attribute_length;
		AttributeAbstract attribute;

		cf = cfs.cf;

		while ( attributes_count > 0 ) {
			traceIndex = cfs.index;

			cfs.assert_unexpected_eof( 6 );

			attribute_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attribute_name_cp = cfs.cf.constantpool.getUtf8( attribute_name_index );
			attribute_name = attribute_name_cp.utf8;

			// debug
			//System.out.println( attribute_name );

			attribute_length = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			cfs.assert_unexpected_eof( attribute_length );

			Integer attributeId = Constants.attrNameIdMap.get( attribute_name );
			attribute = null;
			if ( attributeId != null ) {
				switch ( attributeId ) {
				case Constants.ATTR_CONSTANTVALUE_ID:								// ConstantValue - 45.3 / 1.0.2 / 4.7.2
					attribute = new Attribute_ConstantValue();
					break;
				case Constants.ATTR_CODE_ID:										// Code - 45.3 / 1.0.2 / 4.7.3
					attribute = new Attribute_Code();
					break;
				case Constants.ATTR_EXCEPTIONS_ID:									// Exceptions - 45.3 / 1.0.2 / 4.7.5
					attribute = new Attribute_Exceptions();
					break;
				case Constants.ATTR_SOURCEFILE_ID:									// SourceFile - 45.3 / 1.0.2 / 4.7.10
					attribute = new Attribute_SourceFile();
					break;
				case Constants.ATTR_LINENUMBERTABLE_ID:								// LineNumberTable - 45.3 / 1.0.2 / 4.7.12
					attribute = new Attribute_LineNumberTable();
					break;
				case Constants.ATTR_LOCALVARIABLETABLE_ID:							// LocalVariableTable - 45.3 / 1.0.2 / 4.7.13
					attribute = new Attribute_LocalVariableTable();
					break;
				case Constants.ATTR_INNERCLASSES_ID:								// InnerClasses - 45.3 / 1.1 / 4.7.6
					attribute = new Attribute_InnerClasses();
					break;
				case Constants.ATTR_SYNTHETIC_ID:									// Synthetic - 45.3 / 1.1 / 4.7.8
					attribute = new Attribute_Synthetic();
					break;
				case Constants.ATTR_DEPRECATED_ID:									// Deprecated - 45.3 / 1.1 / 4.7.15
					attribute = new Attribute_Deprecated();
					break;
				case Constants.ATTR_ENCLOSINGMETHOD_ID:								// EnclosingMethod - 49.0 / 5.0 / 4.7.7
					attribute = new Attribute_EnclosingMethod();
					break;
				case Constants.ATTR_SIGNATURE_ID:									// Signature -  49.0 / 5.0 / 4.7.9
					attribute = new Attribute_Signature();
					break;
				case Constants.ATTR_SOURCEDEBUGEXTENSION_ID:						// SourceDebugExtension - 49.0 / 5.0 / 4.7.11
					attribute = new Attribute_SourceDebugExtension();
					break;
				case Constants.ATTR_LOCALVARIABLETYPETABLE_ID:						// LocalVariableTypeTable - 49.0 / 5.0 / 4.7.14
					attribute = new Attribute_LocalVariableTypeTable();
					break;
				case Constants.ATTR_RUNTIMEVISIBLEANNOTATIONS_ID:					// RuntimeVisibleAnnotations - 49.0 / 5.0 / 4.7.16
					attribute = new Attribute_RuntimeVisibleAnnotations();
					break;
				case Constants.ATTR_RUNTIMEINVISIBLEANNOTATIONS_ID:					// RuntimeInvisibleAnnotations - 49.0 / 5.0 / 4.7.17
					attribute = new Attribute_RuntimeInvisibleAnnotations();
					break;
				case Constants.ATTR_RUNTIMEVISIBLEPARAMETERANNOTATIONS_ID:			// RuntimeVisibleParameterAnnotations - 49.0 / 5.0 / 4.7.18
					attribute = new Attribute_RuntimeVisibleParameterAnnotations();
					break;
				case Constants.ATTR_RUNTIMEINVISIBLEPARAMETERANNOTATIONS_ID:		// RuntimeInvisibleParameterAnnotations - 49.0 / 5.0 / 4.7.19
					attribute = new Attribute_RuntimeInvisibleParameterAnnotations();
					break;
				case Constants.ATTR_ANNOTATIONDEFAULT_ID:							// AnnotationDefault - 49.0 / 5.0 / 4.7.22
					attribute = new Attribute_AnnotationDefault();
					break;
				case Constants.ATTR_STACKMAPTABLE_ID:								// StackMapTable - 50.0 / 6 / 4.7.4
					//attribute = new Attribute_StackMapTable();
					break;
				case Constants.ATTR_BOOTSTRAPMETHODS_ID:							// BootstrapMethods - 51.0 / 7 / 4.7.23
					attribute = new Attribute_BootstrapMethods();
					break;
				case Constants.ATTR_RUNTIMEVISIBLETYPEANNOTATIONS_ID:				// RuntimeVisibleTypeAnnotations - 52.0 / 8 / 4.7.20
					attribute = new Attribute_RuntimeVisibleTypeAnnotations();
					break;
				case Constants.ATTR_RUNTIMEINVISIBLETYPEANNOTATIONS_ID:				// RuntimeInvisibleTypeAnnotations - 52.0 / 8 / 4.7.21
					attribute = new Attribute_RuntimeInvisibleTypeAnnotations();
					break;
				case Constants.ATTR_METHODPARAMETERS_ID:							// MethodParameters - 52.0 / 8 / 4.7.24
					attribute = new Attribute_MethodParameters();
					break;
				}
			}
			if ( attribute == null ) {
				attribute = new Attribute_Custom();
			}
			if ( traceHandler != null ) {
				traceHandler.addIndex( traceIndex, attribute );
				attribute.traceHandler = traceHandler;
			}
			attribute.attribute_name_index = attribute_name_index;
			attribute.attribute_name_cp = attribute_name_cp;
			attribute.attribute_name = attribute_name;
			attribute.attribute_length = attribute_length;
			attribute.disassemble( cfs );

			attributes_list.add( attribute );
			attributes_map.put( attribute_name, attribute );
			--attributes_count;
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		AttributeAbstract attribute;
		for ( int i=0; i<attributes_list.size(); ++i ) {
			attribute = attributes_list.get( i );
			attribute.attribute_name_cp.buildResolve();
			attribute.attribute_name_index = attribute.attribute_name_cp.index;
			attribute.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int attributes_count = attributes_list.size();
		out.write( (byte)(attributes_count >> 8) );
		out.write( (byte)(attributes_count & 255) );
		AttributeAbstract attribute;
		byte[] attrBytes;
		ByteArrayOutputStream aOut = new ByteArrayOutputStream();
		for ( int i=0; i<attributes_list.size(); ++i) {
			attribute = attributes_list.get( i );
			// debug
			//System.out.println( attribute.attribute_name + ": " + bytes.size() );
			out.write( (byte)(attribute.attribute_name_index >> 8) );
			out.write( (byte)(attribute.attribute_name_index & 255) );
			aOut.reset();
			attribute.assemble( aOut );
			attrBytes = aOut.toByteArray();
			out.write( (byte)(attrBytes.length >> 24) );
			out.write( (byte)(attrBytes.length >> 16) );
			out.write( (byte)(attrBytes.length >> 8) );
			out.write( (byte)(attrBytes.length & 255) );
			out.write( attrBytes );
		}
	}

	public Attribute_SourceFile getSourceFile() {
		return sourceFile_attr;
	}

	public Attribute_SourceFile putSourceFile(String sourcefile) throws ClassFileException {
		Attribute_SourceFile a_sourcefile = Attribute_SourceFile.createSourceFile( cf.constantpool, sourcefile );
		return a_sourcefile;
	}

}
