/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

public class Test1 {

	public static void main(String[] args) {
		ClassFile classfile;
		try {
			classfile = ClassFile.parseClassFile( "bin/com/antiaction/classfile/ClassFile.class" );

			classfile = ClassFile.parseClassFile( "bin/com/antiaction/classfile/ClassFileState.class" );

			classfile = ClassFile.parseClassFile( "bin/com/antiaction/classfile/IconstantPool_Info.class" );

			classfile = ClassFile.parseClassFile( "bin/com/antiaction/classfile/ClassFileException.class" );
		}
		catch (ClassFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
