/*
 * Created on 09/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

public abstract class IConstantPool_Info {

	public int index = 0;

	public abstract void parseResolve(ClassFileState cfs);

}
