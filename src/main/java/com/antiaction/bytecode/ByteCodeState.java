/*
 * Created on 08/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode;


public class ByteCodeState {

	public byte[] bytes;
	public int index = 0;

	public ConstantPool constantpool;

	public ByteCodeState(byte[] bytes) {
		this.bytes = bytes;
	}

	public void assert_unexpected_eof(int length) throws ByteCodeException {
		if ( index + length > bytes.length ) {
			throw new ByteCodeException( "to be continued...", index );
		}
	}

}
