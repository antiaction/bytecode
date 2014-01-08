/*
 * Created on 15/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.descriptors;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.IDescriptor;

public class Descriptors {

	public static final int FDS_START = 0;
	public static final int FDS_ARRAY = 1;
	public static final int FDS_CLASS = 2;
	public static final int FDS_END = 3;

	public static IDescriptor parseFieldDescriptor(String descriptor_string) throws ClassFileException {
		IDescriptor descriptor = null;
		Descriptor_Array array = null;

		int state = 0;
		int index = 0;
		char c;
		StringBuffer sb = new StringBuffer();
		boolean b = true;
		while ( b ) {
			if ( index < descriptor_string.length() ) {
				c = descriptor_string.charAt( index );
				switch ( state ) {
				case FDS_START:
					switch ( c ) {
					case '[':
						array = new Descriptor_Array();
						descriptor = array;
						++index;
						state = FDS_ARRAY;
						break;
					case 'L':
						sb.setLength( 0 );
						++index;
						state = FDS_CLASS;
						break;
					case 'B':
						descriptor = new Descriptor_Byte();
						++index;
						state = FDS_END;
						break;
					case 'C':
						descriptor = new Descriptor_Char();
						++index;
						state = FDS_END;
						break;
					case 'D':
						descriptor = new Descriptor_Double();
						++index;
						state = FDS_END;
						break;
					case 'F':
						descriptor = new Descriptor_Float();
						++index;
						state = FDS_END;
						break;
					case 'I':
						descriptor = new Descriptor_Integer();
						++index;
						state = FDS_END;
						break;
					case 'J':
						descriptor = new Descriptor_Long();
						++index;
						state = FDS_END;
						break;
					case 'S':
						descriptor = new Descriptor_Short();
						++index;
						state = FDS_END;
						break;
					case 'Z':
						descriptor = new Descriptor_Boolean();
						++index;
						state = FDS_END;
						break;
					default:
						throw new ClassFileException( "Bad field descriptor" );
					}
					break;
				case FDS_ARRAY:
					switch ( c ) {
					case '[':
						++array.level;
						++index;
						state = FDS_ARRAY;
						break;
					case 'L':
						sb.setLength( 0 );
						++index;
						state = FDS_CLASS;
						break;
					case 'B':
						array.of = new Descriptor_Byte();
						++index;
						state = FDS_END;
						break;
					case 'C':
						array.of = new Descriptor_Char();
						++index;
						state = FDS_END;
						break;
					case 'D':
						array.of = new Descriptor_Double();
						++index;
						state = FDS_END;
						break;
					case 'F':
						array.of = new Descriptor_Float();
						++index;
						state = FDS_END;
						break;
					case 'I':
						array.of = new Descriptor_Integer();
						++index;
						state = FDS_END;
						break;
					case 'J':
						array.of = new Descriptor_Long();
						++index;
						state = FDS_END;
						break;
					case 'S':
						array.of = new Descriptor_Short();
						++index;
						state = FDS_END;
						break;
					case 'Z':
						array.of = new Descriptor_Boolean();
						++index;
						state = FDS_END;
						break;
					default:
						throw new ClassFileException( "Bad field descriptor" );
					}
					break;
				case FDS_CLASS:
					if ( c != ';' ) {
						sb.append( c );
						++index;
					}
					else {
						if ( array == null ) {
							descriptor = new Descriptor_Class( sb.toString() );
						}
						else {
							array.of = new Descriptor_Class( sb.toString() );
						}
						++index;
						state = FDS_END;
					}
					break;
				case FDS_END:
					throw new ClassFileException( "Unexpected field descriptor not ending" );
				}
			}
			else {
				if ( state != FDS_END ) {
					throw new ClassFileException( "Unexpected field descriptor end" );
				}
				b = false;
			}
		}

		return descriptor;
	}

}
