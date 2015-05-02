/*
 * Created on 18/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.methods;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.ITraceHandler;

public class Methods extends BuildingBlockAbstract {

	protected ITraceHandler traceHandler;

	public List<Method> methods_list;

	public Methods(ITraceHandler traceHandler) {
		this.traceHandler = traceHandler;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		if ( traceHandler != null ) {
			traceHandler.addIndex( cfs.index, this );
		}
		cfs.assert_unexpected_eof( 2 );
		int methods_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "methods count: " + methods_count );
		methods_list = new ArrayList<Method>();
		Method method;
		while( methods_count > 0 ) {
			method = new Method( traceHandler );
			method.disassemble( cfs );
			methods_list.add( method );
			--methods_count;
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		Method method;
		for ( int i=0; i<methods_list.size(); ++i ) {
			method = methods_list.get( i );
			method.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int methods_count = methods_list.size();
		out.write( (byte)(methods_count >> 8) );
		out.write( (byte)(methods_count & 255) );
		Method method;
		for ( int i=0; i<methods_list.size(); ++i ) {
			method = methods_list.get( i );
			method.assemble( out );
		}
	}

	public static Methods createInstance() {
		Methods methods = new Methods( null );
		methods.methods_list = new ArrayList<Method>();
		return methods;
	}

}
