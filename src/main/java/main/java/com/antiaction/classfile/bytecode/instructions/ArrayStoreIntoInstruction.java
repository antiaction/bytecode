/*
 * Created on 26/11/2008
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

public abstract class ArrayStoreIntoInstruction extends IInstruction {

	public static class Instruction_IASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_IASTORE() {
			opcode = Opcodes.OPCODE_IASTORE;
			stack_consume_num = 3;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_IASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "iastore" };
		}

	}

	public static class Instruction_LASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_LASTORE() {
			opcode = Opcodes.OPCODE_LASTORE;
			stack_consume_num = 4;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lastore" };
		}

	}

	public static class Instruction_FASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_FASTORE() {
			opcode = Opcodes.OPCODE_FASTORE;
			stack_consume_num = 3;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "fastore" };
		}

	}

	public static class Instruction_DASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_DASTORE() {
			opcode = Opcodes.OPCODE_DASTORE;
			stack_consume_num = 4;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "dastore" };
		}

	}

	public static class Instruction_AASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_AASTORE() {
			opcode = Opcodes.OPCODE_AASTORE;
			stack_consume_num = 3;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_AASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_AASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "aastore" };
		}

	}

	public static class Instruction_BASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_BASTORE() {
			opcode = Opcodes.OPCODE_BASTORE;
			stack_consume_num = 3;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_BASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_BASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "bastore" };
		}

	}

	public static class Instruction_CASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_CASTORE() {
			opcode = Opcodes.OPCODE_CASTORE;
			stack_consume_num = 3;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_CASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_CASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "castore" };
		}

	}

	public static class Instruction_SASTORE extends ArrayStoreIntoInstruction {

		private static IInstruction instance;

		private Instruction_SASTORE() {
			opcode = Opcodes.OPCODE_SASTORE;
			stack_consume_num = 3;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_SASTORE();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_SASTORE();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "sastore" };
		}

	}

}
