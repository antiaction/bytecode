package com.antiaction.classfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class BuildingBlockAbstract {

	public abstract void disassemble(ClassFileState cfs) throws ClassFileException;

	public abstract void resolve() throws ClassFileException;

	public abstract void assemble(ByteArrayOutputStream out) throws IOException;

}
