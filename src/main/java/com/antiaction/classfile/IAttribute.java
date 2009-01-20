/*
 * Created on 13/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

import java.io.IOException;

import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public abstract class IAttribute {

	public int attribute_name_index;
	public ConstantPool_Utf8 attribute_name_cp;
	public String attribute_name;

	public abstract void buildResolve() throws ClassFileException;

	public abstract byte[] build() throws IOException;

}
