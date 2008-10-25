/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;

public class Attribute_LineNumberTable implements IAttribute {

	public List<LineNumberTable> lineNumberTableList;

	public static IAttribute parseLineNumberTable(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		List<LineNumberTable> lineNumberTableList = new ArrayList<LineNumberTable>();
		LineNumberTable lineNumberTable;

		int start_pc;
		int line_number;

		int line_number_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( " Entries: " + line_number_table_length );

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

}
