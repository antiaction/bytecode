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

public class ConstantPool_Class extends ConstantPool_Info {

	public int name_index;

	public ConstantPool_Utf8 cp_name;

	public String name;

	public ConstantPool_Class() {
		tag = ConstantPool.CONSTANT_Class;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "Class: " + name_index );
	}

	public static ConstantPool_Class createClass(ConstantPool cp, String class_name) throws ClassFileException {
		ConstantPool_Class cp_info = new ConstantPool_Class();
		cp_info.cp = cp;
		cp_info.cp_name = cp.putUtf8( class_name );
		cp_info.name = cp_info.cp_name.utf8;
		return cp_info;
	}

	@Override
	public void validate(ClassFileState cfs) throws ClassFileException {
		cp_name = cp.getUtf8( name_index );
		name = cp_name.utf8;
	}

	@Override
	public void resolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
			cp_name.resolve();
			name_index = cp_name.index;
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(name_index >> 8) );
		bytes.write( (byte)(name_index & 255) );
	}

}
