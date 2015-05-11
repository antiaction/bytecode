/*
 * Created on 09/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import java.util.HashSet;
import java.util.Set;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public abstract class ConstantPool_Info extends BuildingBlockAbstract {

	public int tag;

	public Set<Object> referenced_by = new HashSet<Object>();

	public ConstantPool cp;

	public int index = 0;

	public abstract void validate(ClassFileState cfs) throws ClassFileException;

}
