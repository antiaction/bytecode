package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Parameter extends BuildingBlockAbstract {

	public int name_index;

	public ConstantPool_Utf8 name_cp;

	public String name;

	public int access_flags;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		name_cp = cfs.cf.constantpool.getUtf8( name_index );
		name = name_cp.utf8;
		access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO check
		name_cp.resolve();
		name_index = name_cp.index;
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(name_index >> 8) );
		out.write( (byte)(name_index & 255) );
		out.write( (byte)(access_flags >> 8) );
		out.write( (byte)(access_flags & 255) );
	}

}
