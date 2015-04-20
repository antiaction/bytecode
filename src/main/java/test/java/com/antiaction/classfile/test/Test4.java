package com.antiaction.classfile.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.bytecode.BytecodeException;

public class Test4 {

	public static void main(String[] args) {
		Test4 p = new Test4();
		p.Main( args );
	}

	public void Main(String[] args) {
		File testResources = TestHelpers.getTestResourceFile( "" );
		File libFile = new File( testResources, "lib" );

		parseDir( libFile );

		System.out.println( "   Jars: " + jars );
		System.out.println( "Classes: " + classes );
		System.out.println( " Loaded: " + loaded );
		System.out.println( " Parsed: " + parsed );
		System.out.println( "  Built: " + built );
		System.out.println( "  Equal: " + equal );
		System.out.println( "   Diff: " + diff );
	}

	int jars = 0;
	int classes = 0;
	int loaded = 0;
	int parsed = 0;
	int built = 0;
	int equal = 0;
	int diff = 0;

	public void parseDir(File parent) {
		String[] files = parent.list();
		File file;

		JarFile jarFile;
		RandomAccessFile ram;
		InputStream in;
		int read;
		int pos;
		byte[] tmpBuf = new byte[ 8192 ];
		byte[] bytes_org;

		for ( int i=0; i<files.length; ++i ) {
			file = new File( parent, files[ i ] );
			if ( file.isDirectory() ) {
				parseDir( file );
			}
			else if ( file.isFile() ) {
				try {
					if ( file.getName().toLowerCase().endsWith( ".jar" ) ) {
						++jars;
						jarFile = new JarFile( file );
						Enumeration<JarEntry> entries = jarFile.entries();
						JarEntry jarEntry;
						while ( entries.hasMoreElements() ) {
							jarEntry = entries.nextElement();
							if ( jarEntry.getName().toLowerCase().endsWith( ".class" )) {
								bytes_org = new byte[ (int)jarEntry.getSize() ];
								in = jarFile.getInputStream( jarEntry );
								pos = 0;
								while ( (read = in.read( tmpBuf, 0, tmpBuf.length )) != -1 ) {
									System.arraycopy( tmpBuf, 0, bytes_org, pos, read );
									pos += read;
								}
								in.close();
								parseBytes( file.getName() + "[" + jarEntry.getName() + "]" , bytes_org );
							}
						}
						jarFile.close();
					}
					if ( file.getName().toLowerCase().endsWith( ".class" ) ) {
						++classes;
						ram = new RandomAccessFile( file, "r" );
						bytes_org = new byte[ (int)ram.length() ];
						ram.readFully( bytes_org );
						ram.close();
						parseBytes( file.getName(), bytes_org );
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void parseBytes(String filename, byte[] bytes_org) {
		byte[] bytes_new;
		try {
			++loaded;
			ClassFile classfile = ClassFile.parseClassFile( bytes_org );
			if ( classfile != null ) {
				++parsed;
				bytes_new = classfile.build();
				if ( bytes_new != null ) {
					++built;
					if ( compare( bytes_org, bytes_new ) ) {
						++equal;
					}
					else {
						System.out.println( filename + " " + bytes_org.length + " " + bytes_new.length );
						diff( bytes_org, bytes_new );
						System.out.println( classfile.toString() );
						++diff;
					}
				}
			}
		}
		catch (ClassFileException e) {
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean compare(byte[] bytes1, byte[] bytes2) {
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

	public void diff(byte[] bytes1, byte[] bytes2) {
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
