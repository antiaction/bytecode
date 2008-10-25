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

public class ConstantPool_InterfaceMethodref implements IConstantPool_Info {

	public int class_index;
	public int name_and_type_index;

	public static IConstantPool_Info parseInterfaceMethodref(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );

		int class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int name_and_type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "InterfaceMethodref: " + class_index + ", " + name_and_type_index );

		ConstantPool_InterfaceMethodref cp_info = new ConstantPool_InterfaceMethodref();
		cp_info.class_index = class_index;
		cp_info.name_and_type_index = name_and_type_index;

		return cp_info;
	}

}
