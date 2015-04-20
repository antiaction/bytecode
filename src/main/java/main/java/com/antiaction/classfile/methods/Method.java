/*
 * Created on 18/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.methods;

import com.antiaction.classfile.Bits;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;
import com.antiaction.classfile.attributes.Attribute_Code;
import com.antiaction.classfile.attributes.Attribute_Deprecated;
import com.antiaction.classfile.attributes.Attribute_Exceptions;
import com.antiaction.classfile.attributes.Attribute_Signature;
import com.antiaction.classfile.attributes.Attribute_Synthetic;
import com.antiaction.classfile.attributes.Attributes;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Method {

	public int access_flags;

	public boolean bAbstract = false;

	public int name_index;
	public ConstantPool_Utf8 name_cp;
	public String name;

	public int descriptor_index;
	public ConstantPool_Utf8 descriptor_cp;
	public String descriptor_string;

	public Attributes attributes;

	public Attribute_Code codeAttr = null;

	public Attribute_Deprecated deprecatedAttr = null;

	public Attribute_Exceptions exceptionsAttr = null;

	public Attribute_Synthetic syntheticAttr = null;

	public Attribute_Signature signatureAttr = null;

	public void validate_access_flags(ClassFileState cfs) throws ClassFileException {
		// Check against supported access flags.
		if ( (access_flags & ~Constants.METHOD_ACCESS_FLAGS_MASK) != 0 ) {
			throw new ClassFileException( "Invalid method access flags: 0x" + Integer.toHexString( access_flags & ~Constants.METHOD_ACCESS_FLAGS_MASK ) );
		}

		// debug
		//System.out.println( "Method: " + name );

		if ( cfs.cf.bClass ) {
			if ( name.startsWith( "<" ) & name.endsWith( ">" ) ) {
				if ( "<clinit>".compareTo( name ) == 0 ) {
				}
				else if ( "<init>".compareTo( name ) == 0 ) {
				}
				else {
					throw new ClassFileException( "No" );
				}
			}
			else {
				if ( Bits.bitstobits[ access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ] > 1 ) {
					throw new ClassFileException( "Invalid class method access flags: 0x" + Integer.toHexString( access_flags & (Constants.ACC_PUBLIC | Constants.ACC_PRIVATE | Constants.ACC_PROTECTED) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
				}
				if ( (access_flags & Constants.ACC_ABSTRACT) == Constants.ACC_ABSTRACT ) {
					bAbstract = true;
					if ( !cfs.cf.bAbstract ) {
						throw new ClassFileException( "Method not declared in abstract class" );
					}
					if ( (access_flags & (Constants.ACC_PRIVATE | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNCHRONIZED | Constants.ACC_NATIVE | Constants.ACC_STRICT)) != 0 ) {
						throw new ClassFileException( "Invalid class abstract method access flags: 0x" + Integer.toHexString( access_flags & (Constants.ACC_PRIVATE | Constants.ACC_STATIC | Constants.ACC_FINAL | Constants.ACC_SYNCHRONIZED | Constants.ACC_NATIVE | Constants.ACC_STRICT) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
					}
				}
			}
		}
		else if ( cfs.cf.bInterface ) {
			if ( name.startsWith( "<" ) & name.endsWith( ">" ) ) {
				if ( "<clinit>".compareTo( name ) == 0 ) {
				}
				else {
					throw new ClassFileException( "No" );
				}
			}
			else {
				if ( (access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT )) != ( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT ) ) {
					throw new ClassFileException( "Invalid interface method access flags combination: 0x" + Integer.toHexString( access_flags & ( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT ) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
				}
				if ( (access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT | Constants.ACC_BRIDGE | Constants.ACC_VARARGS | Constants.ACC_SYNTHETIC )) != 0 ) {
					throw new ClassFileException( "Invalid interface method access flags combination: 0x" + Integer.toHexString( access_flags & ~( Constants.ACC_PUBLIC | Constants.ACC_ABSTRACT | Constants.ACC_BRIDGE | Constants.ACC_VARARGS | Constants.ACC_SYNTHETIC ) ) + " (0x" + Integer.toHexString( access_flags ) + ")" );
				}
			}
		}
		else {
			throw new ClassFileException( "Unknown method access flags combination: 0x" + Integer.toHexString( access_flags ) );
		}
	}

}
