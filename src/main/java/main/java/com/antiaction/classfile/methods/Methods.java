/*
 * Created on 18/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.methods;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.AttributeAbstrsct;
import com.antiaction.classfile.attributes.Attribute_Code;
import com.antiaction.classfile.attributes.Attribute_Deprecated;
import com.antiaction.classfile.attributes.Attribute_Exceptions;
import com.antiaction.classfile.attributes.Attribute_Signature;
import com.antiaction.classfile.attributes.Attribute_Synthetic;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Methods {

	public List<Method> methods_list;

	public static Methods parseMethods(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int methods_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( "methods count: " + methods_count );

		List<Method> methods_list = new ArrayList<Method>();
		Method method;

		int access_flags;

		int name_index;
		ConstantPool_Utf8 name_cp;
		String name;

		int descriptor_index;
		ConstantPool_Utf8 descriptor_cp;
		String descriptor_string;

		int attributes_count;

		AttributeAbstrsct attribute;

		while( methods_count > 0 ) {
			cfs.assert_unexpected_eof( 8 );

			access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			name_cp = cfs.cf.constantpool.getUtf8( name_index );
			name = name_cp.utf8;

			descriptor_cp = cfs.cf.constantpool.getUtf8( descriptor_index );
			descriptor_string = descriptor_cp.utf8;

			// debug
			//System.out.println( "Method: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

			method = new Method();
			method.access_flags = access_flags;
			method.name_index = name_index;
			method.name_cp = name_cp;
			method.name = name;
			method.descriptor_index = descriptor_index;
			method.descriptor_cp = descriptor_cp;
			method.descriptor_string = descriptor_string;

			method.validate_access_flags( cfs );

			//IDescriptor descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

			// debug
			//System.out.println( "attributes count: " + attributes_count );

			method.attributes = Attributes.parseAttributes( cfs, attributes_count );

			for ( int i=0; i<method.attributes.attributes_list.size(); ++i ) {
				attribute = method.attributes.attributes_list.get( i );
				if ( "Code".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
					method.codeAttr = (Attribute_Code)attribute;
				}
				else if ( "Deprecated".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
					method.deprecatedAttr = (Attribute_Deprecated)attribute;
				}
				else if ( "Exceptions".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
					method.exceptionsAttr = (Attribute_Exceptions)attribute;
				}
				else if ( "Synthetic".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
					method.syntheticAttr = (Attribute_Synthetic)attribute;
				}
				else if ( "Signature".compareToIgnoreCase( attribute.attribute_name ) == 0 ) {
					method.signatureAttr = (Attribute_Signature)attribute;
				}
				else {
					throw new ClassFileException( "Unexpected method attribute (" + attribute.attribute_name + ")" );
				}
			}

			methods_list.add( method );

			--methods_count;
		}

		Methods methods = new Methods();
		methods.methods_list = methods_list;

		return methods;
	}

	public void buildResolve() throws ClassFileException {
		Method method;
		for ( int i=0; i<methods_list.size(); ++i ) {
			method = methods_list.get( i );
			method.name_cp.buildResolve();
			method.name_index = method.name_cp.index;
			method.descriptor_cp.buildResolve();
			method.descriptor_index = method.descriptor_cp.index;
			method.attributes.buildResolve();
		}
	}

	public void build(ByteArrayOutputStream bytes) throws IOException {
		int methods_count = methods_list.size();

		bytes.write( (byte)(methods_count >> 8) );
		bytes.write( (byte)(methods_count & 255) );

		Method method;
		for ( int i=0; i<methods_list.size(); ++i ) {
			method = methods_list.get( i );

			bytes.write( (byte)(method.access_flags >> 8) );
			bytes.write( (byte)(method.access_flags & 255) );

			bytes.write( (byte)(method.name_index >> 8) );
			bytes.write( (byte)(method.name_index & 255) );

			bytes.write( (byte)(method.descriptor_index >> 8) );
			bytes.write( (byte)(method.descriptor_index & 255) );

			method.attributes.build( bytes );
		}
	}

	public static Methods createInstance() {
		Methods methods = new Methods();
		methods.methods_list = new ArrayList<Method>();
		return methods;
	}

}
