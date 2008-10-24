/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.fields;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.Bits;
import com.antiaction.bytecode.ByteCode;
import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IDescriptor;
import com.antiaction.bytecode.attributes.Attributes;
import com.antiaction.bytecode.descriptors.Descriptors;

public class Fields {

	public List<Field> fields_list;

	public static Fields parseFields(ClassFileState bcs, int fields_count) throws ClassFileException {
		List<Field> fields_list = new ArrayList<Field>();
		Field field;

		int access_flags;
		int name_index;
		int descriptor_index;
		int attributes_count;

		String name;
		String descriptor_string;
		IDescriptor descriptor;

		int attribute_name_index;
		String attribute_name;

		while( fields_count > 0 ) {
			bcs.assert_unexpected_eof( 8 );

			access_flags = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			name_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			descriptor_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			attributes_count = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			if ( (access_flags & ~ByteCode.FIELD_ACCESS_FLAGS_MASK) != 0 ) {
				throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~ByteCode.FIELD_ACCESS_FLAGS_MASK ) );
			}

			if ( Bits.bitstobits[ access_flags & (ByteCode.ACC_PUBLIC | ByteCode.ACC_PRIVATE | ByteCode.ACC_PROTECTED) ] > 1 ) {
				throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & (ByteCode.ACC_PUBLIC | ByteCode.ACC_PRIVATE | ByteCode.ACC_PROTECTED) ) );
			}

			if ( (access_flags & ( ByteCode.ACC_FINAL | ByteCode.ACC_VOLATILE )) == ( ByteCode.ACC_FINAL | ByteCode.ACC_VOLATILE ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ByteCode.ACC_FINAL | ByteCode.ACC_VOLATILE ) ) );
			}

			if ( bcs.bInterface ) {
				if ( (access_flags & ( ByteCode.ACC_PUBLIC |ByteCode.ACC_STATIC | ByteCode.ACC_FINAL )) != ( ByteCode.ACC_PUBLIC |ByteCode.ACC_STATIC | ByteCode.ACC_FINAL ) ) {
					throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ( ByteCode.ACC_PUBLIC |ByteCode.ACC_STATIC | ByteCode.ACC_FINAL ) ) );
				}
			}

			name = bcs.constantpool.getUtf8( name_index );

			descriptor_string = bcs.constantpool.getUtf8( descriptor_index );

			descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

			// debug
			System.out.println( "Field: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

			field = new Field();
			field.access_flags = access_flags;
			field.name_index = name_index;
			field.descriptor_index = descriptor_index;
			field.name = name;
			field.descriptor_string = descriptor_string;

			// debug
			System.out.println( "Attributes: " + attributes_count );

			while ( attributes_count > 0 ) {
				bcs.assert_unexpected_eof( 6 );

				attribute_name_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
				attribute_name = bcs.constantpool.getUtf8( attribute_name_index );

				// debug
				System.out.println( attribute_name );

				Attributes.parseAttribute( bcs, attribute_name );

				--attributes_count;
			}

			--fields_count;
		}

		Fields fields = new Fields();
		fields.fields_list = fields_list;

		return fields;
	}

}
