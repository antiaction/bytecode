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

public class ConstantPool_Float implements IConstantPool_Info {

	public float f;

	public static IConstantPool_Info parseFloat(ClassFileState bcs) throws ClassFileException {
		bcs.assert_unexpected_eof( 4 );

		int i = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
		float f = Float.intBitsToFloat( i );

		// debug
		System.out.println( "Float: " + f );

		ConstantPool_Float cp_info = new ConstantPool_Float();
		cp_info.f = f;

		return cp_info;
	}

}
