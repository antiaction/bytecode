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

public class ConstantPool_Long extends ConstantPool_Info {

	public long l;

	public ConstantPool_Long() {
		tag = ConstantPool.CONSTANT_Long;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 8 );
		l = (long)(cfs.bytes[ cfs.index++ ] & 255) << 56;
		l |= (long)(cfs.bytes[ cfs.index++ ] & 255) << 48;
		l |= (long)(cfs.bytes[ cfs.index++ ] & 255) << 40;
		l |= (long)(cfs.bytes[ cfs.index++ ] & 255) << 32;
		l |= (long)(cfs.bytes[ cfs.index++ ] & 255) << 24;
		l |= (long)(cfs.bytes[ cfs.index++ ] & 255) << 16;
		l |= (long)(cfs.bytes[ cfs.index++ ] & 255) << 8;
		l |= (long)cfs.bytes[ cfs.index++ ] & 255;
		// debug
		//System.out.println( "Long: " + l );
	}

	@Override
	public void validate(ClassFileState cfs) throws ClassFileException {
	}

	@Override
	public void resolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
			cp.constantpool_infolist.add( null );
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(l >> 56) );
		bytes.write( (byte)(l >> 48) );
		bytes.write( (byte)(l >> 40) );
		bytes.write( (byte)(l >> 32) );
		bytes.write( (byte)(l >> 24) );
		bytes.write( (byte)(l >> 16) );
		bytes.write( (byte)(l >> 8) );
		bytes.write( (byte)(l & 255) );
	}

}
