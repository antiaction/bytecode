/*
 * Created on 14/10/2008
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

public class Attribute_Deprecated extends AttributeAbstract {

	public Attribute_Deprecated() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_1;
		usage = Constants.ATTR_LOCATION_CLASSFILE | Constants.ATTR_LOCATION_FIELD_INFO | Constants.ATTR_LOCATION_METHOD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
	}

	@Override
	public void resolve() throws ClassFileException {
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
	}

}
