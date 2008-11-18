/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IConstantPool_Info;

public class ConstantPool_Methodref extends IConstantPool_Info {

	public int class_index;
	public int name_and_type_index;

	public static IConstantPool_Info parseMethodref(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );

		int class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int name_and_type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "Methodref: " + class_index + ", " + name_and_type_index );

		ConstantPool_Methodref cp_info = new ConstantPool_Methodref();
		cp_info.class_index = class_index;
		cp_info.name_and_type_index = name_and_type_index;

		return cp_info;
	}

	@Override
	public void parseResolve(ClassFileState cfs) {
	}

}
