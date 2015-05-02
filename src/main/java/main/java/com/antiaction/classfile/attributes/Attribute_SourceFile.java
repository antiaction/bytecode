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
import com.antiaction.classfile.constantpool.ConstantPool;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Attribute_SourceFile extends AttributeAbstract {

	public int sourcefile_index;

	public ConstantPool_Utf8 sourcefile_cp;

	public String sourcefile;

	public Attribute_SourceFile() {
		classfileVersion = Constants.CLASSFILE_VERSION_45_3;
		jvmVersion = Constants.JVM_VERSION_1_0_2;
		usage = Constants.ATTR_LOCATION_CLASSFILE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		sourcefile_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		sourcefile_cp = cfs.cf.constantpool.getUtf8( sourcefile_index );
		sourcefile = sourcefile_cp.utf8;

		// debug
		//System.out.println( "SourceFile = " + sourcefile );
	}

	public static Attribute_SourceFile createSourceFile(ConstantPool cp, String sourcefile) throws ClassFileException {
		Attribute_SourceFile sourcefile_attr = new Attribute_SourceFile();
		sourcefile_attr.sourcefile = sourcefile;
		sourcefile_attr.sourcefile_cp = cp.putUtf8( sourcefile );
		return sourcefile_attr;
	}

	@Override
	public void resolve() throws ClassFileException {
		sourcefile_cp.buildResolve();
		sourcefile_index = sourcefile_cp.index;
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(sourcefile_index >> 8) );
		out.write( (byte)(sourcefile_index & 255) );
	}

}
