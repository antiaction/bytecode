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

public class ConstantPool_Class implements IConstantPool_Info {

	public int name_index;

	public static IConstantPool_Info parseClass(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "Class: " + name_index );

		ConstantPool_Class cp_info = new ConstantPool_Class();
		cp_info.name_index = name_index;

		return cp_info;
	}

}
