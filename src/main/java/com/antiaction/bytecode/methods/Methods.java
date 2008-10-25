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
import com.antiaction.bytecode.ClassFile;
import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.attributes.Attributes;

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

		while( methods_count > 0 ) {
			cfs.assert_unexpected_eof( 8 );

			access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			if ( (access_flags & ~ClassFile.METHOD_ACCESS_FLAGS_MASK) != 0 ) {
				throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~ClassFile.FIELD_ACCESS_FLAGS_MASK ) );
			}

			if ( Bits.bitstobits[ access_flags & (ClassFile.ACC_PUBLIC | ClassFile.ACC_PRIVATE | ClassFile.ACC_PROTECTED) ] > 1 ) {
				throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & (ClassFile.ACC_PUBLIC | ClassFile.ACC_PRIVATE | ClassFile.ACC_PROTECTED) ) );
			}

			if ( (access_flags & ( ClassFile.ACC_FINAL | ClassFile.ACC_VOLATILE )) == ( ClassFile.ACC_FINAL | ClassFile.ACC_VOLATILE ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ClassFile.ACC_FINAL | ClassFile.ACC_VOLATILE ) ) );
			}

			if ( cfs.bInterface ) {
				if ( (access_flags & ( ClassFile.ACC_PUBLIC |ClassFile.ACC_STATIC | ClassFile.ACC_FINAL )) != ( ClassFile.ACC_PUBLIC |ClassFile.ACC_STATIC | ClassFile.ACC_FINAL ) ) {
					throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ( ClassFile.ACC_PUBLIC |ClassFile.ACC_STATIC | ClassFile.ACC_FINAL ) ) );
				}
			}

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

			//IDescriptor descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

			// debug
			System.out.println( "Attributes: " + attributes_count );

			while ( attributes_count > 0 ) {
				cfs.assert_unexpected_eof( 6 );

				attribute_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
				attribute_name = cfs.constantpool.getUtf8( attribute_name_index );

				// debug
				System.out.println( attribute_name );

				Attributes.parseAttribute( cfs, attribute_name );

				--attributes_count;
			}

			--methods_count;
		}

		Methods methods = new Methods();
		methods.methods_list = methods_list;

		return null;
	}

}
