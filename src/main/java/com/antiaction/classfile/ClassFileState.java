/*
 * Created on 08/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile;

import com.antiaction.classfile.constantpool.ConstantPool;
import com.antiaction.classfile.fields.Fields;
import com.antiaction.classfile.interfaces.Interfaces;
import com.antiaction.classfile.methods.Methods;


public class ClassFileState {

	public byte[] bytes;
	public int index = 0;

	public boolean bClass = false;

	public boolean bFinal = false;

	public boolean bInterface = false;

	public boolean bAbstract = false;

	public ConstantPool constantpool;

	public Interfaces interfaces;

	public Fields fields;

	public Methods methods;

	public ClassFileState(byte[] bytes) {
		this.bytes = bytes;
	}

	public void assert_unexpected_eof(int length) throws ClassFileException {
		if ( index + length > bytes.length ) {
			throw new ClassFileException( "to be continued...", index );
		}
	}

}
