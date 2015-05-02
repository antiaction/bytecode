/*
 * Created on 22/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class ExceptionIndexTable extends BuildingBlockAbstract {

	public int exception_index;

	public String exception_name;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		exception_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		exception_name = cfs.cf.constantpool.getClassName( exception_index );
		// TODO validate etc.
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO Add exception name to constant pool.
	}

	@Override
	public void assemble(ByteArrayOutputStream out) {
		out.write( (byte)(exception_index >> 8) );
		out.write( (byte)(exception_index & 255) );
	}

}
