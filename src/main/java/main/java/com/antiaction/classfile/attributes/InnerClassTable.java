/*
 * Created on 24/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class InnerClassTable extends BuildingBlockAbstract {

	public int inner_class_info_index;

	public int outer_class_info_index;

	public int inner_name_index;

	public int inner_class_access_flags;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 8 );
		inner_class_info_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		outer_class_info_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		inner_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		inner_class_access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// TODO validate indexes
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO add names to constants pool if not present.
	}

	@Override
	public void assemble(ByteArrayOutputStream out) {
		out.write( (byte)(inner_class_info_index >> 8) );
		out.write( (byte)(inner_class_info_index & 255) );
		out.write( (byte)(outer_class_info_index >> 8) );
		out.write( (byte)(outer_class_info_index & 255) );
		out.write( (byte)(inner_name_index >> 8) );
		out.write( (byte)(inner_name_index & 255) );
		out.write( (byte)(inner_class_access_flags >> 8) );
		out.write( (byte)(inner_class_access_flags & 255) );
	}

}
