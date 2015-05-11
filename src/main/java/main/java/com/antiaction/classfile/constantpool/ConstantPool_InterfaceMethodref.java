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

public class ConstantPool_InterfaceMethodref extends ConstantPool_Info {

	public int class_index;

	public ConstantPool_Class cp_class;

	public String class_name;

	public int name_and_type_index;

	public ConstantPool_NameAndType cp_name_and_type;

	public ConstantPool_InterfaceMethodref() {
		tag = ConstantPool.CONSTANT_InterfaceMethodref;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );
		class_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		name_and_type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "InterfaceMethodref: " + class_index + ", " + name_and_type_index );
	}

	@Override
	public void validate(ClassFileState cfs) throws ClassFileException {
		cp_class = cp.getClass( class_index );
		cp_name_and_type = cp.getNameAndType( name_and_type_index );
		class_name = cp_class.name;
	}

	@Override
	public void resolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
			cp_class.resolve();
			class_index = cp_class.index;
			cp_name_and_type.resolve();
			name_and_type_index = cp_name_and_type.index;
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(class_index >> 8) );
		bytes.write( (byte)(class_index & 255) );

		bytes.write( (byte)(name_and_type_index >> 8) );
		bytes.write( (byte)(name_and_type_index & 255) );
	}

}
