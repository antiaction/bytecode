/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;
import com.antiaction.bytecode.IAttribute;

public class Attribute_SourceFile implements IAttribute {

	String sourcefile;

	public static IAttribute parseSourceFile(ByteCodeState bcs) throws ByteCodeException {
		bcs.assert_unexpected_eof( 2 );

		int sourcefile_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		String sourcefile = bcs.constantpool.getUtf8( sourcefile_index );

		// debug
		System.out.println( "SourceFile = " + sourcefile );

		Attribute_SourceFile attribute = new Attribute_SourceFile();
		attribute.sourcefile = sourcefile;

		return attribute;
	}

}
