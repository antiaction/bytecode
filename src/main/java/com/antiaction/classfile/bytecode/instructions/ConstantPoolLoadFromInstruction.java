/*
 * Created on 26/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode.instructions;

import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.bytecode.BytecodeState;
import com.antiaction.classfile.bytecode.IInstruction;
import com.antiaction.classfile.bytecode.Opcodes;

public abstract class ConstantPoolLoadFromInstruction extends IInstruction {

	public int index;

	public static class Instruction_LDC extends ConstantPoolLoadFromInstruction {

		private Instruction_LDC() {
			opcode = Opcodes.OPCODE_LDC;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_LDC instr = new Instruction_LDC(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_LDC instr = new Instruction_LDC(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_LDC_W extends ConstantPoolLoadFromInstruction {

		private Instruction_LDC_W() {
			opcode = Opcodes.OPCODE_LDC_W;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_LDC_W instr = new Instruction_LDC_W(); 
			instr.index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_LDC_W instr = new Instruction_LDC_W(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_LDC2_W extends ConstantPoolLoadFromInstruction {

		private Instruction_LDC2_W() {
			opcode = Opcodes.OPCODE_LDC2_W;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_LDC2_W instr = new Instruction_LDC2_W(); 
			instr.index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_LDC2_W instr = new Instruction_LDC2_W(); 
			instr.index = index;
			return instr;
		}

	}

}
