/*
 * Created on 13/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IAttribute;

public class Attribute_ConstantValue implements IAttribute {

	public static IAttribute parseConstantValue(ClassFileState bcs) throws ClassFileException {
		bcs.assert_unexpected_eof( 2 );

		int constantvalue_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		return null;
	}

}
