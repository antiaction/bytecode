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
import com.antiaction.classfile.Constants;

public class Attribute_LineNumberTable extends AttributeAbstract {

	public List<LineNumberTable> lineNumberTableList;

	public Attribute_LineNumberTable() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_0_2;
		usage = Constants.ATTR_LOCATION_CODE;
	}

	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		lineNumberTableList = new ArrayList<LineNumberTable>();
		LineNumberTable lineNumberTable;
		int line_number_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( " Entries: " + line_number_table_length );
		for ( int i=0; i<line_number_table_length; ++i ) {
			lineNumberTable = new LineNumberTable();
			lineNumberTable.disassemble( cfs );
			lineNumberTableList.add( lineNumberTable );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int line_number_table_length = lineNumberTableList.size();
		out.write( (byte)(line_number_table_length >> 8) );
		out.write( (byte)(line_number_table_length & 255) );
		LineNumberTable lineNumberTable;
		for ( int i=0; i<lineNumberTableList.size(); ++i ) {
			lineNumberTable = lineNumberTableList.get( i );
			lineNumberTable.assemble( out );
		}
	}

}
