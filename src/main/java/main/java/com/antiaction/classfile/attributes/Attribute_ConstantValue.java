/*
 * Created on 13/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.AttributeAbstrsct;
import com.antiaction.classfile.IConstantPool_Info;

public class Attribute_ConstantValue extends AttributeAbstrsct {

	public int constantvalue_index;
	public IConstantPool_Info constantPool_ConstantValue;

	public static AttributeAbstrsct parseConstantValue(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int constantvalue_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		IConstantPool_Info constantPool_ConstantValue = cfs.cf.constantpool.getConstantValue( constantvalue_index );

		Attribute_ConstantValue attribute = new Attribute_ConstantValue();
		attribute.constantvalue_index = constantvalue_index;
		attribute.constantPool_ConstantValue = constantPool_ConstantValue;

		return attribute;
	}

	@Override
	public void buildResolve() throws ClassFileException {
	}

	@Override
	public byte[] build() throws IOException {
		byte[] bytes = new byte[ 2 ];
		bytes[ 0 ] = (byte)(constantvalue_index >> 8);
		bytes[ 1 ] = (byte)(constantvalue_index & 255);
		return bytes;
	}

}
