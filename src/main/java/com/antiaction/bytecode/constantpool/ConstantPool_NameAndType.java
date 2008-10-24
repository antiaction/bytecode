/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.constantpool;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IConstantPool_Info;

public class ConstantPool_NameAndType implements IConstantPool_Info {

	public int name_index;
	public int descriptor_index;

	public static IConstantPool_Info parseNameAndType(ClassFileState bcs) throws ClassFileException {
		bcs.assert_unexpected_eof( 4 );

		int name_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
		int descriptor_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		// debug
		System.out.println( "NameAndType: " + name_index + ", " + descriptor_index );

		ConstantPool_NameAndType cp_info = new ConstantPool_NameAndType();
		cp_info.name_index = name_index;
		cp_info.descriptor_index = descriptor_index;

		return cp_info;
	}

}
