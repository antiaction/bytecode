package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

// TODO resolve class and method.
public class Attribute_EnclosingMethod extends AttributeAbstract {

	public int class_index;

	public int method_index;

	public Attribute_EnclosingMethod() {
		classfileVersion = Constants.CLASSFILE_VERSION_49_0;
		jvmVersion = Constants.JVM_VERSION_5_0;
		usage = Constants.ATTR_LOCATION_CLASSFILE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );
		class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		method_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// TODO validate
	}

	@Override
	public void resolve() throws ClassFileException {
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(class_index >> 8) );
		out.write( (byte)(class_index & 255) );
		out.write( (byte)(method_index >> 8) );
		out.write( (byte)(method_index & 255) );
	}

}
