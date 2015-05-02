/*
 * Created on 13/10/2008
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
import com.antiaction.classfile.constantpool.IConstantPool_Info;

public class Attribute_ConstantValue extends AttributeAbstract {

	public int constantvalue_index;

	public IConstantPool_Info constantPool_ConstantValue;

	public Attribute_ConstantValue() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_0_2;
		usage = Constants.ATTR_LOCATION_FIELD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		constantvalue_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		constantPool_ConstantValue = cfs.cf.constantpool.getConstantValue( constantvalue_index );
		// TODO validate type appropriate to field.
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO add constant if not present in constants.
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(constantvalue_index >> 8) );
		out.write( (byte)(constantvalue_index & 255) );
	}

}
