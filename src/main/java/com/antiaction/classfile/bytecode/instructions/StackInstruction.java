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

public abstract class StackInstruction extends IInstruction {

	public static class Instruction_POP extends StackInstruction {

		private static IInstruction instance;

		private Instruction_POP() {
			opcode = Opcodes.OPCODE_POP;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_POP();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_POP();
			}
			return instance;
		}

	}

	public static class Instruction_POP2 extends StackInstruction {

		private static IInstruction instance;

		private Instruction_POP2() {
			opcode = Opcodes.OPCODE_POP2;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_POP2();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_POP2();
			}
			return instance;
		}

	}

	public static class Instruction_DUP extends StackInstruction {

		private static IInstruction instance;

		private Instruction_DUP() {
			opcode = Opcodes.OPCODE_DUP;
			stack_consume_num = 1;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DUP();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DUP();
			}
			return instance;
		}

	}

	public static class Instruction_DUP_X1 extends StackInstruction {

		private static IInstruction instance;

		private Instruction_DUP_X1() {
			opcode = Opcodes.OPCODE_DUP_X1;
			stack_consume_num = 2;
			stack_produce_num = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DUP_X1();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DUP_X1();
			}
			return instance;
		}

	}

	public static class Instruction_DUP_X2 extends StackInstruction {

		private static IInstruction instance;

		private Instruction_DUP_X2() {
			opcode = Opcodes.OPCODE_DUP_X2;
			stack_consume_num = 3;
			stack_produce_num = 4;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DUP_X2();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DUP_X2();
			}
			return instance;
		}

	}

	public static class Instruction_DUP2 extends StackInstruction {

		private static IInstruction instance;

		private Instruction_DUP2() {
			opcode = Opcodes.OPCODE_DUP2;
			stack_consume_num = 2;
			stack_produce_num = 4;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DUP2();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DUP2();
			}
			return instance;
		}

	}

	public static class Instruction_DUP2_X1 extends StackInstruction {

		private static IInstruction instance;

		private Instruction_DUP2_X1() {
			opcode = Opcodes.OPCODE_DUP2_X1;
			stack_consume_num = 3;
			stack_produce_num = 5;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DUP2_X1();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DUP2_X1();
			}
			return instance;
		}

	}

	public static class Instruction_DUP2_X2 extends StackInstruction {

		private static IInstruction instance;

		private Instruction_DUP2_X2() {
			opcode = Opcodes.OPCODE_DUP2_X2;
			stack_consume_num = 4;
			stack_produce_num = 6;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DUP2_X2();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DUP2_X2();
			}
			return instance;
		}

	}

	public static class Instruction_SWAP extends StackInstruction {

		private static IInstruction instance;

		private Instruction_SWAP() {
			opcode = Opcodes.OPCODE_SWAP;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_SWAP();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_SWAP();
			}
			return instance;
		}

	}

}
