package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_AnnotationDefault extends AttributeAbstract {

	public ElementValue default_value;

	public Attribute_AnnotationDefault() {
		classfileVersion = Constants.CLASSFILE_VERSION_49_0;
		jvmVersion = Constants.JVM_VERSION_5_0;
		usage = Constants.ATTR_LOCATION_METHOD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		default_value = new ElementValue();
		default_value.disassemble( cfs );
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO maybe resolve some stuff...
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		default_value.assemble( out );
	}

}
