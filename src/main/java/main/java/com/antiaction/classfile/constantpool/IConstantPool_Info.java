/*
 * Created on 09/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public abstract class IConstantPool_Info {

	public int tag;

	public Set<Object> referenced_by = new HashSet<Object>();

	public ConstantPool cp;

	public int index = 0;

	public abstract void parseResolve(ClassFileState cfs) throws ClassFileException;

	public abstract void buildResolve() throws ClassFileException;

	public abstract void build(ByteArrayOutputStream bytes) throws IOException;

}
