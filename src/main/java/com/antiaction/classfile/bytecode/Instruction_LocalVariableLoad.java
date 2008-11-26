/*
 * Created on 26/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

public abstract class Instruction_LocalVariableLoad extends IInstruction {

	public int index;

	public static class Instruction_ILOAD extends Instruction_LocalVariableLoad {

		private Instruction_ILOAD() {
			opcode = Opcodes.OPCODE_ILOAD;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_ILOAD instr = new Instruction_ILOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_ILOAD instr = new Instruction_ILOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_LLOAD extends Instruction_LocalVariableLoad {

		private Instruction_LLOAD() {
			opcode = Opcodes.OPCODE_LLOAD;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_LLOAD instr = new Instruction_LLOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_LLOAD instr = new Instruction_LLOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_FLOAD extends Instruction_LocalVariableLoad {

		private Instruction_FLOAD() {
			opcode = Opcodes.OPCODE_FLOAD;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_FLOAD instr = new Instruction_FLOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_FLOAD instr = new Instruction_FLOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_DLOAD extends Instruction_LocalVariableLoad {

		private Instruction_DLOAD() {
			opcode = Opcodes.OPCODE_DLOAD;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_DLOAD instr = new Instruction_DLOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_DLOAD instr = new Instruction_DLOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_ALOAD extends Instruction_LocalVariableLoad {

		private Instruction_ALOAD() {
			opcode = Opcodes.OPCODE_ALOAD;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_ALOAD instr = new Instruction_ALOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_ALOAD instr = new Instruction_ALOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_ILOAD_0 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ILOAD_0() {
			opcode = Opcodes.OPCODE_ILOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_ILOAD_1 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ILOAD_1() {
			opcode = Opcodes.OPCODE_ILOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_ILOAD_2 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ILOAD_2() {
			opcode = Opcodes.OPCODE_ILOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_2();
			}
			return instance;
		}

	}

	public static class Instruction_ILOAD_3 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ILOAD_3() {
			opcode = Opcodes.OPCODE_ILOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_3();
			}
			return instance;
		}

	}

	public static class Instruction_LLOAD_0 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_LLOAD_0() {
			opcode = Opcodes.OPCODE_LLOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_LLOAD_1 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_LLOAD_1() {
			opcode = Opcodes.OPCODE_LLOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_LLOAD_2 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_LLOAD_2() {
			opcode = Opcodes.OPCODE_LLOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_2();
			}
			return instance;
		}

	}

	public static class Instruction_LLOAD_3 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_LLOAD_3() {
			opcode = Opcodes.OPCODE_LLOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_3();
			}
			return instance;
		}

	}

	public static class Instruction_FLOAD_0 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_FLOAD_0() {
			opcode = Opcodes.OPCODE_FLOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_FLOAD_1 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_FLOAD_1() {
			opcode = Opcodes.OPCODE_FLOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_FLOAD_2 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_FLOAD_2() {
			opcode = Opcodes.OPCODE_FLOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_2();
			}
			return instance;
		}

	}

	public static class Instruction_FLOAD_3 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_FLOAD_3() {
			opcode = Opcodes.OPCODE_FLOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_3();
			}
			return instance;
		}

	}

	public static class Instruction_DLOAD_0 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_DLOAD_0() {
			opcode = Opcodes.OPCODE_DLOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_DLOAD_1 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_DLOAD_1() {
			opcode = Opcodes.OPCODE_DLOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_DLOAD_2 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_DLOAD_2() {
			opcode = Opcodes.OPCODE_DLOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_2();
			}
			return instance;
		}

	}

	public static class Instruction_DLOAD_3 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_DLOAD_3() {
			opcode = Opcodes.OPCODE_DLOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_3();
			}
			return instance;
		}

	}

	public static class Instruction_ALOAD_0 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ALOAD_0() {
			opcode = Opcodes.OPCODE_ALOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_0();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_ALOAD_1 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ALOAD_1() {
			opcode = Opcodes.OPCODE_ALOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_1();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_ALOAD_2 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ALOAD_2() {
			opcode = Opcodes.OPCODE_ALOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_2();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_2();
			}
			return instance;
		}

	}

	public static class Instruction_ALOAD_3 extends Instruction_LocalVariableLoad {

		private static IInstruction instance;

		private Instruction_ALOAD_3() {
			opcode = Opcodes.OPCODE_ALOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 3;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_3();
			}
			return instance;
		}

		public static IInstruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_3();
			}
			return instance;
		}

	}

}
