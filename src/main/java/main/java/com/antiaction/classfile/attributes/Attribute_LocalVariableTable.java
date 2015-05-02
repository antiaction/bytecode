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

public class Attribute_LocalVariableTable extends AttributeAbstract {

	public List<LocalVariableTable> localVariableTableList;

	public Attribute_LocalVariableTable() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_0_2;
		usage = Constants.ATTR_LOCATION_CODE;
	}

	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		localVariableTableList = new ArrayList<LocalVariableTable>();
		LocalVariableTable localVariableTable;
		int local_variable_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( " Entries: " + local_variable_table_length );
		for ( int i=0; i<local_variable_table_length; ++i ) {
			localVariableTable = new LocalVariableTable();
			localVariableTable.disassemble( cfs );
			localVariableTableList.add( localVariableTable );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		LocalVariableTable localVariableTable;
		for ( int i=0; i<localVariableTableList.size(); ++i ) {
			localVariableTable = localVariableTableList.get( i );
			localVariableTable.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int local_variable_table_length = localVariableTableList.size();
		out.write( (byte)(local_variable_table_length >> 8) );
		out.write( (byte)(local_variable_table_length & 255) );
		LocalVariableTable localVariableTable;
		for ( int i=0; i<localVariableTableList.size(); ++i ) {
			localVariableTable = localVariableTableList.get( i );
			localVariableTable.assemble( out );
		}
	}

}
