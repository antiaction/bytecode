package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class ElementValuePair extends BuildingBlockAbstract {

	public int element_name_index;

	public ConstantPool_Utf8 element_name_cp;

	public String element_name;

	public ElementValue elementValue;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		element_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		element_name_cp = cfs.cf.constantpool.getUtf8( element_name_index );
		element_name = element_name_cp.utf8;
		elementValue = new ElementValue();
		elementValue.disassemble( cfs );
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve name
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(element_name_index >> 8) );
		out.write( (byte)(element_name_index & 255) );
		elementValue.assemble( out );
	}

}
