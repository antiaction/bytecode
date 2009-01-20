/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IConstantPool_Info;

public class ConstantPool_InterfaceMethodref extends IConstantPool_Info {

	public int tag = ConstantPool.CONSTANT_InterfaceMethodref;

	public int class_index;

	public ConstantPool_Class cp_class;

	public String class_name;

	public int name_and_type_index;

	public ConstantPool_NameAndType cp_name_and_type;

	public static IConstantPool_Info parseInterfaceMethodref(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );

		int class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int name_and_type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( "InterfaceMethodref: " + class_index + ", " + name_and_type_index );

		ConstantPool_InterfaceMethodref cp_info = new ConstantPool_InterfaceMethodref();
		cp_info.class_index = class_index;
		cp_info.name_and_type_index = name_and_type_index;

		return cp_info;
	}

	@Override
	public void parseResolve(ClassFileState cfs) throws ClassFileException {
		cp_class = cp.getClass( class_index );
		cp_name_and_type = cp.getNameAndType( name_and_type_index );
		class_name = cp_class.name;
	}

	@Override
	public void buildResolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
			cp_class.buildResolve();
			class_index = cp_class.index;
			cp_name_and_type.buildResolve();
			name_and_type_index = cp_name_and_type.index;
		}
	}

	@Override
	public void build(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(class_index >> 8) );
		bytes.write( (byte)(class_index & 255) );

		bytes.write( (byte)(name_and_type_index >> 8) );
		bytes.write( (byte)(name_and_type_index & 255) );
	}

}
