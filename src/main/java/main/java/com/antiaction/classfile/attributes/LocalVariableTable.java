/*
 * Created on 22/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IDescriptor;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;
import com.antiaction.classfile.descriptors.Descriptors;

public class LocalVariableTable extends BuildingBlockAbstract {

	public int start_pc;
	public int length;

	public int name_index;
	public ConstantPool_Utf8 name_cp;
	public String name;

	public int descriptor_index;
	public ConstantPool_Utf8 descriptor_cp;
	public String descriptor_string;
	public IDescriptor descriptor;

	public int index;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 10 );

		start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		name_cp = cfs.cf.constantpool.getUtf8( name_index );
		name = name_cp.utf8;

		descriptor_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		descriptor_cp = cfs.cf.constantpool.getUtf8( descriptor_index );
		descriptor_string = descriptor_cp.utf8;
		descriptor = Descriptors.parseFieldDescriptor( descriptor_string );

		index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( "Field: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );
	}

	@Override
	public void resolve() throws ClassFileException {
		name_cp.resolve();
		name_index = name_cp.index;
		descriptor_cp.resolve();
		descriptor_index = descriptor_cp.index;
	}

	@Override
	public void assemble(ByteArrayOutputStream out) {
		out.write( (byte)(start_pc >> 8) );
		out.write( (byte)(start_pc & 255) );
		out.write( (byte)(length >> 8) );
		out.write( (byte)(length & 255) );
		out.write( (byte)(name_index >> 8) );
		out.write( (byte)(name_index & 255) );
		out.write( (byte)(descriptor_index >> 8) );
		out.write( (byte)(descriptor_index & 255) );
		out.write( (byte)(index >> 8) );
		out.write( (byte)(index & 255) );
	}

}
