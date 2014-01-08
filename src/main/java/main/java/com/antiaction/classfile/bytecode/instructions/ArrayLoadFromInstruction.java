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

public abstract class ArrayLoadFromInstruction extends IInstruction {

	public static class Instruction_IALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_IALOAD() {
			opcode = Opcodes.OPCODE_IALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_IALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "iaload" };
		}

	}

	public static class Instruction_LALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_LALOAD() {
			opcode = Opcodes.OPCODE_LALOAD;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "laload" };
		}

	}

	public static class Instruction_FALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_FALOAD() {
			opcode = Opcodes.OPCODE_FALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "faload" };
		}

	}

	public static class Instruction_DALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_DALOAD() {
			opcode = Opcodes.OPCODE_DALOAD;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "daload" };
		}

	}

	public static class Instruction_AALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_AALOAD() {
			opcode = Opcodes.OPCODE_AALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_AALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_AALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "aaload" };
		}

	}

	public static class Instruction_BALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_BALOAD() {
			opcode = Opcodes.OPCODE_BALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_BALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_BALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "baload" };
		}

	}

	public static class Instruction_CALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_CALOAD() {
			opcode = Opcodes.OPCODE_CALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_CALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_CALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "caload" };
		}

	}

	public static class Instruction_SALOAD extends ArrayLoadFromInstruction {

		private static IInstruction instance;

		private Instruction_SALOAD() {
			opcode = Opcodes.OPCODE_SALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_SALOAD();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_SALOAD();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "saload" };
		}

	}

}
