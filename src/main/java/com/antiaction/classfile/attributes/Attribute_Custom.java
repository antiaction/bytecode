/*
 * Created on 14/12/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;

public class Attribute_Custom extends IAttribute {

	public byte[] bytes;

	public static IAttribute parseCustom(ClassFileState cfs, int attribute_length) throws ClassFileException {
		cfs.assert_unexpected_eof( attribute_length );

		byte[] bytes = new byte[ attribute_length ];
		System.arraycopy( cfs.bytes, cfs.index, bytes, 0, attribute_length );
		cfs.index += attribute_length;

		Attribute_Custom attribute = new Attribute_Custom();
		attribute.bytes = bytes;

		return attribute;
	}

	@Override
	public byte[] build() throws IOException {
		return bytes;
	}

}
