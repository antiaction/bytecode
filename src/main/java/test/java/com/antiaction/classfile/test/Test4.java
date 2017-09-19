package com.antiaction.classfile.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
		File testResourcesFile = TestHelpers.getTestResourceFile( "" );
		File libFile = new File( testResourcesFile, "lib" );

		parseDir( libFile );

		System.out.println( "   Jars: " + jars );
		System.out.println( "Classes: " + classes );
		System.out.println( " Loaded: " + loaded );
		System.out.println( " Parsed: " + parsed );
		System.out.println( "  Built: " + built );
		System.out.println( "  Equal: " + equal );
		System.out.println( "   Diff: " + diff );

		Iterator<String> iter;
		RandomAccessFile raf;
		String tmpStr;

		try {
			File diffFile = new File( testResourcesFile, "diff.list" );
			raf = new RandomAccessFile( diffFile, "rw" );
			raf.setLength( 0 );
			iter = filenameDiffList.iterator();
			while ( iter.hasNext() ) {
				tmpStr = iter.next();
				raf.writeBytes( tmpStr );
				raf.writeBytes( "\n" );
				// debug
				// System.out.println( "diff: " + tmpStr );
			}
			raf.close();

			File failFile = new File( testResourcesFile, "fail.list" );
			raf = new RandomAccessFile( failFile, "rw" );
			raf.setLength( 0 );
			iter = filenameFailList.iterator();
			while ( iter.hasNext() ) {
				tmpStr = iter.next();
				raf.writeBytes( tmpStr );
				raf.writeBytes( "\n" );
				// debug
				//System.out.println( "fail: " + tmpStr );
			}
			raf.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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

	public List<String> filenameFailList = new LinkedList<String>();

	public List<String> filenameDiffList = new LinkedList<String>();

	public void parseBytes(String filename, byte[] bytes_org) {
		byte[] bytes_new;
		try {
			++loaded;
			ClassFile classfile = ClassFile.disassembleClassFile( bytes_org );
			if ( classfile != null ) {
				++parsed;
				bytes_new = classfile.assemble();
				if ( bytes_new != null ) {
					++built;
					if ( ParserHelpers.compare( bytes_org, bytes_new ) ) {
						++equal;
					}
					else {
						filenameDiffList.add( filename );
						System.out.println( filename + " " + bytes_org.length + " " + bytes_new.length );
						ParserHelpers.diff( bytes_org, bytes_new );
						System.out.println( classfile.toString() );
						++diff;
					}
				}
			}
		}
		catch (ClassFileException e) {
			filenameFailList.add( filename );
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			filenameFailList.add( filename );
			e.printStackTrace();
		}
		catch (IOException e) {
			filenameFailList.add( filename );
			e.printStackTrace();
		}
	}

}
