/*
 * Created on 18/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.methods;

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

		int attribute_name_index;
		String attribute_name;
		IAttribute attribute;

		while( methods_count > 0 ) {
			cfs.assert_unexpected_eof( 8 );

			access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			name = cfs.constantpool.getUtf8( name_index );

			descriptor_string = cfs.constantpool.getUtf8( descriptor_index );

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

			while ( attributes_count > 0 ) {
				cfs.assert_unexpected_eof( 6 );

				attribute_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
				attribute_name = cfs.constantpool.getUtf8( attribute_name_index );

				// debug
				System.out.println( attribute_name );

				attribute = Attributes.parseAttribute( cfs, attribute_name );

				method.attributeList.add( attribute );
				method.attributeMap.put( attribute_name, attribute );

				--attributes_count;

				if ( "Code".compareToIgnoreCase( attribute_name ) == 0 ) {
					method.codeAttr = (Attribute_Code)attribute;
				}
				else if ( "Deprecated".compareToIgnoreCase( attribute_name ) == 0 ) {
					method.deprecatedAttr = (Attribute_Deprecated)attribute;
				}
				else if ( "Exceptions".compareToIgnoreCase( attribute_name ) == 0 ) {
					method.exceptionsAttr = (Attribute_Exceptions)attribute;
				}
				else if ( "Synthetic".compareToIgnoreCase( attribute_name ) == 0 ) {
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

}
