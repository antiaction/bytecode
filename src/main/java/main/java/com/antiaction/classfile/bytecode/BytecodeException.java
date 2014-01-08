/*
 * Created on 13/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

public class BytecodeException extends Exception {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -7191489877648448692L;

	public BytecodeException(String message, int index) {
		super( message + " (index = " + index + ")" );
	}

	public BytecodeException(String message) {
		super( message );
	}

}
