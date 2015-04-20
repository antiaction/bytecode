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
import com.antiaction.classfile.IDescriptor;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;
import com.antiaction.classfile.descriptors.Descriptors;

public class Attribute_LocalVariableTable extends AttributeAbstrsct {

	public List<LocalVariableTable> localVariableTableList;

	public static AttributeAbstrsct parseLocalVariableTable(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		List<LocalVariableTable> localVariableTableList = new ArrayList<LocalVariableTable>();
		LocalVariableTable localVariableTable;

		int start_pc;
		int length;

		int name_index;
		ConstantPool_Utf8 name_cp;
		String name;

		int descriptor_index;
		ConstantPool_Utf8 descriptor_cp;
		String descriptor_string;
		IDescriptor descriptor;

		int index;

		int local_variable_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( " Entries: " + local_variable_table_length );

		for ( int i=0; i<local_variable_table_length; ++i ) {
			cfs.assert_unexpected_eof( 10 );

			start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			name_cp = cfs.cf.constantpool.getUtf8( name_index );
			name = name_cp.utf8;

			descriptor_cp = cfs.cf.constantpool.getUtf8( descriptor_index );
			descriptor_string = descriptor_cp.utf8;

			descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

			// debug
			//System.out.println( "Field: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );

			localVariableTable = new LocalVariableTable();
			localVariableTable.start_pc = start_pc;
			localVariableTable.length = length;
			localVariableTable.name_index = name_index;
			localVariableTable.name_cp = name_cp;
			localVariableTable.name = name;
			localVariableTable.descriptor_index = descriptor_index;
			localVariableTable.descriptor_cp = descriptor_cp;
			localVariableTable.index = index;
			localVariableTable.descriptor_string = descriptor_string;
			localVariableTableList.add( localVariableTable );
		}

		Attribute_LocalVariableTable attribute = new Attribute_LocalVariableTable();
		attribute.localVariableTableList = localVariableTableList;

		return attribute;
	}

	@Override
	public void buildResolve() throws ClassFileException {
		LocalVariableTable localVariableTable;
		for ( int i=0; i<localVariableTableList.size(); ++i ) {
			localVariableTable = localVariableTableList.get( i );
			localVariableTable.name_cp.buildResolve();
			localVariableTable.name_index = localVariableTable.name_cp.index;
			localVariableTable.descriptor_cp.buildResolve();
			localVariableTable.descriptor_index = localVariableTable.descriptor_cp.index;
		}
	}

	@Override
	public byte[] build() throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		int local_variable_table_length = localVariableTableList.size();

		bytes.write( (byte)(local_variable_table_length >> 8) );
		bytes.write( (byte)(local_variable_table_length & 255) );

		LocalVariableTable localVariableTable;
		for ( int i=0; i<localVariableTableList.size(); ++i ) {
			localVariableTable = localVariableTableList.get( i );

			bytes.write( (byte)(localVariableTable.start_pc >> 8) );
			bytes.write( (byte)(localVariableTable.start_pc & 255) );

			bytes.write( (byte)(localVariableTable.length >> 8) );
			bytes.write( (byte)(localVariableTable.length & 255) );

			bytes.write( (byte)(localVariableTable.name_index >> 8) );
			bytes.write( (byte)(localVariableTable.name_index & 255) );

			bytes.write( (byte)(localVariableTable.descriptor_index >> 8) );
			bytes.write( (byte)(localVariableTable.descriptor_index & 255) );

			bytes.write( (byte)(localVariableTable.index >> 8) );
			bytes.write( (byte)(localVariableTable.index & 255) );
		}

		return bytes.toByteArray();
	}

}
