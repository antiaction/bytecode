/*
 * Created on 28/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode.instructions;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.bytecode.Bytecode;
import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.bytecode.BytecodeState;
import com.antiaction.classfile.bytecode.IInstruction;
import com.antiaction.classfile.bytecode.Opcodes;

public abstract class MonitorInstruction extends IInstruction {

	public static class Instruction_MONITORENTER extends MonitorInstruction {

		private static IInstruction instance;

		private Instruction_MONITORENTER() {
			opcode = Opcodes.OPCODE_MONITORENTER;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_MONITORENTER();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_MONITORENTER();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "monitorenter" };
		}

	}

	public static class Instruction_MONITOREXIT extends MonitorInstruction {

		private static IInstruction instance;

		private Instruction_MONITOREXIT() {
			opcode = Opcodes.OPCODE_MONITOREXIT;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_MONITOREXIT();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_MONITOREXIT();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "monitorexit" };
		}

	}

}
