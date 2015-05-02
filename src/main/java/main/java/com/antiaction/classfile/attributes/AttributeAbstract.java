/*
 * Created on 13/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ITraceHandler;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public abstract class AttributeAbstract extends BuildingBlockAbstract {

	public int classfileVersion;

	public int jvmVersion;

	public int usage;

	protected ITraceHandler traceHandler;

	public int attribute_name_index;

	public ConstantPool_Utf8 attribute_name_cp;

	public String attribute_name;

	public int attribute_length;

}
