/*
 * Created on 08/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

public class ClassFileState {

	public byte[] bytes;
	public int index = 0;

	public ClassFile cf;

	public ClassFileState(byte[] bytes) {
		this.bytes = bytes;
	}

	public void assert_unexpected_eof(int length) throws ClassFileException {
		if ( index + length > bytes.length ) {
			throw new ClassFileException( "to be continued...", index );
		}
	}

}
