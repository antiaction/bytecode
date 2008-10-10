/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;

public class Interfaces {

	public static void parseInterfaces(ByteCodeState bcs, int interfaces_count) throws ByteCodeException {
		bcs.assert_unexpected_eof( interfaces_count * 2 );

		List<String> interface_list = new ArrayList<String>();

		int interface_index;
		String interface_name;
		while( interfaces_count > 0 ) {
			interface_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			interface_name = bcs.constantpool.getClassName( interface_index );

			// debug
			System.out.println( "interfaces index: " + interface_index + "=" + interface_name );

			interface_list.add( interface_name );
			--interfaces_count;
		}
	}

}
