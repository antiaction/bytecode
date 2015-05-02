/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.fields;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.ITraceHandler;

public class Fields extends BuildingBlockAbstract {

	public List<Field> fields_list;

	protected ITraceHandler traceHandler;

	public Fields(ITraceHandler traceHandler) {
		this.traceHandler = traceHandler;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		if ( traceHandler != null ) {
			traceHandler.addIndex( cfs.index, this );
		}
		cfs.assert_unexpected_eof( 2 );
		int fields_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "fields count: " + fields_count );
		fields_list = new ArrayList<Field>();
		Field field;
		while( fields_count > 0 ) {
			field = new Field( traceHandler );
			field.disassemble( cfs );
			fields_list.add( field );
			--fields_count;
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		Field field;
		for ( int i=0; i<fields_list.size(); ++i ) {
			field = fields_list.get( i );
			field.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int fields_count = fields_list.size();
		out.write( (byte)(fields_count >> 8) );
		out.write( (byte)(fields_count & 255) );
		Field field;
		for ( int i=0; i<fields_list.size(); ++i ) {
			field = fields_list.get( i );
			field.assemble( out );
		}
	}

	public static Fields createInstance() {
		Fields fields = new Fields( null );
		fields.fields_list = new ArrayList<Field>();
		return fields;
	}

}
