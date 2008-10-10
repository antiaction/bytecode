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

public class ConstantPool_String implements IConstantPool_Info {

	public int string_index;

	public static IConstantPool_Info parseString(ByteCodeState bcs) throws ByteCodeException {
		bcs.assert_unexpected_eof( 2 );

		int string_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		// debug
		System.out.println( "String: " + string_index );

		ConstantPool_String cp_info = new ConstantPool_String();
		cp_info.string_index = string_index;

		return cp_info;
	}

}
