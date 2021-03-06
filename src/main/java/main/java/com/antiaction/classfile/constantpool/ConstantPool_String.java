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

public class ConstantPool_String extends ConstantPool_Info {

	public int string_index;

	public ConstantPool_Utf8 cp_string;

	public String string;

	public ConstantPool_String() {
		tag = ConstantPool.CONSTANT_String;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );
		string_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "String: " + string_index );
	}

	@Override
	public void validate(ClassFileState cfs) throws ClassFileException {
		cp_string = cp.getUtf8( string_index );
		string = cp_string.utf8;
	}

	@Override
	public void resolve() throws ClassFileException {
		if ( index == 0 ) {
			index = cp.constantpool_infolist.size();
			cp.constantpool_infolist.add( this );
			cp_string.resolve();
			string_index = cp_string.index;
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream bytes) throws IOException {
		bytes.write( (byte)(tag & 255) );

		bytes.write( (byte)(string_index >> 8) );
		bytes.write( (byte)(string_index & 255) );
	}

}
