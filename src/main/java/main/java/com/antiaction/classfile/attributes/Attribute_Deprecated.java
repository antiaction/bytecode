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
import com.antiaction.classfile.AttributeAbstrsct;

public class Attribute_Deprecated extends AttributeAbstrsct {

	public static AttributeAbstrsct parseDeprecated(ClassFileState cfs) throws ClassFileException {
		return new Attribute_Deprecated();
	}

	@Override
	public void buildResolve() throws ClassFileException {
	}

	@Override
	public byte[] build() throws IOException {
		return new byte[ 0 ];
	}

}
