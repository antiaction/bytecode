/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IConstantPool_Info;

public class ConstantPool_String extends IConstantPool_Info {

	public int tag = ConstantPool.CONSTANT_String;

	public int string_index;

	public static IConstantPool_Info parseString(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int string_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "String: " + string_index );

		ConstantPool_String cp_info = new ConstantPool_String();
		cp_info.string_index = string_index;

		return cp_info;
	}

	@Override
	public void parseResolve(ClassFileState cfs) {
	}

	@Override
	public void build(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(string_index >> 8) );
		bytes.write( (byte)(string_index & 255) );
	}

}
