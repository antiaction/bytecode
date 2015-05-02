package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class Table extends BuildingBlockAbstract {

	public int start_pc;

	public int length;

	public int index;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO validate indexes etc.
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(start_pc >> 8) );
		out.write( (byte)(start_pc & 255) );
		out.write( (byte)(length >> 8) );
		out.write( (byte)(length & 255) );
		out.write( (byte)(index >> 8) );
		out.write( (byte)(index & 255) );
	}

}
