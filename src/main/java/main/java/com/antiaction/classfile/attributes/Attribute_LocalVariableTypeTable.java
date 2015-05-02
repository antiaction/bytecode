package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_LocalVariableTypeTable extends AttributeAbstract {

	public List<LocalVariableTypeTable> localVariableTypeTableList;

	public Attribute_LocalVariableTypeTable() {
		classfileVersion = Constants.CLASSFILE_VERSION_49_0;
		jvmVersion = Constants.JVM_VERSION_5_0;
		usage = Constants.ATTR_LOCATION_CODE;
	}

	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		localVariableTypeTableList = new ArrayList<LocalVariableTypeTable>();
		LocalVariableTypeTable localVariableTypeTable;
		int local_variable_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( " Entries: " + local_variable_table_length );
		for ( int i=0; i<local_variable_table_length; ++i ) {
			localVariableTypeTable = new LocalVariableTypeTable();
			localVariableTypeTable.disassemble( cfs );
			localVariableTypeTableList.add( localVariableTypeTable );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		LocalVariableTypeTable localVariableTypeTable;
		for ( int i=0; i<localVariableTypeTableList.size(); ++i ) {
			localVariableTypeTable = localVariableTypeTableList.get( i );
			localVariableTypeTable.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int local_variable_type_table_length = localVariableTypeTableList.size();
		out.write( (byte)(local_variable_type_table_length >> 8) );
		out.write( (byte)(local_variable_type_table_length & 255) );
		LocalVariableTypeTable localVariableTypeTable;
		for ( int i=0; i<localVariableTypeTableList.size(); ++i ) {
			localVariableTypeTable = localVariableTypeTableList.get( i );
			localVariableTypeTable.assemble( out );
		}
	}

}
