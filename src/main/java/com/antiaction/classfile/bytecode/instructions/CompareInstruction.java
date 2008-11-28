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

public abstract class CompareInstruction extends IInstruction {

	public static class Instruction_LCMP extends CompareInstruction {

		private static IInstruction instance;

		private Instruction_LCMP() {
			opcode = Opcodes.OPCODE_LCMP;
			stack_consume_num = 4;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LCMP();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LCMP();
			}
			return instance;
		}

	}

	public static class Instruction_FCMPL extends CompareInstruction {

		private static IInstruction instance;

		private Instruction_FCMPL() {
			opcode = Opcodes.OPCODE_FCMPL;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCMPL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCMPL();
			}
			return instance;
		}

	}

	public static class Instruction_FCMPG extends CompareInstruction {

		private static IInstruction instance;

		private Instruction_FCMPG() {
			opcode = Opcodes.OPCODE_FCMPG;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCMPG();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCMPG();
			}
			return instance;
		}

	}

	public static class Instruction_DCMPL extends CompareInstruction {

		private static IInstruction instance;

		private Instruction_DCMPL() {
			opcode = Opcodes.OPCODE_DCMPL;
			stack_consume_num = 4;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DCMPL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DCMPL();
			}
			return instance;
		}

	}

	public static class Instruction_DCMPG extends CompareInstruction {

		private static IInstruction instance;

		private Instruction_DCMPG() {
			opcode = Opcodes.OPCODE_DCMPG;
			stack_consume_num = 4;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DCMPG();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DCMPG();
			}
			return instance;
		}

	}

}
