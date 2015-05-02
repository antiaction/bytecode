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

public class Attribute_Code extends AttributeAbstract {

	public int max_stack;

	public int max_locals;

	public byte[] code;

	public List<ExceptionTable> exceptionTableList;

	public Attributes attributes;

	public Attribute_Code() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_0_2;
		usage = Constants.ATTR_LOCATION_METHOD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 8 );
		max_stack = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		max_locals = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int code_length = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		cfs.assert_unexpected_eof( code_length );
		code = new byte[ code_length ];
		System.arraycopy( cfs.bytes, cfs.index, code, 0, code_length );
		cfs.index += code_length;
		exceptionTableList = new ArrayList<ExceptionTable>();
		ExceptionTable exceptionTable;
		int exception_table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		for ( int i=0; i<exception_table_length; ++i ) {
			exceptionTable = new ExceptionTable();
			exceptionTable.disassemble( cfs );
			exceptionTableList.add( exceptionTable );
		}
		attributes = new Attributes( traceHandler );
		attributes.disassemble( cfs );
	}

	@Override
	public void resolve() throws ClassFileException {
		attributes.resolve();
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(max_stack >> 8) );
		out.write( (byte)(max_stack & 255) );
		out.write( (byte)(max_locals >> 8) );
		out.write( (byte)(max_locals & 255) );
		int code_length = code.length;
		out.write( (byte)(code_length >> 24) );
		out.write( (byte)(code_length >> 16) );
		out.write( (byte)(code_length >> 8) );
		out.write( (byte)(code_length & 255) );
		out.write( code );
		int exception_table_length = exceptionTableList.size();
		out.write( (byte)(exception_table_length >> 8) );
		out.write( (byte)(exception_table_length & 255) );
		ExceptionTable exceptionTable;
		for ( int i=0; i<exceptionTableList.size(); ++i ) {
			exceptionTable = exceptionTableList.get( i );
			exceptionTable.assemble( out );
		}
		attributes.assemble( out );
	}

}
