/*
 * Created on 18/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.methods;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.Bits;
import com.antiaction.bytecode.ByteCode;
import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;
import com.antiaction.bytecode.attributes.Attributes;

public class Methods {

	public List<Method> methods_list;

	public static Methods parseMethods(ByteCodeState bcs, int methods_count) throws ByteCodeException {
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

		while( methods_count > 0 ) {
			bcs.assert_unexpected_eof( 8 );

			access_flags = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			name_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			descriptor_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			attributes_count = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			if ( (access_flags & ~ByteCode.METHOD_ACCESS_FLAGS_MASK) != 0 ) {
				throw new ByteCodeException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~ByteCode.FIELD_ACCESS_FLAGS_MASK ) );
			}

			if ( Bits.bitstobits[ access_flags & (ByteCode.ACC_PUBLIC | ByteCode.ACC_PRIVATE | ByteCode.ACC_PROTECTED) ] > 1 ) {
				throw new ByteCodeException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & (ByteCode.ACC_PUBLIC | ByteCode.ACC_PRIVATE | ByteCode.ACC_PROTECTED) ) );
			}

			if ( (access_flags & ( ByteCode.ACC_FINAL | ByteCode.ACC_VOLATILE )) == ( ByteCode.ACC_FINAL | ByteCode.ACC_VOLATILE ) ) {
				throw new ByteCodeException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ByteCode.ACC_FINAL | ByteCode.ACC_VOLATILE ) ) );
			}

			if ( bcs.bInterface ) {
				if ( (access_flags & ( ByteCode.ACC_PUBLIC |ByteCode.ACC_STATIC | ByteCode.ACC_FINAL )) != ( ByteCode.ACC_PUBLIC |ByteCode.ACC_STATIC | ByteCode.ACC_FINAL ) ) {
					throw new ByteCodeException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ( ByteCode.ACC_PUBLIC |ByteCode.ACC_STATIC | ByteCode.ACC_FINAL ) ) );
				}
			}

			name = bcs.constantpool.getUtf8( name_index );

			descriptor_string = bcs.constantpool.getUtf8( descriptor_index );

			// debug
			System.out.println( "Method: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

			method = new Method();
			method.access_flags = access_flags;
			method.name_index = name_index;
			method.descriptor_index = descriptor_index;
			method.name = name;
			method.descriptor_string = descriptor_string;

			//IDescriptor descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

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

			--methods_count;
		}

		Methods methods = new Methods();
		methods.methods_list = methods_list;

		return null;
	}

}
