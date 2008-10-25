/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode;

public class Test1 {

	public static void main(String[] args) {
		ClassFile classfile;
		try {
			classfile = ClassFile.parseClassFile( "bin/com/antiaction/bytecode/ClassFile.class" );

			classfile = ClassFile.parseClassFile( "bin/com/antiaction/bytecode/ClassFileState.class" );

			classfile = ClassFile.parseClassFile( "bin/com/antiaction/bytecode/IconstantPool_Info.class" );

			classfile = ClassFile.parseClassFile( "bin/com/antiaction/bytecode/ClassFileException.class" );
		}
		catch (ClassFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
