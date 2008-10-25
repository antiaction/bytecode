/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IAttribute;

public class Attribute_Code implements IAttribute {

	byte[] code;

	int max_stack;
	int max_locals;

	public List<ExceptionTable> exceptionTableList;

	public static IAttribute parseCode(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 8 );

		int max_stack = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int max_locals = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int code_length = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		cfs.assert_unexpected_eof( code_length );

		byte[] code = new byte[ code_length ];
		System.arraycopy( cfs.bytes, cfs.index, code, 0, code_length );
		cfs.index += code_length;

		int start_pc;
		int end_pc;
		int handler_pc;
		int catch_type_index;

		List<ExceptionTable> exceptionTableList = new ArrayList<ExceptionTable>();
		ExceptionTable exceptionTable;

		int exception_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		for ( int i=0; i<exception_table_length; ++i ) {
			cfs.assert_unexpected_eof( 8 );

			start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			end_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			handler_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			catch_type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			if ( catch_type_index > 0 ) {
			}

			exceptionTable = new ExceptionTable();
			exceptionTable.start_pc = start_pc;
			exceptionTable.end_pc = end_pc;
			exceptionTable.handler_pc = handler_pc;
			exceptionTable.catch_type_index = catch_type_index;
			exceptionTableList.add( exceptionTable );
		}

		int attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "Attributes: " + attributes_count );

		int attribute_name_index;
		String attribute_name;

		while ( attributes_count > 0 ) {
			cfs.assert_unexpected_eof( 6 );

			attribute_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attribute_name = cfs.constantpool.getUtf8( attribute_name_index );

			// debug
			System.out.println( attribute_name );

			Attributes.parseAttribute( cfs, attribute_name );

			--attributes_count;
		}

		Attribute_Code attribute = new Attribute_Code();
		attribute.code = code;
		attribute.max_stack = max_stack;
		attribute.max_locals = max_locals;
		attribute.exceptionTableList = exceptionTableList;

		return attribute;
	}

}
