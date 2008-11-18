/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

import java.io.File;

import com.antiaction.classfile.bytecode.BytecodeException;

public class Test1 {

	public static void main(String[] args) {
		Test1 p = new Test1();
		p.Main( args );
	}

	public void Main(String[] args) {
		/*
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
		*/

		File root = new File( "bin" );
		parseDir( root );
	}

	public void parseDir(File parent) {
		String[] files = parent.list();
		File file;

		for ( int i=0; i<files.length; ++i ) {
			file = new File( parent, files[ i ] );
			if ( file.isDirectory() ) {
				parseDir( file );
			}
			else if ( file.isFile() ) {
				parseClass( file );
			}
		}
	}

	public ClassFile parseClass(File file) {
		ClassFile classfile = null;
		try {
			classfile = ClassFile.parseClassFile( file );
		}
		catch (ClassFileException e) {
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			e.printStackTrace();
		}
		return classfile;
	}

	public ClassFile parseClass(String filename) {
		ClassFile classfile = null;
		try {
			classfile = ClassFile.parseClassFile( filename );
		}
		catch (ClassFileException e) {
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			e.printStackTrace();
		}
		return classfile;
	}

}
