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
import com.antiaction.classfile.IAttribute;
import com.antiaction.classfile.attributes.Attribute_Code;
import com.antiaction.classfile.attributes.Attribute_Deprecated;
import com.antiaction.classfile.attributes.Attribute_Exceptions;
import com.antiaction.classfile.attributes.Attribute_Synthetic;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.fields.Field;

public class Methods {

	public List<Method> methods_list;

	public static Methods parseMethods(ClassFileState cfs, int methods_count) throws ClassFileException {
		List<Method> methods_list = new ArrayList<Method>();
		Method method;

		int access_flags;
		int name_index;
		int descriptor_index;
		int attributes_count;

		String name;
		String descriptor_string;

		IAttribute attribute;

		while( methods_count > 0 ) {
			cfs.assert_unexpected_eof( 8 );

			access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			name = cfs.cf.constantpool.getUtf8( name_index );

			descriptor_string = cfs.cf.constantpool.getUtf8( descriptor_index );

			// debug
			System.out.println( "Method: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

			method = new Method();
			method.access_flags = access_flags;
			method.name_index = name_index;
			method.descriptor_index = descriptor_index;
			method.name = name;
			method.descriptor_string = descriptor_string;

			method.validate_access_flags( cfs );

			//IDescriptor descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

			// debug
			System.out.println( "attributes count: " + attributes_count );

			method.attributes = Attributes.parseAttributes( cfs, attributes_count );

			for ( int i=0; i<method.attributes.attributeList.size(); ++i ) {
				attribute = method.attributes.attributeList.get( i );
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
				else {
					throw new ClassFileException( "unexpected method attribute" );
				}
			}

			methods_list.add( method );

			--methods_count;
		}

		Methods methods = new Methods();
		methods.methods_list = methods_list;

		return methods;
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

}
