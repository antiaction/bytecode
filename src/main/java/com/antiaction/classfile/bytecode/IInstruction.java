/*
 * Created on 14/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

import com.antiaction.classfile.bytecode.instructions.BranchInstruction;

public abstract class IInstruction {

	public int opcode = -1;

	public int length = 1;

	public int stack_consume_num = 0;

	public int stack_produce_num = 0;

 	public BranchInstruction instruction_branch = null;

}
