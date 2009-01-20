/*
 * Created on 22/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class LocalVariableTable {

	int start_pc;
	int length;

	int name_index;
	ConstantPool_Utf8 name_cp;
	String name;

	int descriptor_index;
	ConstantPool_Utf8 descriptor_cp;
	String descriptor_string;

	int index;

}
