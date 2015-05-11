package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class LocalVariableTypeTable extends BuildingBlockAbstract {

	public int start_pc;
	public int length;

	public int name_index;
	public ConstantPool_Utf8 name_cp;
	public String name;

	public int signature_index;
	public ConstantPool_Utf8 signature_cp;
	public String signature_string;

	public int index;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 10 );

		start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		name_cp = cfs.cf.constantpool.getUtf8( name_index );
		name = name_cp.utf8;

		signature_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		signature_cp = cfs.cf.constantpool.getUtf8( signature_index );
		signature_string = signature_cp.utf8;

		index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( "Field: " + name_index + "=" + name + " of type " + descriptor_index + "=" + descriptor_string );
	}

	@Override
	public void resolve() throws ClassFileException {
		name_cp.resolve();
		name_index = name_cp.index;
		signature_cp.resolve();
		signature_index = signature_cp.index;
	}

	@Override
	public void assemble(ByteArrayOutputStream out) {
		out.write( (byte)(start_pc >> 8) );
		out.write( (byte)(start_pc & 255) );
		out.write( (byte)(length >> 8) );
		out.write( (byte)(length & 255) );
		out.write( (byte)(name_index >> 8) );
		out.write( (byte)(name_index & 255) );
		out.write( (byte)(signature_index >> 8) );
		out.write( (byte)(signature_index & 255) );
		out.write( (byte)(index >> 8) );
		out.write( (byte)(index & 255) );
	}

}
