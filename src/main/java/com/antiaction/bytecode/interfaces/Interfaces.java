/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;

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
			interface_name = cfs.constantpool.getClassName( interface_index );

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

}
