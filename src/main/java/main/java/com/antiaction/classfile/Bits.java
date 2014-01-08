/*
 * Created on 12/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

public class Bits {

	public static int bitstobits[] = new int[ 256 ];

	static {
		for ( int i=0; i<256; ++i ) {
			int bits = 0;
			for ( int j=0; j<8; ++j) {
				if ( (i & (1 << j)) != 0 ) {
					++bits;
				}
			}
			bitstobits[ i ] = bits;
		}
	}

}
