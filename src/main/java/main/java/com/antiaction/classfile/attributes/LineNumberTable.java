/*
 * Created on 21/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class LineNumberTable extends BuildingBlockAbstract {

	public int start_pc;

	public int line_number;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );
		start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		line_number = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// TODO validate start_pc
	}

	@Override
	public void resolve() throws ClassFileException {
	}

	@Override
	public void assemble(ByteArrayOutputStream out) {
		out.write( (byte)(start_pc >> 8) );
		out.write( (byte)(start_pc & 255) );
		out.write( (byte)(line_number >> 8) );
		out.write( (byte)(line_number & 255) );
	}

}
