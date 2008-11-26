/*
 * Created on 26/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

public abstract class Instruction_LocalVariableStore extends IInstruction {

	public int index;

	public static class Instruction_ISTORE extends Instruction_LocalVariableStore {

		private Instruction_ISTORE() {
			opcode = Opcodes.OPCODE_ISTORE;
			length = 2;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_ISTORE instr = new Instruction_ISTORE(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_ISTORE instr = new Instruction_ISTORE(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_LSTORE extends Instruction_LocalVariableStore {

		private Instruction_LSTORE() {
			opcode = Opcodes.OPCODE_LSTORE;
			length = 2;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_LSTORE instr = new Instruction_LSTORE(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_LSTORE instr = new Instruction_LSTORE(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_FSTORE extends Instruction_LocalVariableStore {

		private Instruction_FSTORE() {
			opcode = Opcodes.OPCODE_FSTORE;
			length = 2;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_FSTORE instr = new Instruction_FSTORE(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_FSTORE instr = new Instruction_FSTORE(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_DSTORE extends Instruction_LocalVariableStore {

		private Instruction_DSTORE() {
			opcode = Opcodes.OPCODE_DSTORE;
			length = 2;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_DSTORE instr = new Instruction_DSTORE(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_DSTORE instr = new Instruction_DSTORE(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_ASTORE extends Instruction_LocalVariableStore {

		private Instruction_ASTORE() {
			opcode = Opcodes.OPCODE_ASTORE;
			length = 2;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_ASTORE instr = new Instruction_ASTORE(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_ASTORE instr = new Instruction_ASTORE(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_ISTORE_0 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ISTORE_0() {
			opcode = Opcodes.OPCODE_ISTORE_0;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_0();
			}
			return instance;
		}

	}

	public static class Instruction_ISTORE_1 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ISTORE_1() {
			opcode = Opcodes.OPCODE_ISTORE_1;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_1();
			}
			return instance;
		}

	}

	public static class Instruction_ISTORE_2 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ISTORE_2() {
			opcode = Opcodes.OPCODE_ISTORE_2;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_2();
			}
			return instance;
		}

	}

	public static class Instruction_ISTORE_3 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ISTORE_3() {
			opcode = Opcodes.OPCODE_ISTORE_3;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ISTORE_3();
			}
			return instance;
		}

	}

	public static class Instruction_LSTORE_0 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_LSTORE_0() {
			opcode = Opcodes.OPCODE_LSTORE_0;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_0();
			}
			return instance;
		}

	}

	public static class Instruction_LSTORE_1 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_LSTORE_1() {
			opcode = Opcodes.OPCODE_LSTORE_1;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_1();
			}
			return instance;
		}

	}

	public static class Instruction_LSTORE_2 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_LSTORE_2() {
			opcode = Opcodes.OPCODE_LSTORE_2;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_2();
			}
			return instance;
		}

	}

	public static class Instruction_LSTORE_3 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_LSTORE_3() {
			opcode = Opcodes.OPCODE_LSTORE_3;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LSTORE_3();
			}
			return instance;
		}

	}

	public static class Instruction_FSTORE_0 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_FSTORE_0() {
			opcode = Opcodes.OPCODE_FSTORE_0;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_0();
			}
			return instance;
		}

	}

	public static class Instruction_FSTORE_1 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_FSTORE_1() {
			opcode = Opcodes.OPCODE_FSTORE_1;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_1();
			}
			return instance;
		}

	}

	public static class Instruction_FSTORE_2 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_FSTORE_2() {
			opcode = Opcodes.OPCODE_FSTORE_2;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_2();
			}
			return instance;
		}

	}

	public static class Instruction_FSTORE_3 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_FSTORE_3() {
			opcode = Opcodes.OPCODE_FSTORE_3;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FSTORE_3();
			}
			return instance;
		}

	}

	public static class Instruction_DSTORE_0 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_DSTORE_0() {
			opcode = Opcodes.OPCODE_DSTORE_0;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_0();
			}
			return instance;
		}

	}

	public static class Instruction_DSTORE_1 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_DSTORE_1() {
			opcode = Opcodes.OPCODE_DSTORE_1;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_1();
			}
			return instance;
		}

	}

	public static class Instruction_DSTORE_2 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_DSTORE_2() {
			opcode = Opcodes.OPCODE_DSTORE_2;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_2();
			}
			return instance;
		}

	}

	public static class Instruction_DSTORE_3 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_DSTORE_3() {
			opcode = Opcodes.OPCODE_DSTORE_3;
			stack_consume_num = 2;
			stack_produce_num = 0;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DSTORE_3();
			}
			return instance;
		}

	}

	public static class Instruction_ASTORE_0 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ASTORE_0() {
			opcode = Opcodes.OPCODE_ASTORE_0;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_0();
			}
			return instance;
		}

	}

	public static class Instruction_ASTORE_1 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ASTORE_1() {
			opcode = Opcodes.OPCODE_ASTORE_1;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_1();
			}
			return instance;
		}

	}

	public static class Instruction_ASTORE_2 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ASTORE_2() {
			opcode = Opcodes.OPCODE_ASTORE_2;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_2();
			}
			return instance;
		}

	}

	public static class Instruction_ASTORE_3 extends Instruction_LocalVariableStore {

		private static IInstruction instance;

		private Instruction_ASTORE_3() {
			opcode = Opcodes.OPCODE_ASTORE_3;
			stack_consume_num = 1;
			stack_produce_num = 0;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ASTORE_3();
			}
			return instance;
		}

	}

}
