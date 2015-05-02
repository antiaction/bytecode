package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class Path extends BuildingBlockAbstract {

	public int type_path_kind;

	public int type_argument_index;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		type_path_kind = (cfs.bytes[ cfs.index++ ] & 255);
		type_argument_index = (cfs.bytes[ cfs.index++ ] & 255);
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve index
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(type_path_kind & 255) );
		out.write( (byte)(type_argument_index & 255) );
	}

}
