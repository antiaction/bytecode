/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.constantpool.ConstantPool_Class;

public class Interface extends BuildingBlockAbstract {

	public int interface_index;
	public ConstantPool_Class interface_cp;
	public String interface_name;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		interface_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		interface_cp = cfs.cf.constantpool.getClass( interface_index );
		interface_name = interface_cp.name;
		// debug
		//System.out.println( "interfaces index: " + interface_index + "=" + interface_name );
	}

	@Override
	public void resolve() throws ClassFileException {
		interface_cp.buildResolve();
		interface_index = interface_cp.index;
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(interface_index >> 8) );
		out.write( (byte)(interface_index & 255) );
	}

}
