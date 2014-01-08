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
import com.antiaction.classfile.attributes.Attribute_ConstantValue;
import com.antiaction.classfile.attributes.Attribute_Deprecated;
import com.antiaction.classfile.attributes.Attribute_Exceptions;
import com.antiaction.classfile.attributes.Attribute_Signature;
import com.antiaction.classfile.attributes.Attribute_Synthetic;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Field {

	public static final int ACC_PUBLIC = 0x0001;		// Declared public; may be accessed from outside its package.
	public static final int ACC_PRIVATE = 0x0002;		// Declared private; usable only within the defining class.
	public static final int ACC_PROTECTED = 0x0004;		// Declared protected; may be accessed within subclasses.
	public static final int ACC_STATIC = 0x0008;		// Declared static.
	public static final int ACC_FINAL = 0x0010;			// Declared final; no further assignment after initialization.
	public static final int ACC_VOLATILE = 0x0040;		// Declared volatile; cannot be cached.
	public static final int ACC_TRANSIENT = 0x0080;		// Declared transient; not written or read by a persistent object manager.
	public static final int ACC_SYNTHETIC = 0x1000;		// Declared synthetic; Not present in the	source code.
	public static final int ACC_ENUM = 0x4000;			// Declared as an element of an enum.
	//public static final int ACC_ = ;

	public static final int FIELD_ACCESS_FLAGS_MASK = ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED | ACC_STATIC | ACC_FINAL | ACC_VOLATILE | ACC_TRANSIENT | ACC_SYNTHETIC | ACC_ENUM;

	public int access_flags;

	public int name_index;
	public ConstantPool_Utf8 name_cp;
	public String name;

	public int descriptor_index;
	public ConstantPool_Utf8 descriptor_cp;
	public String descriptor_string;

	public Attributes attributes;

	public Attribute_ConstantValue constantValueAttr = null;

	public Attribute_Deprecated deprecatedAttr = null;

	public Attribute_Synthetic syntheticAttr = null;

	public Attribute_Signature signatureAttr = null;

	public void validate_access_flags(ClassFileState cfs) throws ClassFileException {
		// Check against supported access flags.
		if ( (access_flags & ~FIELD_ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~FIELD_ACCESS_FLAGS_MASK ) );
		}

		if ( cfs.cf.bClass ) {
			// Class fields can at most have one of the following flags set.
			if ( Bits.bitstobits[ access_flags & (ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED) ] > 1 ) {
				throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & (ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED) ) );
			}

			// Class fields can not have both flags set at the same time.
			if ( (access_flags & ( ACC_FINAL | ACC_VOLATILE )) == ( ACC_FINAL | ACC_VOLATILE ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_FINAL | ACC_VOLATILE ) ) );
			}
		}
		else if ( cfs.cf.bInterface ) {
			// Interface fields must have these three flags set.
			if ( (access_flags & ( ACC_PUBLIC | ACC_STATIC | ACC_FINAL )) != ( ACC_PUBLIC | ACC_STATIC | ACC_FINAL ) ) {
				throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ( ACC_PUBLIC | ACC_STATIC | ACC_FINAL ) ) );
			}

			// Interface fields can optionally have this field set.
			if ( (access_flags & ~( ACC_PUBLIC | ACC_STATIC | ACC_FINAL | ACC_SYNTHETIC )) != 0 ) {
				throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ~( ACC_PUBLIC | ACC_STATIC | ACC_FINAL | ACC_SYNTHETIC ) ) );
			}
		}
		else {
			throw new ClassFileException( "Unknown field access flags combination: 0x" + Integer.toHexString( access_flags ) );
		}
	}

}
