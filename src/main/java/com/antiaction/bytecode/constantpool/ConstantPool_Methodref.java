/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.constantpool;

import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;
import com.antiaction.bytecode.IConstantPool_Info;

public class ConstantPool_Methodref implements IConstantPool_Info {

	public int class_index;
	public int name_and_type_index;

	public static IConstantPool_Info parseMethodref(ByteCodeState bcs) throws ByteCodeException {
		bcs.assert_unexpected_eof( 4 );

		int class_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
		int name_and_type_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		// debug
		System.out.println( "Methodref: " + class_index + ", " + name_and_type_index );

		ConstantPool_Methodref cp_info = new ConstantPool_Methodref();
		cp_info.class_index = class_index;
		cp_info.name_and_type_index = name_and_type_index;

		return cp_info;
	}

}
