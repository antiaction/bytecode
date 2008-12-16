/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IConstantPool_Info;

public class ConstantPool_Double extends IConstantPool_Info {

	public int tag = ConstantPool.CONSTANT_Double;

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

	@Override
	public void parseResolve(ClassFileState cfs) {
	}

	@Override
	public void build(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		long l = Double.doubleToLongBits( d );

		bytes.write( (byte)(l >> 54) );
		bytes.write( (byte)(l >> 48) );
		bytes.write( (byte)(l >> 40) );
		bytes.write( (byte)(l >> 32) );
		bytes.write( (byte)(l >> 24) );
		bytes.write( (byte)(l >> 16) );
		bytes.write( (byte)(l >> 8) );
		bytes.write( (byte)(l & 255) );
	}

}
