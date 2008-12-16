/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.fields;

import com.antiaction.classfile.Bits;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.attributes.Attributes;

public class Field {

	public static final int ACC_PUBLIC = 0x0001;
	public static final int ACC_PRIVATE = 0x0002;
	public static final int ACC_PROTECTED = 0x0004;
	public static final int ACC_STATIC = 0x0008;
	public static final int ACC_FINAL = 0x0010;
	public static final int ACC_VOLATILE = 0x0040;
	public static final int ACC_TRANSIENT = 0x0080;
	//public static final int ACC_ = ;

	public static final int FIELD_ACCESS_FLAGS_MASK = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED | ACC_STATIC | ACC_FINAL | ACC_VOLATILE | ACC_TRANSIENT;

	public int access_flags;
	public int name_index;
	public int descriptor_index;

	public String name;
	public String descriptor_string;

	public Attributes attributes;

	public void validate_access_flags(ClassFileState cfs) throws ClassFileException {
		if ( (access_flags & ~FIELD_ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~FIELD_ACCESS_FLAGS_MASK ) );
		}

		if ( Bits.bitstobits[ access_flags & (ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED) ] > 1 ) {
			throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & (ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED) ) );
		}

		if ( (access_flags & ( ACC_FINAL | ACC_VOLATILE )) == ( ACC_FINAL | ACC_VOLATILE ) ) {
			throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_FINAL | ACC_VOLATILE ) ) );
		}

		if ( cfs.bInterface ) {
			if ( (access_flags & ( ACC_PUBLIC | ACC_STATIC | ACC_FINAL )) != ( ACC_PUBLIC | ACC_STATIC | ACC_FINAL ) ) {
				throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_PUBLIC | ACC_STATIC | ACC_FINAL ) ) );
			}
		}
	}

}
