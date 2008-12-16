/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.fields;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;
import com.antiaction.classfile.IDescriptor;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.descriptors.Descriptors;

public class Fields {

	public List<Field> fields_list;

	public static Fields parseFields(ClassFileState cfs, int fields_count) throws ClassFileException {
		List<Field> fields_list = new ArrayList<Field>();
		Field field;

		int access_flags;
		int name_index;
		int descriptor_index;
		int attributes_count;

		String name;
		String descriptor_string;
		IDescriptor descriptor;

		while( fields_count > 0 ) {
			cfs.assert_unexpected_eof( 8 );

			access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			name = cfs.cf.constantpool.getUtf8( name_index );

			descriptor_string = cfs.cf.constantpool.getUtf8( descriptor_index );

			descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

			// debug
			System.out.println( "Field: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

			field = new Field();
			field.access_flags = access_flags;
			field.name_index = name_index;
			field.descriptor_index = descriptor_index;
			field.name = name;
			field.descriptor_string = descriptor_string;

			field.validate_access_flags( cfs );

			// debug
			System.out.println( "attributes count: " + attributes_count );

			field.attributes = Attributes.parseAttributes( cfs, attributes_count );

			fields_list.add( field );

			--fields_count;
		}

		Fields fields = new Fields();
		fields.fields_list = fields_list;

		return fields;
	}

	public void build(ByteArrayOutputStream bytes) throws IOException {
		int fields_count = fields_list.size();

		bytes.write( (byte)(fields_count >> 8) );
		bytes.write( (byte)(fields_count & 255) );

		Field field;
		for ( int i=0; i<fields_list.size(); ++i ) {
			field = fields_list.get( i );

			bytes.write( (byte)(field.access_flags >> 8) );
			bytes.write( (byte)(field.access_flags & 255) );

			bytes.write( (byte)(field.name_index >> 8) );
			bytes.write( (byte)(field.name_index & 255) );

			bytes.write( (byte)(field.descriptor_index >> 8) );
			bytes.write( (byte)(field.descriptor_index & 255) );

			field.attributes.build( bytes );
		}
	}

}
