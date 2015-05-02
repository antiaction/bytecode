package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class TypePath extends Annotation {

	public List<Path> pathList;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		int path_length = (cfs.bytes[ cfs.index++ ] & 255);
		pathList = new ArrayList<Path>();
		Path path;
		for ( int i=0; i<path_length; ++i ) {
			path = new Path();
			path.disassemble( cfs );
			pathList.add( path );
		}
		super.disassemble( cfs );
	}

	@Override
	public void resolve() throws ClassFileException {
		int path_length = pathList.size();
		Path path;
		for ( int i=0; i<path_length; ++i ) {
			path = pathList.get( i );
			path.resolve();
		}
		super.resolve();
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int path_length = pathList.size();
		out.write( (byte)(path_length & 255) );
		Path path;
		for ( int i=0; i<path_length; ++i ) {
			path = pathList.get( i );
			path.assemble( out );
		}
		super.assemble( out );
	}

}
