/*
 * Created on 13/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class IAttribute {

	public int attribute_name_index;
	public String attribute_name;

	public abstract byte[] build() throws IOException;

}
