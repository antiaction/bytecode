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

public class ConstantPool_Double implements IConstantPool_Info {

	public double d;

	public static IConstantPool_Info parseDouble(ByteCodeState bcs) throws ByteCodeException {
		bcs.assert_unexpected_eof( 8 );

		long l;
		l = (bcs.bytes[ bcs.index++ ] & 255) << 56;
		l |= (bcs.bytes[ bcs.index++ ] & 255) << 48;
		l |= (bcs.bytes[ bcs.index++ ] & 255) << 40;
		l |= (bcs.bytes[ bcs.index++ ] & 255) << 32;
		l |= (bcs.bytes[ bcs.index++ ] & 255) << 24;
		l |= (bcs.bytes[ bcs.index++ ] & 255) << 16;
		l |= (bcs.bytes[ bcs.index++ ] & 255) << 8;
		l |= bcs.bytes[ bcs.index++ ] & 255;
		double d = Double.longBitsToDouble( l );

		// debug
		System.out.println( "Double: " + d );

		ConstantPool_Double cp_info = new ConstantPool_Double();
		cp_info.d = d;

		return cp_info;
	}

}
