/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode;

public class ByteCodeException extends Exception {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -8655786328628570857L;

	public ByteCodeException(String message, int index) {
		super( message + " (index = " + index + ")" );
	}

	public ByteCodeException(String message) {
		super( message );
	}

}
