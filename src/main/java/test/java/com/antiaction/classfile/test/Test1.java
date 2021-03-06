/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;

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

		//File root = new File( "bin" );
		File root = new File( "bin/com/antiaction/classfile/" );
		parseDir( root );
	}

	public void parseDir(File parent) {
		String[] files = parent.list();
		File file;
		ClassFile classfile = null;

		byte[] bytes;
		RandomAccessFile ram;

		for ( int i=0; i<files.length; ++i ) {
			file = new File( parent, files[ i ] );
			if ( file.isDirectory() ) {
				//parseDir( file );
			}
			else if ( file.isFile() ) {
				classfile = ParserHelpers.parseClass( file );
				if ( classfile != null ) {
					try {
						bytes = classfile.assemble();

						ram = new RandomAccessFile( new File( file.getParentFile(), file.getName() + ".class" ), "rw" );
						ram.write( bytes );
						ram.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					catch (ClassFileException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
