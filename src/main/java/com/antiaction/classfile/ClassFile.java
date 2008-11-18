/*
 * Created on 07/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.bytecode.Bytecode;
import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.constantpool.ConstantPool;
import com.antiaction.classfile.fields.Fields;
import com.antiaction.classfile.interfaces.Interfaces;
import com.antiaction.classfile.methods.Method;
import com.antiaction.classfile.methods.Methods;

public class ClassFile {

	public static final int ACC_PUBLIC = 0x0001;
	public static final int ACC_FINAL = 0x0010;
	public static final int ACC_SUPER = 0x0020;
	public static final int ACC_INTERFACE = 0x0200;
	public static final int ACC_ABSTRACT = 0x0400;
	//public static final int ACC_ = ;

	public static final int ACCESS_FLAGS_MASK = ACC_PUBLIC | ACC_FINAL | ACC_SUPER | ACC_INTERFACE | ACC_ABSTRACT;

	public static ClassFile parseClassFile(String filename) throws ClassFileException, BytecodeException {
		File classFile = new File( filename );
		return parseClassFile( classFile );
	}

	public static ClassFile parseClassFile(File classFile) throws ClassFileException, BytecodeException {
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

	int magic = 0xcafebabe;

	int minor_version = 46;

	int major_version = 0;

	int access_flags = 0;

	public List<IAttribute> attributeList = new ArrayList<IAttribute>();

	public Map<String, IAttribute> attributeMap = new HashMap<String, IAttribute>();

	public static ClassFile parseClassFile(ClassFileState cfs) throws ClassFileException, BytecodeException {
		if ( cfs.bytes == null || cfs.bytes.length == 0 ) {
			return null;
		}

		ClassFile cf = new ClassFile();

		/*
		 * Magic.
		 */

		cfs.assert_unexpected_eof( 8 );

		cf.magic = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( Integer.toHexString( cf.magic ) );

		if ( cf.magic != 0xcafebabe ) {
			throw new ClassFileException( "Invalid magic (0x" + Integer.toHexString( cf.magic ) + ")", cfs.index );
		}

		/*
		 * Major.Minor version.
		 */

		cf.minor_version = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		cf.major_version = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( Integer.toString( cf.major_version ) + '.' + Integer.toString( cf.minor_version ) );

		if ( cf.major_version < 45 ) {
			throw new ClassFileException( "Invalid version: " + Integer.toString( cf.major_version ) + '.' + Integer.toString( cf.minor_version ), cfs.index );
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

		cf.access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "access flags: 0x" + Integer.toHexString( cf.access_flags ) );

		cf.validate_access_flags( cfs );

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

		// Attributes.

		int attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		System.out.println( "attributes count: " + attributes_count );

		int attribute_name_index;
		String attribute_name;
		IAttribute attribute;

		while ( attributes_count > 0 ) {
			cfs.assert_unexpected_eof( 6 );

			attribute_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attribute_name = cfs.constantpool.getUtf8( attribute_name_index );

			// debug
			System.out.println( attribute_name );

			attribute = Attributes.parseAttribute( cfs, attribute_name );

			cf.attributeList.add( attribute );
			cf.attributeMap.put( attribute_name, attribute );

			--attributes_count;
		}

		Method method;
		for ( int i=0; i<cfs.methods.methods_list.size(); ++i ) {
			method = cfs.methods.methods_list.get( i );
			if ( method.codeAttr != null ) {
				Bytecode.parseBytecode( method.codeAttr );
			}
		}

		return null;
	}

	public void validate_access_flags(ClassFileState cfs) throws ClassFileException {
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
	}

	public byte[] build() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		/*
		 * Magic.
		 */

		int magic = 0xcafebabe;

		bytes.write( (byte)(magic >> 24) );
		bytes.write( (byte)(magic >> 16) );
		bytes.write( (byte)(magic >> 8) );
		bytes.write( (byte)(magic & 255) );

		/*
		 * Major.Minor version.
		 */

		bytes.write( (byte)(minor_version >> 8) );
		bytes.write( (byte)(minor_version & 255) );

		bytes.write( (byte)(major_version >> 8) );
		bytes.write( (byte)(major_version & 255) );

		return bytes.toByteArray();
	}

}
