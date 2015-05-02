/*
 * Created on 14/12/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_Custom extends AttributeAbstract {

	public byte[] bytes;

	public Attribute_Custom() {
		usage = Constants.ATTR_LOCATION_CLASSFILE | Constants.ATTR_LOCATION_FIELD_INFO | Constants.ATTR_LOCATION_METHOD_INFO | Constants.ATTR_LOCATION_CODE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( attribute_length );
		bytes = new byte[ attribute_length ];
		System.arraycopy( cfs.bytes, cfs.index, bytes, 0, attribute_length );
		cfs.index += attribute_length;
	}

	@Override
	public void resolve() throws ClassFileException {
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( bytes );
	}

}
