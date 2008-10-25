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

public class ConstantPool_Double implements IConstantPool_Info {

	public double d;

	public static IConstantPool_Info parseDouble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 8 );

		long l;
		l = (cfs.bytes[ cfs.index++ ] & 255) << 56;
		l |= (cfs.bytes[ cfs.index++ ] & 255) << 48;
		l |= (cfs.bytes[ cfs.index++ ] & 255) << 40;
		l |= (cfs.bytes[ cfs.index++ ] & 255) << 32;
		l |= (cfs.bytes[ cfs.index++ ] & 255) << 24;
		l |= (cfs.bytes[ cfs.index++ ] & 255) << 16;
		l |= (cfs.bytes[ cfs.index++ ] & 255) << 8;
		l |= cfs.bytes[ cfs.index++ ] & 255;
		double d = Double.longBitsToDouble( l );

		// debug
		System.out.println( "Double: " + d );

		ConstantPool_Double cp_info = new ConstantPool_Double();
		cp_info.d = d;

		return cp_info;
	}

}
