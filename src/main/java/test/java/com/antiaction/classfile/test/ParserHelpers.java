package com.antiaction.classfile.test;

import java.io.File;

import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.bytecode.BytecodeException;

public class ParserHelpers {

	public static ClassFile parseClass(File file) {
		ClassFile classfile = null;
		try {
			classfile = ClassFile.disassembleClassFile( file );
		}
		catch (ClassFileException e) {
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			e.printStackTrace();
		}
		return classfile;
	}

	public static ClassFile parseClass(String filename) {
		ClassFile classfile = null;
		try {
			classfile = ClassFile.disassembleClassFile( filename );
		}
		catch (ClassFileException e) {
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			e.printStackTrace();
		}
		return classfile;
	}

	public static boolean compare(byte[] bytes1, byte[] bytes2) {
		boolean res;
		int index;
		if ( bytes1.length == bytes2.length ) {
			index = 0;
			res = true;
			while ( index < bytes1.length && res ) {
				if ( index < bytes1.length ) {
					if ( bytes1[ index ] != bytes2[ index ] ) {
						res = false;
					}
					else {
						++index;
					}
				}
			}
		}
		else {
			res = false;
		}
		return res;
	}

	public static void diff(byte[] bytes1, byte[] bytes2) {
		boolean b;
		int index;
		if ( bytes1.length == bytes2.length ) {
			index = 0;
			b = true;
			while ( b ) {
				if ( index < bytes1.length ) {
					if ( bytes1[ index ] != bytes2[ index ] ) {
						System.out.println( index + " " + bytes1[ index ] + " " + bytes2[ index ] );
						//b = false;
						++index;
					}
					else {
						++index;
					}
				}
				else {
					b = false;
				}
			}
		}
		else {
			b = false;
		}
	}

}
