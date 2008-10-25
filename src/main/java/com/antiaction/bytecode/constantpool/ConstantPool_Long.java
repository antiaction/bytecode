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

public class ConstantPool_Long implements IConstantPool_Info {

	public long l;

	public static IConstantPool_Info parseLong(ClassFileState cfs) throws ClassFileException {
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

		// debug
		System.out.println( "Long: " + l );

		ConstantPool_Long cp_info = new ConstantPool_Long();
		cp_info.l = l;

		return cp_info;
	}

}
