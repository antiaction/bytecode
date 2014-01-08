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
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;

public class Attribute_Code extends IAttribute {

	public int max_stack;
	public int max_locals;

	public byte[] code;

	public List<ExceptionTable> exceptionTableList;

	public Attributes attributes;

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
		//System.out.println( "Attributes: " + attributes_count );

		Attributes attributes = Attributes.parseAttributes( cfs, attributes_count );

		Attribute_Code attribute = new Attribute_Code();
		attribute.code = code;
		attribute.max_stack = max_stack;
		attribute.max_locals = max_locals;
		attribute.exceptionTableList = exceptionTableList;
		attribute.attributes = attributes;

		return attribute;
	}

	@Override
	public void buildResolve() throws ClassFileException {
		attributes.buildResolve();
	}

	@Override
	public byte[] build() throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		bytes.write( (byte)(max_stack >> 8) );
		bytes.write( (byte)(max_stack & 255) );

		bytes.write( (byte)(max_locals >> 8) );
		bytes.write( (byte)(max_locals & 255) );

		int code_length = code.length;

		bytes.write( (byte)(code_length >> 24) );
		bytes.write( (byte)(code_length >> 16) );
		bytes.write( (byte)(code_length >> 8) );
		bytes.write( (byte)(code_length & 255) );

		bytes.write( code );

		int exception_table_length = exceptionTableList.size();

		bytes.write( (byte)(exception_table_length >> 8) );
		bytes.write( (byte)(exception_table_length & 255) );

		ExceptionTable exceptionTable;
		for ( int i=0; i<exceptionTableList.size(); ++i ) {
			exceptionTable = exceptionTableList.get( i );

			bytes.write( (byte)(exceptionTable.start_pc >> 8) );
			bytes.write( (byte)(exceptionTable.start_pc & 255) );

			bytes.write( (byte)(exceptionTable.end_pc >> 8) );
			bytes.write( (byte)(exceptionTable.end_pc & 255) );

			bytes.write( (byte)(exceptionTable.handler_pc >> 8) );
			bytes.write( (byte)(exceptionTable.handler_pc & 255) );

			bytes.write( (byte)(exceptionTable.catch_type_index >> 8) );
			bytes.write( (byte)(exceptionTable.catch_type_index & 255) );
		}

		attributes.build( bytes );

		return bytes.toByteArray();
	}

}
