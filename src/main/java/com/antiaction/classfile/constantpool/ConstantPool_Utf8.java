/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IConstantPool_Info;

public class ConstantPool_Utf8 extends IConstantPool_Info {

	public int tag = ConstantPool.CONSTANT_Utf8;

	public String utf8;

	public static IConstantPool_Info parseUtf8(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		cfs.assert_unexpected_eof( length );

		StringBuffer sb = new StringBuffer();
		int b0, b1, b2;
		char c;

		while ( length > 0 ) {
			b0 = cfs.bytes[ cfs.index++ ] & 255;
			--length;

			if ( (b0 & 0x80) == 0 ) {
				c = (char)b0;
				sb.append( c );
			}
			else {
				b1 = cfs.bytes[ cfs.index++ ] & 255;
				--length;

				if ( (b0 & 0xe0) == 0xc0 && (b1 & 0xc0) == 0x80 ) {
					c = (char)(((b0 & 0x1f) << 6) | (b1 & 0x3f));
					sb.append( c );
				}
				else {
					b2 = cfs.bytes[ cfs.index++ ] & 255;
					--length;

					if ( ((b0 & 0xf0) == 0xe0) && ((b1 & 0xc0) == 0x80) && ((b2 & 0xc0) == 0x80) ) {
						c = (char)(((b0 & 0x0f) << 12) | ((b1 & 0x3f) << 6) | (b2 & 0x3f));
						sb.append( c );
					}
					else {
						throw new ClassFileException( "Invalid constant pool Utf-8 encoding",  cfs.index );
					}
				}
			}
		}

		if ( length != 0 ) {
			throw new ClassFileException( "Empty constant pool Utf-8 string", cfs.index );
		}

		// debug
		System.out.println( "Utf8: " + sb.toString() );

		ConstantPool_Utf8 cp_info = new ConstantPool_Utf8();
		cp_info.utf8 = sb.toString();

		return cp_info;
	}

	@Override
	public void parseResolve(ClassFileState cfs) {
 	}

	@Override
	public void build(ByteArrayOutputStream bytes) throws IOException {
		ByteArrayOutputStream encoded = new ByteArrayOutputStream( utf8.length() );

		char c;
		for ( int i=0; i<utf8.length(); ++i ) {
			c = utf8.charAt( i );
			if ( c >= 0x01 && c <= 0x7f ) {
				encoded.write( c & 0x7f );
			}
			else if ( (c >= 0x0080 && c <= 0x07ff) || c == 0 ) {
				encoded.write( ((c >> 6) & 0x1f) | 0xc0 );
				encoded.write( (c & 0x3f) | 0x80 );
			}
			else {
				encoded.write( ((c >> 12) & 0x0f) | 0xe0 );
				encoded.write( ((c >> 6) & 0x3f) | 0x80 );
				encoded.write( (c & 0x3f) | 0x80 );
			}
		}

		bytes.write( (byte)(tag & 255) );

		int constant_pool_count = encoded.size();

		bytes.write( (byte)(constant_pool_count >> 8) );
		bytes.write( (byte)(constant_pool_count & 255) );

		encoded.writeTo( bytes );
	}

}
