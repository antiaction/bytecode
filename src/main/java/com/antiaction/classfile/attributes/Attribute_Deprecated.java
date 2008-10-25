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

public class Attribute_Deprecated implements IAttribute {

	public static IAttribute parseDeprecated(ClassFileState cfs) throws ClassFileException {
		return new Attribute_Deprecated();
	}

}
