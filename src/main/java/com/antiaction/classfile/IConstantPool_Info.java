/*
 * Created on 09/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public abstract class IConstantPool_Info {

	public Set<Object> referenced_by = new HashSet<Object>();

	public int index = 0;

	public abstract void parseResolve(ClassFileState cfs);

	public abstract void build(ByteArrayOutputStream bytes) throws IOException;

}
