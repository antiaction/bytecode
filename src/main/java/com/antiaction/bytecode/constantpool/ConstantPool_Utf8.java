/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.constantpool;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IConstantPool_Info;

public class ConstantPool_Utf8 implements IConstantPool_Info {

	public String utf8;

	public static IConstantPool_Info parseUtf8(ClassFileState bcs) throws ClassFileException {
		bcs.assert_unexpected_eof( 2 );

		int length = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		bcs.assert_unexpected_eof( length );

		StringBuffer sb = new StringBuffer();
		int b0, b1, b2;
		char c;

		while ( length > 0 ) {
			b0 = bcs.bytes[ bcs.index++ ] & 255;
			--length;

			if ( (b0 & 0x80) == 0 ) {
				c = (char)b0;
				sb.append( c );
			}
			else {
				b1 = bcs.bytes[ bcs.index++ ] & 255;
				--length;

				if ( (b0 & 0xe0) == 0xc0 && (b1 & 0xc0) == 0x80 ) {
					c = (char)(((b0 & 0x1f) << 5) | (b1 & 0x3f));
					sb.append( c );
				}
				else {
					b2 = bcs.bytes[ bcs.index++ ] & 255;
					--length;

					if ( ((b0 & 0xf0) == 0xe0) && ((b1 & 0xc0) == 0x80) && ((b2 & 0xc0) == 0x80) ) {
						c = (char)(((b0 & 0x0f) << 12) | ((b1 & 0x3f) << 6) | (b2 & 0x3f));
						sb.append( c );
					}
					else {
						throw new ClassFileException( "Invalid constant pool Utf-8 encoding",  bcs.index );
					}
				}
			}
		}

		if ( length != 0 ) {
			throw new ClassFileException( "Empty constant pool Utf-8 string", bcs.index );
		}

		// debug
		System.out.println( "Utf8: " + sb.toString() );

		ConstantPool_Utf8 cp_info = new ConstantPool_Utf8();
		cp_info.utf8 = sb.toString();

		return cp_info;
	}

}
