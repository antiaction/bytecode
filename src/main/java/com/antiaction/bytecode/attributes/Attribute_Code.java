/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;
import com.antiaction.bytecode.IAttribute;

public class Attribute_Code implements IAttribute {

	public List<ExceptionTable> exceptionTableList;

	public static IAttribute parseCode(ByteCodeState bcs) throws ByteCodeException {
		bcs.assert_unexpected_eof( 8 );

		int max_stack = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
		int max_locals = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
		int code_length = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		bcs.assert_unexpected_eof( code_length );

		byte[] code = new byte[ code_length ];
		System.arraycopy( bcs.bytes, bcs.index, code, 0, code_length );
		bcs.index += code_length;

		int start_pc;
		int end_pc;
		int handler_pc;
		int catch_type_index;

		List<ExceptionTable> exceptionTableList = new ArrayList<ExceptionTable>();
		ExceptionTable exceptionTable;

		int exception_table_length = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
		for ( int i=0; i<exception_table_length; ++i ) {
			bcs.assert_unexpected_eof( 8 );

			start_pc = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			end_pc = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			handler_pc = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			catch_type_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			if ( catch_type_index > 0 ) {
			}

			exceptionTable = new ExceptionTable();
			exceptionTable.start_pc = start_pc;
			exceptionTable.end_pc = end_pc;
			exceptionTable.handler_pc = handler_pc;
			exceptionTable.catch_type_index = catch_type_index;
			exceptionTableList.add( exceptionTable );
		}

		int attributes_count = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		// debug
		System.out.println( "Attributes: " + attributes_count );

		int attribute_name_index;
		String attribute_name;

		while ( attributes_count > 0 ) {
			bcs.assert_unexpected_eof( 6 );

			attribute_name_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			attribute_name = bcs.constantpool.getUtf8( attribute_name_index );

			// debug
			System.out.println( attribute_name );

			Attributes.parseAttribute( bcs, attribute_name );

			--attributes_count;
		}

		return null;
	}

}
