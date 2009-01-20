/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;
import com.antiaction.classfile.constantpool.ConstantPool;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Attribute_SourceFile extends IAttribute {

	public int sourcefile_index;
	public ConstantPool_Utf8 sourcefile_cp;
	public String sourcefile;

	public static IAttribute parseSourceFile(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int sourcefile_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		ConstantPool_Utf8 sourcefile_cp = cfs.cf.constantpool.getUtf8( sourcefile_index );
		String sourcefile = sourcefile_cp.utf8;

		// debug
		//System.out.println( "SourceFile = " + sourcefile );

		Attribute_SourceFile attribute = new Attribute_SourceFile();
		attribute.sourcefile_index = sourcefile_index;
		attribute.sourcefile_cp = sourcefile_cp;
		attribute.sourcefile = sourcefile;

		return attribute;
	}

	public static Attribute_SourceFile createSourceFil(ConstantPool cp, String sourcefile) throws ClassFileException {
		Attribute_SourceFile sourcefile_attr = new Attribute_SourceFile();
		sourcefile_attr.sourcefile = sourcefile;
		sourcefile_attr.sourcefile_cp = cp.putUtf8( sourcefile );
		return sourcefile_attr;
	}

	@Override
	public void buildResolve() throws ClassFileException {
		sourcefile_cp.buildResolve();
		sourcefile_index = sourcefile_cp.index;
	}

	@Override
	public byte[] build() throws IOException {
		byte[] bytes = new byte[ 2 ];
		bytes[ 0 ] = (byte)(sourcefile_index >> 8);
		bytes[ 1 ] = (byte)(sourcefile_index & 255);
		return bytes;
	}

}
