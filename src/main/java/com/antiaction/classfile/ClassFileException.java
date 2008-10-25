/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

public class ClassFileException extends Exception {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = -8655786328628570857L;

	public ClassFileException(String message, int index) {
		super( message + " (index = " + index + ")" );
	}

	public ClassFileException(String message) {
		super( message );
	}

}
