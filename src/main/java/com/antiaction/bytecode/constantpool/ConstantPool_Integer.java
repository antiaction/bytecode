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

public class ConstantPool_Integer implements IConstantPool_Info {

	public int i;

	public static IConstantPool_Info parseInteger(ClassFileState bcs) throws ClassFileException {
		bcs.assert_unexpected_eof( 4 );

		int i = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		// debug
		System.out.println( "Integer: " + i );

		ConstantPool_Integer cp_info = new ConstantPool_Integer();
		cp_info.i = i;

		return cp_info;
	}

}
