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

public class ConstantPool_NameAndType extends ConstantPool_Info {

	public int name_index;

	public ConstantPool_Utf8 cp_name;

	public String name;

	public int descriptor_index;

	public ConstantPool_Utf8 cp_descriptor;

	public String descriptor;

	public ConstantPool_NameAndType() {
		tag = ConstantPool.CONSTANT_NameAndType;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 4 );
		name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "NameAndType: " + name_index + ", " + descriptor_index );
	}

	@Override
	public void validate(ClassFileState cfs) throws ClassFileException {
		cp_name = cp.getUtf8( name_index );
		name = cp_name.utf8;
		cp_descriptor = cp.getUtf8( descriptor_index );
		name = cp_descriptor.utf8;
	}

	@Override
	public void resolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
			cp_name.resolve();
			name_index = cp_name.index;
			cp_descriptor.resolve();
			descriptor_index = cp_descriptor.index;
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(name_index >> 8) );
		bytes.write( (byte)(name_index & 255) );

		bytes.write( (byte)(descriptor_index >> 8) );
		bytes.write( (byte)(descriptor_index & 255) );
	}

}
