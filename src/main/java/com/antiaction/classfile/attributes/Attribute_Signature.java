/*
 * Created on 06/01/2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;
import com.antiaction.classfile.constantpool.ConstantPool;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Attribute_Signature extends IAttribute {

	public int signature_index;
	public ConstantPool_Utf8 signature_cp;
	public String signature;

	public static IAttribute parseSignature(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int signature_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		ConstantPool_Utf8 signature_cp = cfs.cf.constantpool.getUtf8( signature_index );
		String signature = signature_cp.utf8;

		// debug
		//System.out.println( "Signature = " + signature );

		Attribute_Signature attribute = new Attribute_Signature();
		attribute.signature_index = signature_index;
		attribute.signature_cp = signature_cp;
		attribute.signature = signature;

		return attribute;
	}

	public static Attribute_Signature createSourceFil(ConstantPool cp, String signature) throws ClassFileException {
		Attribute_Signature signature_attr = new Attribute_Signature();
		signature_attr.signature = signature;
		signature_attr.signature_cp = cp.putUtf8( signature );
		return signature_attr;
	}

	@Override
	public void buildResolve() throws ClassFileException {
		signature_cp.buildResolve();
		signature_index = signature_cp.index;
	}

	@Override
	public byte[] build() throws IOException {
		byte[] bytes = new byte[ 2 ];
		bytes[ 0 ] = (byte)(signature_index >> 8);
		bytes[ 1 ] = (byte)(signature_index & 255);
		return bytes;
	}

}
