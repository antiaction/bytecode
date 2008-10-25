/*
 * Created on 13/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IAttribute;
import com.antiaction.bytecode.IConstantPool_Info;

public class Attribute_ConstantValue implements IAttribute {

	public IConstantPool_Info constantPool_ConstantValue;

	public static IAttribute parseConstantValue(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int constantvalue_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		IConstantPool_Info constantPool_ConstantValue = cfs.constantpool.getConstantValue( constantvalue_index );

		Attribute_ConstantValue attribute = new Attribute_ConstantValue();
		attribute.constantPool_ConstantValue = constantPool_ConstantValue;

		return attribute;
	}

}
