/*
 * Created on 21/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class ExceptionTable extends BuildingBlockAbstract {

	public int start_pc;

	public int end_pc;

	public int handler_pc;

	public int catch_type_index;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 8 );
		start_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		end_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		handler_pc = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		catch_type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		if ( catch_type_index > 0 ) {
			// TODO validate etc.
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO catch_type_index resolve
	}

	@Override
	public void assemble(ByteArrayOutputStream out) {
		out.write( (byte)(start_pc >> 8) );
		out.write( (byte)(start_pc & 255) );
		out.write( (byte)(end_pc >> 8) );
		out.write( (byte)(end_pc & 255) );
		out.write( (byte)(handler_pc >> 8) );
		out.write( (byte)(handler_pc & 255) );
		out.write( (byte)(catch_type_index >> 8) );
		out.write( (byte)(catch_type_index & 255) );
	}

}
