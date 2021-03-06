/*
 * Created on 17/12/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.test;

import java.io.IOException;

import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.Constants;
import com.antiaction.classfile.bytecode.BytecodeException;

public class Test3 {

	public static void main(String[] args) {
		Test3 p = new Test3();
		p.Main( args );
	}

	public void Main(String[] args) {
		//ClassFile cf = ClassFile.createInstance();

		try {
			ClassFile cf = ClassFile.createInstance( "com.antiaction.classfile.test.Testing", "java.lang.Object", Constants.ACC_PUBLIC | Constants.ACC_SUPER );
			cf.setSourceFile( "Testing.java" );

			byte[] bytes = cf.assemble();
			ClassFile.disassembleClassFile( bytes );
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassFileException e) {
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			e.printStackTrace();
		}
	}

}
