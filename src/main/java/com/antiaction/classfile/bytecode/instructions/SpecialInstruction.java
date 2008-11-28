/*
 * Created on 27/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode.instructions;

import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.bytecode.BytecodeState;
import com.antiaction.classfile.bytecode.IInstruction;
import com.antiaction.classfile.bytecode.Opcodes;
import com.antiaction.classfile.bytecode.instructions.BranchInstruction.Instruction_GOTO;
import com.antiaction.classfile.bytecode.instructions.BranchInstruction.Instruction_GOTO_W;
import com.antiaction.classfile.bytecode.instructions.LocalVariableLoadInstruction.Instruction_ILOAD;

public abstract class SpecialInstruction extends IInstruction {

	public static class Instruction_NOP extends SpecialInstruction {

		private static IInstruction instance;

		private Instruction_NOP() {
			opcode = Opcodes.OPCODE_NOP;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_NOP();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_NOP();
			}
			return instance;
		}

	}

	public static class Instruction_ACONST_NULL extends SpecialInstruction {

		private static IInstruction instance;

		private Instruction_ACONST_NULL() {
			opcode = Opcodes.OPCODE_ACONST_NULL;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ACONST_NULL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ACONST_NULL();
			}
			return instance;
		}

	}

	public static class Instruction_JSR extends SpecialInstruction {

		public int instruction_index;

		public int branch_offset;

		private Instruction_JSR() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_JSR;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_JSR instr = new Instruction_JSR(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			//instr.instruction_branch = instr;
			return instr;
		}

		public static IInstruction getInstance(int branch_offset) {
			Instruction_JSR instr = new Instruction_JSR(); 
			instr.branch_offset = branch_offset;
			//instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_RET extends SpecialInstruction {

		public int index;

		private Instruction_RET() {
			opcode = Opcodes.OPCODE_RET;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_RET instr = new Instruction_RET(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_RET instr = new Instruction_RET(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_JSR_W extends SpecialInstruction {

		public int instruction_index;

		public int branch_offset;

		private Instruction_JSR_W() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_JSR_W;
			length = 5;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 4 );
			Instruction_JSR_W instr = new Instruction_JSR_W(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			//instr.instruction_branch = instr;
			return instr;
		}

		public static IInstruction getInstance(int branch_offset) {
			Instruction_JSR_W instr = new Instruction_JSR_W(); 
			instr.branch_offset = branch_offset;
			//instr.instruction_branch = instr;
			return instr;
		}

	}






	/*
	public static class Instruction_NOP extends Instruction {

		private static Instruction instance;

		private Instruction_NOP() {
			opcode = Opcodes.OPCODE_NOP;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_NOP();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_NOP();
			}
			return instance;
		}

	}
	 */

}
