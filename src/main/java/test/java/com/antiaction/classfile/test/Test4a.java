package com.antiaction.classfile.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.test.TraceHandler.Trace;

public class Test4a {

	public static void main(String[] args) {
		Test4a p = new Test4a();
		p.Main( args );
	}

	public void Main(String[] args) {
		File testResourcesFile = TestHelpers.getTestResourceFile( "" );
		File libFile = new File( testResourcesFile, "lib" );

		File diffFile = new File( testResourcesFile, "diff.list" );

		TraceHandler traceHandler = new TraceHandler();

		ClassFile.traceHandler = traceHandler;

		try {
			RandomAccessFile raf = new RandomAccessFile( diffFile, "r" );
			String tmpStr;
			int idx;
			String jarFileFilename;
			File jarFileFile;
			JarFile jarFile;
			String classFilename;
			JarEntry jarEntry;
			InputStream in;
			int read;
			int pos;
			byte[] tmpBuf = new byte[ 8192 ];
			byte[] bytes_org = null;
			StringBuilder sb = new StringBuilder();
			while ( (tmpStr = raf.readLine()) != null ) {
				idx = tmpStr.indexOf( '[' );
				if ( idx != -1 ) {
					jarFileFilename = tmpStr.substring( 0, idx );
					if ( tmpStr.endsWith( "]" ) ) {
						classFilename = tmpStr.substring( idx + 1, tmpStr.length() - 1 );
						jarFileFile = new File( libFile, jarFileFilename );
						jarFile = new JarFile( jarFileFile );
						jarEntry = jarFile.getJarEntry( classFilename );
						bytes_org = new byte[ (int)jarEntry.getSize() ];
						in = jarFile.getInputStream( jarEntry );
						pos = 0;
						while ( (read = in.read( tmpBuf, 0, tmpBuf.length )) != -1 ) {
							System.arraycopy( tmpBuf, 0, bytes_org, pos, read );
							pos += read;
						}
						in.close();
						jarFile.close();
					}
				}
				traceHandler.reset();
				int traceIdx;
				if ( bytes_org != null ) {
					byte[] bytes_new;
					try {
						ClassFile classfile = ClassFile.disassembleClassFile( bytes_org );
						if ( classfile != null ) {
							bytes_new = classfile.assemble();
							System.out.println( bytes_org.length + " - " + bytes_new.length);

							int max = Math.max( bytes_org.length,  bytes_new.length );
							idx = 0;
							boolean bEqual = true;
							while ( bEqual && idx < max ) {
								if ( idx < bytes_org.length && idx < bytes_new.length ) {
									bEqual = bytes_org[ idx ] == bytes_new[ idx ];
								}
								else {
									bEqual = false;
								}
								if ( bEqual ) {
									++idx;
								}
							}
							if ( !bEqual ) {
								System.out.println( idx );
								List<Trace> traceList = traceHandler.traceList;
								Trace lastTrace = null;
								Trace tmpTrace;
								traceIdx = 0;
								while ( traceIdx < traceList.size() ) {
									tmpTrace = traceList.get( traceIdx++ );
									if ( tmpTrace.index < idx ) {
										lastTrace = tmpTrace;
									}
								}
								if ( lastTrace != null ) {
									System.out.println( lastTrace.index + " " + lastTrace.obj );
									idx = lastTrace.index;
									sb.setLength( 0 );
									while ( idx < bytes_org.length || idx < bytes_new.length ) {
										sb.append( idx );
										sb.append( ": " );
										if ( idx < bytes_org.length ) {
											sb.append( bytes_org[ idx ] );
										}
										else {
											sb.append( " " );
										}
										sb.append( " = " );
										if ( idx < bytes_new.length ) {
											sb.append( bytes_new[ idx ] );
										}
										sb.append( "\n" );
										++idx;
									}
									System.out.println( sb.toString() );
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
			}
			raf.close();
		}
		catch (IOException e) {
		}
	}

}
