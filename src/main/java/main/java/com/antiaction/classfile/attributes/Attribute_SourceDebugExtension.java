package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_SourceDebugExtension extends AttributeAbstract {

	public byte[] debug_extension;

	public Attribute_SourceDebugExtension() {
		classfileVersion = Constants.CLASSFILE_VERSION_49_0;
		jvmVersion = Constants.JVM_VERSION_5_0;
		usage = Constants.ATTR_LOCATION_CLASSFILE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( attribute_length );
		debug_extension = new byte[ attribute_length ];
		System.arraycopy( cfs.bytes, cfs.index, debug_extension, 0, attribute_length );
		cfs.index += attribute_length;
		// TODO parse modified utf8.
	}

	@Override
	public void resolve() throws ClassFileException {
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( debug_extension );
	}

}
