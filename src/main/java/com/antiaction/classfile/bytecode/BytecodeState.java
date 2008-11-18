/*
 * Created on 16/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

public class BytecodeState {

	public byte[] bytes;
	public int index = 0;

	public BytecodeState(byte[] bytes) {
		this.bytes = bytes;
	}

	public void assert_unexpected_eof(int length) throws BytecodeException {
		if ( index + length > bytes.length ) {
			throw new BytecodeException( "to be continued...", index );
		}
	}
}
