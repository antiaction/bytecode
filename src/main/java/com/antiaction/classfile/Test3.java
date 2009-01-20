/*
 * Created on 17/12/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

import java.io.IOException;

import com.antiaction.classfile.bytecode.BytecodeException;

public class Test3 {

	public static void main(String[] args) {
		Test3 p = new Test3();
		p.Main( args );
	}

	public void Main(String[] args) {
		//ClassFile cf = ClassFile.createInstance();

		try {
			ClassFile cf = ClassFile.createInstance( "com.antiaction.classfile.test.Testing", "java.lang.Object", ClassFile.ACC_PUBLIC | ClassFile.ACC_SUPER );
			cf.setSourceFile( "Testing.java" );

			byte[] bytes = cf.build();
			ClassFile.parseClassFile( bytes );
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
