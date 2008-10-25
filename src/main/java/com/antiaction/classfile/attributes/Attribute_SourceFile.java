/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;

public class Attribute_SourceFile implements IAttribute {

	String sourcefile;

	public static IAttribute parseSourceFile(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int sourcefile_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		String sourcefile = cfs.constantpool.getUtf8( sourcefile_index );

		// debug
		System.out.println( "SourceFile = " + sourcefile );

		Attribute_SourceFile attribute = new Attribute_SourceFile();
		attribute.sourcefile = sourcefile;

		return attribute;
	}

}
