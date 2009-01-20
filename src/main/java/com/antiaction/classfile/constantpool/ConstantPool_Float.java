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

public class ConstantPool_Float extends IConstantPool_Info {

	public int tag = ConstantPool.CONSTANT_Float;

	public float f;

	public static IConstantPool_Info parseFloat(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );

		int i = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		float f = Float.intBitsToFloat( i );

		// debug
		//System.out.println( "Float: " + f );

		ConstantPool_Float cp_info = new ConstantPool_Float();
		cp_info.f = f;

		return cp_info;
	}

	@Override
	public void parseResolve(ClassFileState cfs) throws ClassFileException {
	}

	@Override
	public void buildResolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
		}
	}

	@Override
	public void build(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		int i = Float.floatToIntBits( f );

		bytes.write( (byte)(i >> 24) );
		bytes.write( (byte)(i >> 16) );
		bytes.write( (byte)(i >> 8) );
		bytes.write( (byte)(i & 255) );
	}

}
