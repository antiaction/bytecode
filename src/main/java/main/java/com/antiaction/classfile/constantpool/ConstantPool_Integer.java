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

public class ConstantPool_Integer extends ConstantPool_Info {

	public int i;

	public ConstantPool_Integer() {
		tag = ConstantPool.CONSTANT_Integer;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );
		i = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "Integer: " + i );
	}

	@Override
	public void validate(ClassFileState cfs) throws ClassFileException {
	}

	@Override
	public void resolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(i >> 24) );
		bytes.write( (byte)(i >> 16) );
		bytes.write( (byte)(i >> 8) );
		bytes.write( (byte)(i & 255) );
	}

}
