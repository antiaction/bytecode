/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.fields;

import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;

public class Fields {

	public static void parseFields(ByteCodeState bcs, int fields_count) throws ByteCodeException {
		int access_flags;
		int name_index;
		int descriptor_index;
		int attributes_count;

		while( fields_count > 0 ) {
			bcs.assert_unexpected_eof( 8 );

			access_flags = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			name_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			descriptor_index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			attributes_count = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			--fields_count;
		}

	}

}
