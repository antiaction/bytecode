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

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class Interfaces {

	public List<Interface> interface_list;

	public static Interfaces parseInterfaces(ClassFileState cfs, int interfaces_count) throws ClassFileException {
		cfs.assert_unexpected_eof( interfaces_count * 2 );

		List<Interface> interface_list = new ArrayList<Interface>();
		Interface interfaceObj;

		int interface_index;
		String interface_name;
		while( interfaces_count > 0 ) {
			interface_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			interface_name = cfs.cf.constantpool.getClassName( interface_index );

			// debug
			System.out.println( "interfaces index: " + interface_index + "=" + interface_name );

			interfaceObj = new Interface();
			interfaceObj.interface_index = interface_index;
			interfaceObj.interface_name = interface_name;

			interface_list.add( interfaceObj );
			--interfaces_count;
		}

		Interfaces interfaces = new Interfaces();
		interfaces.interface_list = interface_list;

		return interfaces;
	}

	public void build(ByteArrayOutputStream bytes) throws IOException {
		int interfaces_count = interface_list.size();

		bytes.write( (byte)(interfaces_count >> 8) );
		bytes.write( (byte)(interfaces_count & 255) );

		Interface interfaceObj;
		for ( int i=0; i<interface_list.size(); ++i ) {
			interfaceObj = interface_list.get( i );

			bytes.write( (byte)(interfaceObj.interface_index >> 8) );
			bytes.write( (byte)(interfaceObj.interface_index & 255) );
		}
	}

}
