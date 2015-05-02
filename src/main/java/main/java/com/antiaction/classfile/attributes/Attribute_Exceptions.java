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

public class Attribute_Exceptions extends AttributeAbstract {

	public List<ExceptionIndexTable> exceptionIndexTableList;

	public Attribute_Exceptions() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_0_2;
		usage = Constants.ATTR_LOCATION_METHOD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		exceptionIndexTableList = new ArrayList<ExceptionIndexTable>();
		ExceptionIndexTable exceptionIndexTable;
		int number_of_exceptions = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( " Exceptions: " + number_of_exceptions );
		for ( int i=0; i<number_of_exceptions; ++i ) {
			exceptionIndexTable = new ExceptionIndexTable();
			exceptionIndexTable.disassemble( cfs );
			exceptionIndexTableList.add( exceptionIndexTable );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		ExceptionIndexTable exceptionIndexTable;
		for ( int i=0; i<exceptionIndexTableList.size(); ++i ) {
			exceptionIndexTable = exceptionIndexTableList.get( i );
			exceptionIndexTable.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int number_of_exceptions = exceptionIndexTableList.size();
		out.write( (byte)(number_of_exceptions >> 8) );
		out.write( (byte)(number_of_exceptions & 255) );
		ExceptionIndexTable exceptionIndexTable;
		for ( int i=0; i<exceptionIndexTableList.size(); ++i ) {
			exceptionIndexTable = exceptionIndexTableList.get( i );
			exceptionIndexTable.assemble( out );
		}
	}

}
