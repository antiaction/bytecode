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
import com.antiaction.classfile.AttributeAbstrsct;

public class Attribute_LineNumberTable extends AttributeAbstrsct {

	public List<LineNumberTable> lineNumberTableList;

	public static AttributeAbstrsct parseLineNumberTable(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		List<LineNumberTable> lineNumberTableList = new ArrayList<LineNumberTable>();
		LineNumberTable lineNumberTable;

		int start_pc;
		int line_number;

		int line_number_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( " Entries: " + line_number_table_length );

		for ( int i=0; i<line_number_table_length; ++i ) {
			cfs.assert_unexpected_eof( 4 );

			start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			line_number = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			lineNumberTable = new LineNumberTable();
			lineNumberTable.start_pc = start_pc;
			lineNumberTable.line_number = line_number;
			lineNumberTableList.add( lineNumberTable );
		}

		Attribute_LineNumberTable attribute = new Attribute_LineNumberTable();
		attribute.lineNumberTableList = lineNumberTableList;

		return attribute;
	}

	@Override
	public void buildResolve() throws ClassFileException {
	}

	@Override
	public byte[] build() throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		int line_number_table_length = lineNumberTableList.size();

		bytes.write( (byte)(line_number_table_length >> 8) );
		bytes.write( (byte)(line_number_table_length & 255) );

		LineNumberTable lineNumberTable;
		for ( int i=0; i<lineNumberTableList.size(); ++i ) {
			lineNumberTable = lineNumberTableList.get( i );

			bytes.write( (byte)(lineNumberTable.start_pc >> 8) );
			bytes.write( (byte)(lineNumberTable.start_pc & 255) );

			bytes.write( (byte)(lineNumberTable.line_number >> 8) );
			bytes.write( (byte)(lineNumberTable.line_number & 255) );
		}

		return bytes.toByteArray();
	}

}
