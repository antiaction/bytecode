/*
 * Created on 25/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode.instructions;

import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.bytecode.BytecodeState;
import com.antiaction.classfile.bytecode.IInstruction;
import com.antiaction.classfile.bytecode.Opcodes;

public class MethodReturnInstruction {

	public static class Instruction_IRETURN extends IInstruction {

		private static IInstruction instance;

		private Instruction_IRETURN() {
			opcode = Opcodes.OPCODE_IRETURN;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IRETURN();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IRETURN();
			}
			return instance;
		}

	}

	public static class Instruction_LRETURN extends IInstruction {

		private static IInstruction instance;

		private Instruction_LRETURN() {
			opcode = Opcodes.OPCODE_LRETURN;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LRETURN();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LRETURN();
			}
			return instance;
		}

	}

	public static class Instruction_FRETURN extends IInstruction {

		private static IInstruction instance;

		private Instruction_FRETURN() {
			opcode = Opcodes.OPCODE_FRETURN;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FRETURN();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FRETURN();
			}
			return instance;
		}

	}

	public static class Instruction_DRETURN extends IInstruction {

		private static IInstruction instance;

		private Instruction_DRETURN() {
			opcode = Opcodes.OPCODE_DRETURN;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DRETURN();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DRETURN();
			}
			return instance;
		}

	}

	public static class Instruction_ARETURN extends IInstruction {

		private static IInstruction instance;

		private Instruction_ARETURN() {
			opcode = Opcodes.OPCODE_ARETURN;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ARETURN();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ARETURN();
			}
			return instance;
		}

	}

	public static class Instruction_RETURN extends IInstruction {

		private static IInstruction instance;

		private Instruction_RETURN() {
			opcode = Opcodes.OPCODE_RETURN;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_RETURN();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_RETURN();
			}
			return instance;
		}

	}

}
