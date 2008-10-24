/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IAttribute;

public class Attribute_Synthetic implements IAttribute {

	public static IAttribute parseSynthetic(ClassFileState bcs) throws ClassFileException {
		return new Attribute_Synthetic();
	}

}
