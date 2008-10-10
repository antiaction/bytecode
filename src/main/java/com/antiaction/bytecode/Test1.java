/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode;

public class Test1 {

	public static void main(String[] args) {
		ByteCode bytecode;
		try {
			bytecode = ByteCode.parseClassFile( "bin/com/antiaction/bytecode/ByteCode.class" );

			bytecode = ByteCode.parseClassFile( "bin/com/antiaction/bytecode/ByteCodeState.class" );

			bytecode = ByteCode.parseClassFile( "bin/com/antiaction/bytecode/IconstantPool_Info.class" );

			bytecode = ByteCode.parseClassFile( "bin/com/antiaction/bytecode/ByteCodeException.class" );
		}
		catch (ByteCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
