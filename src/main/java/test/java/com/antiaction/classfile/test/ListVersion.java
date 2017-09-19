package com.antiaction.classfile.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.bytecode.BytecodeException;

public class ListVersion {

	public static void main(String[] args) {
		File folder = new File("/home/test/QUICKSTART/lib/");

		Deque<File> deque = new LinkedList<File>();
		deque.add(folder);

		File[] fileArr;
		List<File> files = new LinkedList<File>();

		File queueFile;
		while (deque.size() > 0) {
			queueFile = deque.removeFirst();
			if ( queueFile.isDirectory() ) {
				fileArr = queueFile.listFiles();
				if ( fileArr != null ) {
					for ( int i=0; i<fileArr.length; ++i ) {
						if ( fileArr[ i ].isDirectory() ) {
							deque.add( fileArr[ i ] );
						}
						else if ( fileArr[ i ].isFile() ) {
							files.add( fileArr[ i ] );
						}
					}
				}
			}
			else if ( queueFile.isFile() ) {
				files.add(queueFile);
			}
		}

		ClassFile classFile;
		String filename;
		JarFile jarFile;
		RandomAccessFile ram;
		InputStream in;
		int read;
		int pos;
		byte[] tmpBuf = new byte[ 8192 ];
		byte[] bytes_org;

		for (int i=0; i<files.size(); ++i) {
			queueFile = files.get( i );
			filename = queueFile.getName();
			try {
				if ( filename.endsWith(".class") ) {
					ram = new RandomAccessFile( queueFile, "r" );
					bytes_org = new byte[ (int)ram.length() ];
					ram.readFully( bytes_org );
					ram.close();
					parseBytes( queueFile.getName(), bytes_org );
				}
				else if ( filename.endsWith(".jar") || filename.endsWith(".war") || filename.endsWith(".ear") ) {
					jarFile = new JarFile( queueFile );
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
							parseBytes( queueFile.getName() + "[" + jarEntry.getName() + "]" , bytes_org );
						}
					}
					jarFile.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void parseBytes(String filename, byte[] bytes_org) {
		byte[] bytes_new;
		try {
			//++loaded;
			ClassFile classfile = ClassFile.disassembleClassFile( bytes_org );
			if ( classfile != null ) {
				//++parsed;
				/*
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
				*/
			}
		}
		catch (ClassFileException e) {
			//filenameFailList.add( filename );
			e.printStackTrace();
		}
		catch (BytecodeException e) {
			//filenameFailList.add( filename );
			e.printStackTrace();
		}
	}

}
