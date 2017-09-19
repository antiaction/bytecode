/*
 * Created on 03/01/2009
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
import com.antiaction.classfile.bytecode.BytecodeException;

public class Test2 {

	public static void main(String[] args) {
		Test2 p = new Test2();
		p.Main( args );
	}

	public void Main(String[] args) {
		//File root = new File( "bin" );
		//File root = new File( "D:\\[Java-work]\\workspace\\" );
		//File root = new File( "bin/com/antiaction/classfile/" );
		File root = new File( "C:\\data\\[Java-work]\\workspace\\" );
		parseDir( root );

		System.out.println( loaded );
		System.out.println( parsed );
		System.out.println( built );
		System.out.println( equal );
		System.out.println( diff );
	}

	int loaded = 0;
	int parsed = 0;
	int built = 0;
	int equal = 0;
	int diff = 0;

	public void parseDir(File parent) {
		String[] files = parent.list();
		File file;
		ClassFile classfile = null;

		RandomAccessFile ram;
		byte[] bytes_org;
		byte[] bytes_new;

		for ( int i=0; i<files.length; ++i ) {
			file = new File( parent, files[ i ] );
			if ( file.isDirectory() ) {
				parseDir( file );
			}
			else if ( file.isFile() ) {
				if ( file.getName().toLowerCase().endsWith( ".class" ) )
				try {
					ram = new RandomAccessFile( file, "r" );
					bytes_org = new byte[ (int)ram.length() ];
					ram.readFully( bytes_org );

					++loaded;
					classfile = ClassFile.disassembleClassFile( file );
					if ( classfile != null ) {
						++parsed;
						bytes_new = classfile.assemble();
						if ( bytes_new != null ) {
							++built;
							if ( ParserHelpers.compare( bytes_org, bytes_new ) ) {
								++equal;
							}
							else {
								System.out.println( file.getName() + " " + bytes_org.length + " " + bytes_new.length );
								ParserHelpers.diff( bytes_org, bytes_new );
								System.out.println( classfile.toString() );
								++diff;
							}
						}
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				catch (ClassFileException e) {
					System.out.println( file.getPath() );
					e.printStackTrace();
				}
				catch (BytecodeException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
