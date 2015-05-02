package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_StackMapTable extends AttributeAbstract {

	public List<StackMapFrame> entries;

	public Attribute_StackMapTable() {
		classfileVersion = Constants.CLASSFILE_VERSION_50_0;
		jvmVersion = Constants.JVM_VERSION_6;
		usage = Constants.ATTR_LOCATION_CODE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		int number_of_entries = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		entries = new ArrayList<StackMapFrame>();
		StackMapFrame stackMapFrame;
		for ( int i=0; i<number_of_entries; ++i ) {
			stackMapFrame = new StackMapFrame();
			stackMapFrame.disassemble( cfs );
			entries.add( stackMapFrame );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve?
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int number_of_entries = entries.size();
		out.write( (byte)(number_of_entries >> 8) );
		out.write( (byte)(number_of_entries & 255) );
		StackMapFrame stackMapFrame;
		for ( int i=0; i<number_of_entries; ++i ) {
			stackMapFrame = entries.get( i );
			stackMapFrame.assemble( out );
		}
	}

}
