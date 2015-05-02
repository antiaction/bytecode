package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_MethodParameters extends AttributeAbstract {

	public List<Parameter> parameters;

	public Attribute_MethodParameters() {
		classfileVersion = Constants.CLASSFILE_VERSION_52_0;
		jvmVersion = Constants.JVM_VERSION_8;
		usage = Constants.ATTR_LOCATION_METHOD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		int parameters_count = (cfs.bytes[ cfs.index++ ] & 255);
		parameters = new ArrayList<Parameter>();
		Parameter parameter;
		for ( int i=0; i<parameters_count; ++i ) {
			parameter = new Parameter();
			parameter.disassemble( cfs );
			parameters.add( parameter );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		int parameters_count = parameters.size();
		Parameter parameter;
		for ( int i=0; i<parameters_count; ++i ) {
			parameter = parameters.get( i );
			parameter.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int parameters_count = parameters.size();
		out.write( (byte)(parameters_count & 255) );
		Parameter parameter;
		for ( int i=0; i<parameters_count; ++i ) {
			parameter = parameters.get( i );
			parameter.assemble( out );
		}
	}

}
