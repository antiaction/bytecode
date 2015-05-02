/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.ITraceHandler;

public class Interfaces extends BuildingBlockAbstract {

	public List<Interface> interface_list;

	protected ITraceHandler traceHandler;

	public Interfaces(ITraceHandler traceHandler) {
		this.traceHandler = traceHandler;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		if ( traceHandler != null ) {
			traceHandler.addIndex( cfs.index, this );
		}
		cfs.assert_unexpected_eof( 2 );
		int interfaces_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		// debug
		//System.out.println( "interfaces count: " + interfaces_count );
		cfs.assert_unexpected_eof( interfaces_count * 2 );
		interface_list = new ArrayList<Interface>();
		Interface interfaceObj;
		while( interfaces_count > 0 ) {
			interfaceObj = new Interface();
			interfaceObj.disassemble( cfs );
			interface_list.add( interfaceObj );
			--interfaces_count;
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		Interface interfaceObj;
		for ( int i=0; i<interface_list.size(); ++i ) {
			interfaceObj = interface_list.get( i );
			interfaceObj.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int interfaces_count = interface_list.size();
		out.write( (byte)(interfaces_count >> 8) );
		out.write( (byte)(interfaces_count & 255) );
		Interface interfaceObj;
		for ( int i=0; i<interface_list.size(); ++i ) {
			interfaceObj = interface_list.get( i );
			interfaceObj.assemble( out );
		}
	}

	public static Interfaces createInstance() {
		Interfaces interfaces = new Interfaces( null );
		interfaces.interface_list = new ArrayList<Interface>();
		return interfaces;
	}

	public void toString(StringBuffer sb, String indentStr) {
		sb.append( indentStr );
		sb.append( "Interfaces:" );
		indentStr += " ";
		Interface interfaceObj;
		for ( int i=0; i<interface_list.size(); ++i ) {
			interfaceObj = interface_list.get( i );
			sb.append( indentStr );
			sb.append( interfaceObj.interface_index );
			sb.append( ':' );
			sb.append( interfaceObj.interface_name );
		}
	}

}
