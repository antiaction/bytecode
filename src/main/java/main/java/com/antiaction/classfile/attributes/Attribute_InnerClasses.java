/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_InnerClasses extends AttributeAbstract {

	public List<InnerClassTable> innerClassTableList = new ArrayList<InnerClassTable>();

	public Attribute_InnerClasses() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_1;
		usage = Constants.ATTR_LOCATION_CLASSFILE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		int number_of_classes = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		innerClassTableList = new ArrayList<InnerClassTable>();
		InnerClassTable innerClassTable;
		// debug
		//System.out.println( " Entries: " + number_of_classes );
		for ( int i=0; i<number_of_classes; ++i ) {
			innerClassTable = new InnerClassTable();
			innerClassTable.disassemble( cfs );
			innerClassTableList.add( innerClassTable );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		InnerClassTable innerClassTable;
		for ( int i=0; i<innerClassTableList.size(); ++i ) {
			innerClassTable = innerClassTableList.get( i );
			innerClassTable.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int number_of_classes = innerClassTableList.size();
		out.write( (byte)(number_of_classes >> 8) );
		out.write( (byte)(number_of_classes & 255) );
		InnerClassTable innerClassTable;
		for ( int i=0; i<innerClassTableList.size(); ++i ) {
			innerClassTable = innerClassTableList.get( i );
			innerClassTable.assemble( out );
		}
	}

}
