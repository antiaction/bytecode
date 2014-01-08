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

import com.antiaction.classfile.attributes.Attribute_SourceFile;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.bytecode.Bytecode;
import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.constantpool.ConstantPool;
import com.antiaction.classfile.constantpool.ConstantPool_Class;
import com.antiaction.classfile.fields.Fields;
import com.antiaction.classfile.interfaces.Interfaces;
import com.antiaction.classfile.methods.Method;
import com.antiaction.classfile.methods.Methods;

public class ClassFile {

	public static final int ACC_PUBLIC = 0x0001;		// Declared public; may be accessed from outside its package.
	public static final int ACC_FINAL = 0x0010;			// Declared final; no subclasses allowed.
	public static final int ACC_SUPER = 0x0020;			// Treat superclass methods specially when invoked by the invokespecial instruction.
	public static final int ACC_INTERFACE = 0x0200;		// Is an interface, not a class.
	public static final int ACC_ABSTRACT = 0x0400;		// Declared abstract; must not be instantiated.
	public static final int ACC_SYNTHETIC = 0x1000; 	// Declared synthetic; Not present in the source code.
	public static final int ACC_ANNOTATION = 0x2000;	// Declared as an annotation type.
	public static final int ACC_ENUM = 0x4000;			// Declared as an enum type.
	//public static final int ACC_ = ;

	public static final int ACCESS_FLAGS_MASK = ACC_PUBLIC | ACC_FINAL | ACC_SUPER | ACC_INTERFACE | ACC_ABSTRACT | ACC_SYNTHETIC | ACC_ANNOTATION | ACC_ENUM;

	public int magic = 0xcafebabe;

	public int major_version = 46;

	public int minor_version = 0;

	public ConstantPool constantpool;

	public int access_flags = 0;

	public boolean bClass = false;
	public boolean bFinal = false;
	public boolean bInterface = false;
	public boolean bAbstract = false;

	public int this_class_index = 0;
	public ConstantPool_Class this_class_cp = null;
	public String this_class_name = null;

	public int super_class_index = 0;
	public ConstantPool_Class super_class_cp = null;
	public String super_class_name = null;

	public Interfaces interfaces;

	public Fields fields;

	public Methods methods;

	public Attributes attributes;

	public Attribute_SourceFile sourcefile_attr;

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
			ClassFileState cfs = new ClassFileState( bytes );
			return parseClassFile( cfs );
		}
		else {
			return null;
		}
	}

	public static ClassFile parseClassFile(byte[] bytes) throws ClassFileException, BytecodeException {
		ClassFileState cfs = new ClassFileState( bytes );
		return parseClassFile( cfs );
	}

	private static ClassFile parseClassFile(ClassFileState cfs) throws ClassFileException, BytecodeException {
		if ( cfs.bytes == null || cfs.bytes.length == 0 ) {
			return null;
		}

		ClassFile cf = new ClassFile();
		cfs.cf = cf;

		/*
		 * Magic.
		 */

		cfs.assert_unexpected_eof( 8 );

		cf.magic = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( Integer.toHexString( cf.magic ) );

		if ( cf.magic != 0xcafebabe ) {
			throw new ClassFileException( "Invalid magic (0x" + Integer.toHexString( cf.magic ) + ")", cfs.index );
		}

		/*
		 * Major.Minor version.
		 */

		cf.minor_version = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		cf.major_version = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( Integer.toString( cf.major_version ) + '.' + Integer.toString( cf.minor_version ) );

		if ( cf.major_version < 45 ) {
			throw new ClassFileException( "Invalid version: " + Integer.toString( cf.major_version ) + '.' + Integer.toString( cf.minor_version ), cfs.index );
		}

		/*
		 * Constant pool.
		 */

		cf.constantpool = ConstantPool.parseConstantPool( cfs );

		/*
		 * Access flags, This Class and Super Class.
		 */

		cfs.assert_unexpected_eof( 6 );

		cf.access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( "access flags: 0x" + Integer.toHexString( cf.access_flags ) );

		cf.validate_access_flags( cfs );

		cf.this_class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		cf.this_class_cp = cf.constantpool.getClass( cf.this_class_index );
		cf.this_class_name = cf.constantpool.getClassName( cf.this_class_index );

		// debug
		//System.out.println( "this class: " + cf.this_class_index + "=" + cf.this_class_name );

		cf.super_class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		cf.super_class_cp = cf.constantpool.getClass( cf.super_class_index );
		cf.super_class_name = cf.constantpool.getClassName( cf.super_class_index );

		// debug
		//System.out.println( "super class: " + cf.super_class_index + "=" + cf.super_class_name );

		/*
		 * Interfaces.
		 */

		cf.interfaces = Interfaces.parseInterfaces( cfs );

		/*
		 * Fields.
		 */

		cf.fields = Fields.parseFields( cfs );

		/*
		 * Methods.
		 */

		cf.methods = Methods.parseMethods( cfs );

		/*
		 * Attributes.
		 */

		int attributes_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( "attributes count: " + attributes_count );

		cf.attributes = Attributes.parseAttributes( cfs, attributes_count );

		IAttribute attribute;

		// Post-processing.

		Method method;
		for ( int i=0; i<cf.methods.methods_list.size(); ++i ) {
			method = cf.methods.methods_list.get( i );

			//System.out.println( method.name );

			if ( method.codeAttr != null ) {
				Bytecode.parseBytecode( cfs, method.codeAttr );
			}
		}

		return cf;
	}

	public void validate_access_flags(ClassFileState cfs) throws ClassFileException {
		if ( (access_flags & ~ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~ACCESS_FLAGS_MASK ) );
		}

		if ( (access_flags & ACC_INTERFACE) == 0 ) {
			// Class
			cfs.cf.bClass = true;
		}
		else {
			// Interface
			cfs.cf.bInterface = true;
		}

		if ( cfs.cf.bClass ) {
			if ( (access_flags & ( ACC_FINAL | ACC_ABSTRACT )) == ( ACC_FINAL | ACC_ABSTRACT ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_FINAL | ACC_ABSTRACT ) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
			}
			if ( (access_flags & ACC_ANNOTATION ) == ACC_ANNOTATION ) {
				throw new ClassFileException( "Invalid access flags, class and annotation combination: 0x" + Integer.toHexString( access_flags & ACC_ANNOTATION ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
			}
		}
		if ( cfs.cf.bInterface ) {
			if ( (access_flags & ( ACC_FINAL | ACC_INTERFACE | ACC_ABSTRACT )) != ( ACC_INTERFACE | ACC_ABSTRACT ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_FINAL | ACC_INTERFACE | ACC_ABSTRACT ) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
			}
		}
		cfs.cf.bFinal = ((access_flags & ACC_FINAL) != 0);
		cfs.cf.bAbstract = ((access_flags & ACC_ABSTRACT) != 0);
	}

	public byte[] build() throws IOException, ClassFileException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		/*
		 * Resolve constantpool indexes.
		 */

		this_class_cp.buildResolve();
		this_class_index = this_class_cp.index;

		super_class_cp.buildResolve();
		super_class_index = super_class_cp.index;

		interfaces.buildResolve();

		fields.buildResolve();

		methods.buildResolve();

		attributes.buildResolve();

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

		/*
		 * Constant pool.
		 */

		constantpool.build( bytes );

		/*
		 * Access flags, This Class and Super Class.
		 */

		bytes.write( (byte)(access_flags >> 8) );
		bytes.write( (byte)(access_flags & 255) );

		bytes.write( (byte)(this_class_index >> 8) );
		bytes.write( (byte)(this_class_index & 255) );

		bytes.write( (byte)(super_class_index >> 8) );
		bytes.write( (byte)(super_class_index & 255) );

		/*
		 * Interfaces.
		 */

		interfaces.build( bytes );

		/*
		 * Fields.
		 */

		// debug
		//System.out.println( "fields: " + bytes.size() );

		fields.build( bytes );

		/*
		 * Methods.
		 */

		// debug
		//System.out.println( "methods: " + bytes.size() );

		methods.build( bytes );

		/*
		 * Attributes.
		 */

		attributes.build( bytes );

		return bytes.toByteArray();
	}

	public static ClassFile createInstance() {
		ClassFile cf = new ClassFile();

		cf.constantpool = ConstantPool.createInstance();
		cf.interfaces = Interfaces.createInstance();
		cf.fields = Fields.createInstance();
		cf.methods = Methods.createInstance();
		cf.attributes = Attributes.createInstance( cf );

		return cf;
	}

	public static ClassFile createInstance(String this_class_name, String super_class_name, int access_flags) throws ClassFileException {
		ClassFile cf = new ClassFile();

		cf.constantpool = ConstantPool.createInstance();
		cf.interfaces = Interfaces.createInstance();
		cf.fields = Fields.createInstance();
		cf.methods = Methods.createInstance();
		cf.attributes = Attributes.createInstance( cf );

		cf.this_class_cp = cf.constantpool.putClass( this_class_name );
		cf.this_class_name = this_class_name;
		cf.super_class_cp = cf.constantpool.putClass( super_class_name );
		cf.super_class_name = super_class_name;

		cf.access_flags = access_flags;

		return cf;
	}

	public void setSourceFile(String sourcefile) throws ClassFileException {
		sourcefile_attr = attributes.putSourceFile( sourcefile );
	}

	public String accessFlagsToString() {
		StringBuffer sb = new StringBuffer();

		if ( (access_flags & ACC_PUBLIC) != 0 ) {
			if ( sb.length() > 0 ) {
				sb.append( ", " );
			}
			sb.append( "public" );
		}
		if ( (access_flags & ACC_FINAL) != 0 ) {
			if ( sb.length() > 0 ) {
				sb.append( ", " );
			}
			sb.append( "final" );
		}
		if ( (access_flags & ACC_SUPER) != 0 ) {
			if ( sb.length() > 0 ) {
				sb.append( ", " );
			}
			sb.append( "super" );
		}
		if ( (access_flags & ACC_INTERFACE) != 0 ) {
			if ( sb.length() > 0 ) {
				sb.append( ", " );
			}
			sb.append( "interface" );
		}
		if ( (access_flags & ACC_ABSTRACT) != 0 ) {
			if ( sb.length() > 0 ) {
				sb.append( ", " );
			}
			sb.append( "abstract" );
		}

		return sb.toString();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append( "Magic: " );
		sb.append( Integer.toHexString( magic ) );
		//sb.append();

		/*
		 * Major.Minor version.
		 */

		sb.append( "Version: " );
		sb.append( Integer.toString( major_version ) );
		sb.append( '.' );
		sb.append( Integer.toString( minor_version ) );

		/*
		 * Access flags, This Class and Super Class.
		 */

		sb.append( "access flags: 0x" + Integer.toHexString( access_flags ) );

		sb.append( "this class: " + this_class_index + "=" + this_class_name );

		sb.append( "super class: " + super_class_index + "=" + super_class_name );

		/*
		 * Interfaces.
		 */

		sb.append( "interfaces count: " + interfaces.interface_list.size() );

		interfaces.toString( sb, "" );

		/*
		 * Constant pool.
		 */

		sb.append( "constant pool count: " );
		sb.append( constantpool.constantpool_infolist.size() );

		//cf.constantpool = ConstantPool.parseConstantPool( cfs, constant_pool_count );

		/*
		 * Fields.
		 */

		System.out.println( "fields count: " + fields.fields_list.size() );

		//cf.fields = Fields.parseFields( cfs, fields_count );

		/*
		 * Methods.
		 */

		System.out.println( "methods count: " + methods.methods_list.size() );

		//cf.methods = Methods.parseMethods( cfs, methods_count );

		/*
		 * Attributes.
		 */

		System.out.println( "attributes count: " + attributes.attributes_list.size() );

		//cf.attributes = Attributes.parseAttributes( cfs, attributes_count );

		IAttribute attribute;

		// Post-processing.

		/*
		Method method;
		for ( int i=0; i<cf.methods.methods_list.size(); ++i ) {
			method = cf.methods.methods_list.get( i );

			System.out.println( method.name );

			if ( method.codeAttr != null ) {
				Bytecode.parseBytecode( method.codeAttr );
			}
		}
		*/

		return sb.toString();
	}

}
