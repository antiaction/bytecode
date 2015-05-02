package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class BootstrapArgument extends BuildingBlockAbstract {

	public int bootstrap_argument;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		bootstrap_argument = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve!
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(bootstrap_argument >> 8) );
		out.write( (byte)(bootstrap_argument & 255) );
	}

}
