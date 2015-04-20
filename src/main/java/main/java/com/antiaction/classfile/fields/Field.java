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
import com.antiaction.classfile.Constants;
import com.antiaction.classfile.attributes.Attribute_ConstantValue;
import com.antiaction.classfile.attributes.Attribute_Deprecated;
import com.antiaction.classfile.attributes.Attribute_Signature;
import com.antiaction.classfile.attributes.Attribute_Synthetic;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Field {

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
		if ( (access_flags & ~Constants.FIELD_ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & ~Constants.FIELD_ACCESS_FLAGS_MASK ) );
		}

		if ( cfs.cf.bClass ) {
			// Class fields can at most have one of the following flags set.
			if ( Bits.bitstobits[ access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ] > 1 ) {
				throw new ClassFileException( "Invalid access flags: 0x" + Integer.toHexString( access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ) );
			}

			// Class fields can not have both flags set at the same time.
			if ( (access_flags & ( Constants.ACC_FINAL | Constants.ACC_VOLATILE )) == ( Constants.ACC_FINAL | Constants.ACC_VOLATILE ) ) {
				throw new ClassFileException( "Invalid access flags combination: 0x" + Integer.toHexString( access_flags & ( Constants.ACC_FINAL | Constants.ACC_VOLATILE ) ) );
			}
		}
		else if ( cfs.cf.bInterface ) {
			// Interface fields must have these three flags set.
			if ( (access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL )) != ( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL ) ) {
				throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL ) ) );
			}

			// Interface fields can optionally have this field set.
			if ( (access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNTHETIC )) != 0 ) {
				throw new ClassFileException( "Invalid interface access flags combination: 0x" + Integer.toHexString( access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNTHETIC ) ) );
			}
		}
		else {
			throw new ClassFileException( "Unknown field access flags combination: 0x" + Integer.toHexString( access_flags ) );
		}
	}

}
