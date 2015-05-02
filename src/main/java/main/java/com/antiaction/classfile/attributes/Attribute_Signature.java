/*
 * Created on 06/01/2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;
import com.antiaction.classfile.constantpool.ConstantPool;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Attribute_Signature extends AttributeAbstract {

	public int signature_index;

	public ConstantPool_Utf8 signature_cp;

	public String signature;

	public Attribute_Signature() {
		classfileVersion = Constants.CLASSFILE_VERSION_49_0;
		jvmVersion = Constants.JVM_VERSION_5_0;
		usage = Constants.ATTR_LOCATION_CLASSFILE | Constants.ATTR_LOCATION_FIELD_INFO | Constants.ATTR_LOCATION_METHOD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		signature_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		signature_cp = cfs.cf.constantpool.getUtf8( signature_index );
		signature = signature_cp.utf8;

		// debug
		//System.out.println( "Signature = " + signature );
	}

	public static Attribute_Signature createSourceFil(ConstantPool cp, String signature) throws ClassFileException {
		Attribute_Signature signature_attr = new Attribute_Signature();
		signature_attr.signature = signature;
		signature_attr.signature_cp = cp.putUtf8( signature );
		return signature_attr;
	}

	@Override
	public void resolve() throws ClassFileException {
		signature_cp.buildResolve();
		signature_index = signature_cp.index;
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(signature_index >> 8) );
		out.write( (byte)(signature_index & 255) );
	}

}
