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

public class Attribute_LineNumberTable implements IAttribute {

	public List<LineNumberTable> lineNumberTableList;

	public static IAttribute parseLineNumberTable(ByteCodeState bcs) throws ByteCodeException {
		bcs.assert_unexpected_eof( 2 );

		List<LineNumberTable> lineNumberTableList = new ArrayList<LineNumberTable>();
		LineNumberTable lineNumberTable;

		int start_pc;
		int line_number;

		int line_number_table_length = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		// debug
		System.out.println( " Entries: " + line_number_table_length );

		for ( int i=0; i<line_number_table_length; ++i ) {
			bcs.assert_unexpected_eof( 4 );

			start_pc = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			line_number = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			lineNumberTable = new LineNumberTable();
			lineNumberTable.start_pc = start_pc;
			lineNumberTable.line_number = line_number;
			lineNumberTableList.add( lineNumberTable );
		}

		Attribute_LineNumberTable attribute = new Attribute_LineNumberTable();
		attribute.lineNumberTableList = lineNumberTableList;

		return attribute;
	}

}
