/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IAttribute;

public class Attribute_Exceptions implements IAttribute {

	public List<ExceptionIndexTable> exceptionIndexTableList;

	public static IAttribute parseExceptions(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		List<ExceptionIndexTable> exceptionIndexTableList = new ArrayList<ExceptionIndexTable>();
		ExceptionIndexTable exceptionIndexTable;

		int exception_index;
		String exception_name;

		int number_of_exceptions = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( " Exceptions: " + number_of_exceptions );

		for ( int i=0; i<number_of_exceptions; ++i ) {
			cfs.assert_unexpected_eof( 2 );

			exception_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			exception_name = cfs.constantpool.getClassName( exception_index );

			exceptionIndexTable = new ExceptionIndexTable();
			exceptionIndexTable.exception_index = exception_index;
			exceptionIndexTable.exception_name = exception_name;
			exceptionIndexTableList.add( exceptionIndexTable );
		}

		Attribute_Exceptions attribute = new Attribute_Exceptions();
		attribute.exceptionIndexTableList = exceptionIndexTableList;

		return attribute;
	}

}
