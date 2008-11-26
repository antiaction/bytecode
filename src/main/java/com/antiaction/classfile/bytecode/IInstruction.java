/*
 * Created on 14/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

public abstract class IInstruction {

	public int opcode = -1;

	public int length = 1;

	public int stack_consume_num = 0;

	public int stack_produce_num = 0;

 	public Instruction_Branch instruction_branch = null;

	public static class Instruction_NOP extends IInstruction {

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

	public static class Instruction_ACONST_NULL extends IInstruction {

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

	public static class Instruction_ICONST_M1 extends IInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_M1() {
			opcode = Opcodes.OPCODE_ICONST_M1;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_M1();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_M1();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_0 extends IInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_0() {
			opcode = Opcodes.OPCODE_ICONST_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_0();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_1 extends IInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_1() {
			opcode = Opcodes.OPCODE_ICONST_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_1();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_2 extends IInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_2() {
			opcode = Opcodes.OPCODE_ICONST_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_2();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_2();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_3 extends IInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_3() {
			opcode = Opcodes.OPCODE_ICONST_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_3();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_3();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_4 extends IInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_4() {
			opcode = Opcodes.OPCODE_ICONST_4;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_4();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_4();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_5 extends IInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_5() {
			opcode = Opcodes.OPCODE_ICONST_5;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_5();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_5();
			}
			return instance;
		}

	}

	public static class Instruction_LCONST_0 extends IInstruction {

		private static IInstruction instance;

		private Instruction_LCONST_0() {
			opcode = Opcodes.OPCODE_LCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LCONST_0();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LCONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_LCONST_1 extends IInstruction {

		private static IInstruction instance;

		private Instruction_LCONST_1() {
			opcode = Opcodes.OPCODE_LCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LCONST_1();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LCONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_FCONST_0 extends IInstruction {

		private static IInstruction instance;

		private Instruction_FCONST_0() {
			opcode = Opcodes.OPCODE_FCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCONST_0();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_FCONST_1 extends IInstruction {

		private static IInstruction instance;

		private Instruction_FCONST_1() {
			opcode = Opcodes.OPCODE_FCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCONST_1();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_FCONST_2 extends IInstruction {

		private static IInstruction instance;

		private Instruction_FCONST_2() {
			opcode = Opcodes.OPCODE_FCONST_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCONST_2();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCONST_2();
			}
			return instance;
		}

	}

	public static class Instruction_DCONST_0 extends IInstruction {

		private static IInstruction instance;

		private Instruction_DCONST_0() {
			opcode = Opcodes.OPCODE_DCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DCONST_0();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DCONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_DCONST_1 extends IInstruction {

		private static IInstruction instance;

		private Instruction_DCONST_1() {
			opcode = Opcodes.OPCODE_DCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DCONST_1();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DCONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_BIPUSH extends IInstruction {

		public int b;

		private Instruction_BIPUSH() {
			opcode = Opcodes.OPCODE_BIPUSH;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_BIPUSH instr = new Instruction_BIPUSH(); 
			instr.b = bcs.bytes[ bcs.index++ ];
			return instr;
		}

		public static IInstruction getInstance(int b) {
			Instruction_BIPUSH instr = new Instruction_BIPUSH(); 
			instr.b = b;
			return instr;
		}

	}

	public static class Instruction_SIPUSH extends IInstruction {

		public int s;

		private Instruction_SIPUSH() {
			opcode = Opcodes.OPCODE_SIPUSH;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_SIPUSH instr = new Instruction_SIPUSH(); 
			instr.s = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int s) {
			Instruction_SIPUSH instr = new Instruction_SIPUSH(); 
			instr.s = s;
			return instr;
		}

	}

	public static class Instruction_LDC extends IInstruction {

		public int index;

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

	public static class Instruction_LDC_W extends IInstruction {

		public int index;

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

	public static class Instruction_LDC2_W extends IInstruction {

		public int index;

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

	public static class Instruction_IALOAD extends IInstruction {

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

	}

	public static class Instruction_LALOAD extends IInstruction {

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

	}

	public static class Instruction_FALOAD extends IInstruction {

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

	}

	public static class Instruction_DALOAD extends IInstruction {

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

	}

	public static class Instruction_AALOAD extends IInstruction {

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

	}

	public static class Instruction_BALOAD extends IInstruction {

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

	}

	public static class Instruction_CALOAD extends IInstruction {

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

	}

	public static class Instruction_SALOAD extends IInstruction {

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

	}

	public static class Instruction_IASTORE extends IInstruction {

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

	}

	public static class Instruction_LASTORE extends IInstruction {

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

	}

	public static class Instruction_FASTORE extends IInstruction {

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

	}

	public static class Instruction_DASTORE extends IInstruction {

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

	}

	public static class Instruction_AASTORE extends IInstruction {

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

	}

	public static class Instruction_BASTORE extends IInstruction {

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

	}

	public static class Instruction_CASTORE extends IInstruction {

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

	}

	public static class Instruction_SASTORE extends IInstruction {

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

	}

	public static class Instruction_IADD extends IInstruction {

		private static IInstruction instance;

		private Instruction_IADD() {
			opcode = Opcodes.OPCODE_IADD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IADD();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IADD();
			}
			return instance;
		}

	}

	public static class Instruction_LADD extends IInstruction {

		private static IInstruction instance;

		private Instruction_LADD() {
			opcode = Opcodes.OPCODE_LADD;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LADD();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LADD();
			}
			return instance;
		}

	}

	public static class Instruction_FADD extends IInstruction {

		private static IInstruction instance;

		private Instruction_FADD() {
			opcode = Opcodes.OPCODE_FADD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FADD();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FADD();
			}
			return instance;
		}

	}

	public static class Instruction_DADD extends IInstruction {

		private static IInstruction instance;

		private Instruction_DADD() {
			opcode = Opcodes.OPCODE_DADD;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DADD();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DADD();
			}
			return instance;
		}

	}

	public static class Instruction_ISUB extends IInstruction {

		private static IInstruction instance;

		private Instruction_ISUB() {
			opcode = Opcodes.OPCODE_ISUB;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ISUB();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ISUB();
			}
			return instance;
		}

	}

	public static class Instruction_LSUB extends IInstruction {

		private static IInstruction instance;

		private Instruction_LSUB() {
			opcode = Opcodes.OPCODE_LSUB;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LSUB();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LSUB();
			}
			return instance;
		}

	}

	public static class Instruction_FSUB extends IInstruction {

		private static IInstruction instance;

		private Instruction_FSUB() {
			opcode = Opcodes.OPCODE_FSUB;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FSUB();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FSUB();
			}
			return instance;
		}

	}

	public static class Instruction_DSUB extends IInstruction {

		private static IInstruction instance;

		private Instruction_DSUB() {
			opcode = Opcodes.OPCODE_DSUB;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DSUB();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DSUB();
			}
			return instance;
		}

	}

	public static class Instruction_IMUL extends IInstruction {

		private static IInstruction instance;

		private Instruction_IMUL() {
			opcode = Opcodes.OPCODE_IMUL;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IMUL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IMUL();
			}
			return instance;
		}

	}

	public static class Instruction_LMUL extends IInstruction {

		private static IInstruction instance;

		private Instruction_LMUL() {
			opcode = Opcodes.OPCODE_LMUL;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LMUL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LMUL();
			}
			return instance;
		}

	}

	public static class Instruction_FMUL extends IInstruction {

		private static IInstruction instance;

		private Instruction_FMUL() {
			opcode = Opcodes.OPCODE_FMUL;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FMUL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FMUL();
			}
			return instance;
		}

	}

	public static class Instruction_DMUL extends IInstruction {

		private static IInstruction instance;

		private Instruction_DMUL() {
			opcode = Opcodes.OPCODE_DMUL;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DMUL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DMUL();
			}
			return instance;
		}

	}

	public static class Instruction_IDIV extends IInstruction {

		private static IInstruction instance;

		private Instruction_IDIV() {
			opcode = Opcodes.OPCODE_IDIV;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IDIV();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IDIV();
			}
			return instance;
		}

	}

	public static class Instruction_LDIV extends IInstruction {

		private static IInstruction instance;

		private Instruction_LDIV() {
			opcode = Opcodes.OPCODE_LDIV;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LDIV();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LDIV();
			}
			return instance;
		}

	}

	public static class Instruction_FDIV extends IInstruction {

		private static IInstruction instance;

		private Instruction_FDIV() {
			opcode = Opcodes.OPCODE_FDIV;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FDIV();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FDIV();
			}
			return instance;
		}

	}

	public static class Instruction_DDIV extends IInstruction {

		private static IInstruction instance;

		private Instruction_DDIV() {
			opcode = Opcodes.OPCODE_DDIV;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DDIV();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DDIV();
			}
			return instance;
		}

	}

	public static class Instruction_IREM extends IInstruction {

		private static IInstruction instance;

		private Instruction_IREM() {
			opcode = Opcodes.OPCODE_IREM;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IREM();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IREM();
			}
			return instance;
		}

	}

	public static class Instruction_LREM extends IInstruction {

		private static IInstruction instance;

		private Instruction_LREM() {
			opcode = Opcodes.OPCODE_LREM;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LREM();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LREM();
			}
			return instance;
		}

	}

	public static class Instruction_FREM extends IInstruction {

		private static IInstruction instance;

		private Instruction_FREM() {
			opcode = Opcodes.OPCODE_FREM;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FREM();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FREM();
			}
			return instance;
		}

	}

	public static class Instruction_DREM extends IInstruction {

		private static IInstruction instance;

		private Instruction_DREM() {
			opcode = Opcodes.OPCODE_DREM;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DREM();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DREM();
			}
			return instance;
		}

	}

	public static class Instruction_INEG extends IInstruction {

		private static IInstruction instance;

		private Instruction_INEG() {
			opcode = Opcodes.OPCODE_INEG;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_INEG();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_INEG();
			}
			return instance;
		}

	}

	public static class Instruction_LNEG extends IInstruction {

		private static IInstruction instance;

		private Instruction_LNEG() {
			opcode = Opcodes.OPCODE_LNEG;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LNEG();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LNEG();
			}
			return instance;
		}

	}

	public static class Instruction_FNEG extends IInstruction {

		private static IInstruction instance;

		private Instruction_FNEG() {
			opcode = Opcodes.OPCODE_FNEG;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FNEG();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FNEG();
			}
			return instance;
		}

	}

	public static class Instruction_DNEG extends IInstruction {

		private static IInstruction instance;

		private Instruction_DNEG() {
			opcode = Opcodes.OPCODE_DNEG;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DNEG();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DNEG();
			}
			return instance;
		}

	}

	public static class Instruction_ISHL extends IInstruction {

		private static IInstruction instance;

		private Instruction_ISHL() {
			opcode = Opcodes.OPCODE_ISHL;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ISHL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ISHL();
			}
			return instance;
		}

	}

	public static class Instruction_LSHL extends IInstruction {

		private static IInstruction instance;

		private Instruction_LSHL() {
			opcode = Opcodes.OPCODE_LSHL;
			stack_consume_num = 3;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LSHL();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LSHL();
			}
			return instance;
		}

	}

	public static class Instruction_ISHR extends IInstruction {

		private static IInstruction instance;

		private Instruction_ISHR() {
			opcode = Opcodes.OPCODE_ISHR;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ISHR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ISHR();
			}
			return instance;
		}

	}

	public static class Instruction_LSHR extends IInstruction {

		private static IInstruction instance;

		private Instruction_LSHR() {
			opcode = Opcodes.OPCODE_LSHR;
			stack_consume_num = 3;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LSHR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LSHR();
			}
			return instance;
		}

	}

	public static class Instruction_IUSHR extends IInstruction {

		private static IInstruction instance;

		private Instruction_IUSHR() {
			opcode = Opcodes.OPCODE_IUSHR;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IUSHR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IUSHR();
			}
			return instance;
		}

	}

	public static class Instruction_LUSHR extends IInstruction {

		private static IInstruction instance;

		private Instruction_LUSHR() {
			opcode = Opcodes.OPCODE_LUSHR;
			stack_consume_num = 3;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LUSHR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LUSHR();
			}
			return instance;
		}

	}

	public static class Instruction_IAND extends IInstruction {

		private static IInstruction instance;

		private Instruction_IAND() {
			opcode = Opcodes.OPCODE_IAND;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IAND();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IAND();
			}
			return instance;
		}

	}

	public static class Instruction_LAND extends IInstruction {

		private static IInstruction instance;

		private Instruction_LAND() {
			opcode = Opcodes.OPCODE_LAND;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LAND();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LAND();
			}
			return instance;
		}

	}

	public static class Instruction_IOR extends IInstruction {

		private static IInstruction instance;

		private Instruction_IOR() {
			opcode = Opcodes.OPCODE_IOR;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IOR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IOR();
			}
			return instance;
		}

	}

	public static class Instruction_LOR extends IInstruction {

		private static IInstruction instance;

		private Instruction_LOR() {
			opcode = Opcodes.OPCODE_LOR;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LOR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LOR();
			}
			return instance;
		}

	}

	public static class Instruction_IXOR extends IInstruction {

		private static IInstruction instance;

		private Instruction_IXOR() {
			opcode = Opcodes.OPCODE_IXOR;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IXOR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_IXOR();
			}
			return instance;
		}

	}

	public static class Instruction_LXOR extends IInstruction {

		private static IInstruction instance;

		private Instruction_LXOR() {
			opcode = Opcodes.OPCODE_LXOR;
			stack_consume_num = 4;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LXOR();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LXOR();
			}
			return instance;
		}

	}

	public static class Instruction_IINC extends IInstruction {

		public int index;

		public int constant;

		private Instruction_IINC() {
			opcode = Opcodes.OPCODE_IINC;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_IINC instr = new Instruction_IINC(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			instr.constant = bcs.bytes[ bcs.index++ ];
			return instr;
		}

		public static IInstruction getInstance(int index, int constant) {
			Instruction_IINC instr = new Instruction_IINC(); 
			instr.index = index;
			instr.constant = constant;
			return instr;
		}

	}

	public static class Instruction_LCMP extends IInstruction {
		
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

	public static class Instruction_FCMPL extends IInstruction {
		
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

	public static class Instruction_FCMPG extends IInstruction {
		
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

	public static class Instruction_DCMPL extends IInstruction {
		
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

	public static class Instruction_DCMPG extends IInstruction {
		
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
