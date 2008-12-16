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

public class ConstantPool_NameAndType extends IConstantPool_Info {

	public int tag = ConstantPool.CONSTANT_NameAndType;

	public int name_index;
	public int descriptor_index;

	public static IConstantPool_Info parseNameAndType(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );

		int name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "NameAndType: " + name_index + ", " + descriptor_index );

		ConstantPool_NameAndType cp_info = new ConstantPool_NameAndType();
		cp_info.name_index = name_index;
		cp_info.descriptor_index = descriptor_index;

		return cp_info;
	}

	@Override
	public void parseResolve(ClassFileState cfs) {
	}

	@Override
	public void build(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(name_index >> 8) );
		bytes.write( (byte)(name_index & 255) );

		bytes.write( (byte)(descriptor_index >> 8) );
		bytes.write( (byte)(descriptor_index & 255) );
	}

}
