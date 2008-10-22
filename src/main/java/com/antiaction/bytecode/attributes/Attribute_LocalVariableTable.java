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
import com.antiaction.bytecode.IDescriptor;
import com.antiaction.bytecode.descriptors.Descriptors;

public class Attribute_LocalVariableTable implements IAttribute {

	public List<LocalVariableTable> localVariableTableList;

	public static IAttribute parseLocalVariableTable(ByteCodeState bcs) throws ByteCodeException {
		bcs.assert_unexpected_eof( 2 );

		List<LocalVariableTable> localVariableTableList = new ArrayList<LocalVariableTable>();
		LocalVariableTable localVariableTable;

		int start_pc;
		int length;
		int name_index;
		int descriptor_index;
		int index;

		String name;
		String descriptor_string;
		IDescriptor descriptor;

		int local_variable_table_length = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		// debug
		System.out.println( " Entries: " + local_variable_table_length );

		for ( int i=0; i<local_variable_table_length; ++i ) {
			bcs.assert_unexpected_eof( 10 );

			start_pc = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			length = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			name_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			descriptor_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			name = bcs.constantpool.getUtf8( name_index );

			descriptor_string = bcs.constantpool.getUtf8( descriptor_index );

			descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

			// debug
			System.out.println( "Field: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

			localVariableTable = new LocalVariableTable();
			localVariableTable.start_pc = start_pc;
			localVariableTable.length = length;
			localVariableTable.name_index = name_index;
			localVariableTable.descriptor_index = descriptor_index;
			localVariableTable.index = index;
			localVariableTable.name = name;
			localVariableTable.descriptor_string = descriptor_string;
			localVariableTableList.add( localVariableTable );
		}

		Attribute_LocalVariableTable attribute = new Attribute_LocalVariableTable();
		attribute.localVariableTableList = localVariableTableList;

		return null;
	}

}
