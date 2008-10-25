/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.antiaction.bytecode.constantpool.ConstantPool;
import com.antiaction.bytecode.fields.Fields;
import com.antiaction.bytecode.interfaces.Interfaces;
import com.antiaction.bytecode.methods.Methods;

public class ClassFile {

	public static final int ACC_PUBLIC = 0x0001;
	public static final int ACC_PRIVATE = 0x0002;
	public static final int ACC_PROTECTED = 0x0004;
	public static final int ACC_STATIC = 0x0008;
	public static final int ACC_FINAL = 0x0010;
	public static final int ACC_SUPER = 0x0020;
	public static final int ACC_SYNCHRONIZED = 0x0020;
	public static final int ACC_VOLATILE = 0x0040;
	public static final int ACC_TRANSIENT = 0x0080;
	public static final int ACC_NATIVE = 0x0100;
	public static final int ACC_INTERFACE = 0x0200;
	public static final int ACC_ABSTRACT = 0x0400;
	public static final int ACC_STRICT = 0x0800;
	//public static final int ACC_ = ;

	public static final int ACCESS_FLAGS_MASK = ACC_PUBLIC | ACC_FINAL | ACC_SUPER | ACC_INTERFACE | ACC_ABSTRACT;

	public static final int FIELD_ACCESS_FLAGS_MASK = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED | ACC_STATIC | ACC_FINAL | ACC_VOLATILE | ACC_TRANSIENT;

	public static final int METHOD_ACCESS_FLAGS_MASK = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED | ACC_STATIC | ACC_FINAL | ACC_SYNCHRONIZED | ACC_NATIVE | ACC_ABSTRACT | ACC_STRICT;

	public static ClassFile parseClassFile(String filename) throws ClassFileException {
		File classFile = new File( filename );
		byte[] bytes = null;

		RandomAccessFile ram = null;
		try {
			ram = new RandomAccessFile( classFile, "r" );
			bytes = new byte[ (int)ram.length() ];
			ram.readFully( bytes );
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if ( ram != null ) {
				try {
					ram.close();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

		if ( bytes != null ) {
			 ClassFileState bcs = new ClassFileState( bytes );
			return parseClassFile( bcs );
		}
		else {
			return null;
		}
	}

	public static ClassFile parseClassFile(ClassFileState cfs) throws ClassFileException {
		if ( cfs.bytes == null || cfs.bytes.length == 0 ) {
			return null;
		}

		/*
		 * Magic.
		 */

		cfs.assert_unexpected_eof( 8 );

		int magic = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( Integer.toHexString( magic ) );

		if ( magic != 0xcafebabe ) {
			throw new ClassFileException( "Invalid magic (0x" + Integer.toHexString( magic ) + ")", cfs.index );
		}

		/*
		 * Major.Minor version.
		 */

		int minor_version = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int major_version = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( Integer.toString( major_version ) + '.' + Integer.toString( minor_version ) );

		if ( major_version < 45 ) {
			throw new ClassFileException( "Invalid version: " + Integer.toString( major_version ) + '.' + Integer.toString( minor_version ), cfs.index );
		}

		/*
		 * Constant pool.
		 */

		int constant_pool_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "constant pool count: " + constant_pool_count );

		cfs.constantpool = ConstantPool.parseConstantPool( cfs, constant_pool_count );

		/*
		 * Access flags, This Class and Super Class.
		 */

		cfs.assert_unexpected_eof( 6 );

		int access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "access flags: 0x" + Integer.toHexString( access_flags ) );

		if ( (access_flags & ~ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~ACCESS_FLAGS_MASK ) );
		}

		if ( (access_flags & ACC_INTERFACE) == 0 ) {
			// Class
			if ( (access_flags & ( ACC_FINAL | ACC_ABSTRACT )) == ( ACC_FINAL | ACC_ABSTRACT ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_FINAL | ACC_ABSTRACT ) ) );
			}
			cfs.bClass = true;
			cfs.bFinal = ((access_flags & ACC_FINAL) != 0);
			cfs.bAbstract = ((access_flags & ACC_ABSTRACT) != 0);
		}
		else {
			// Interface
			if ( (access_flags & ( ACC_FINAL | ACC_INTERFACE | ACC_ABSTRACT )) != ( ACC_INTERFACE | ACC_ABSTRACT ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_FINAL | ACC_INTERFACE | ACC_ABSTRACT ) ) );
			}
			cfs.bInterface = true;
			cfs.bAbstract = true;
		}

		int this_class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		String this_class_name = cfs.constantpool.getClassName( this_class_index );

		// debug
		System.out.println( "this class: " + this_class_index + "=" + this_class_name );

		int super_class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		String super_class_name = cfs.constantpool.getClassName( super_class_index );

		// debug
		System.out.println( "super class: " + super_class_index + "=" + super_class_name );

		/*
		 * Interfaces.
		 */

		cfs.assert_unexpected_eof( 2 );

		int interfaces_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "interfaces count: " + interfaces_count );

		cfs.interfaces = Interfaces.parseInterfaces( cfs, interfaces_count );

		/*
		 * Fields.
		 */

		int fields_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "fields count: " + fields_count );

		cfs.fields = Fields.parseFields( cfs, fields_count );

		// Methods.

		int methods_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "methods count: " + methods_count );

		cfs.methods = Methods.parseMethods( cfs, methods_count );

		return null;
	}

}
