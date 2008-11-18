/*
 * Created on 14/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

public abstract class Instruction {

	public int opcode = -1;

	public int length = 1;

	public int stack_consume_num = 0;

	public int stack_produce_num = 0;

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

	public static class Instruction_ACONST_NULL extends Instruction {

		private static Instruction instance;

		private Instruction_ACONST_NULL() {
			opcode = Opcodes.OPCODE_ACONST_NULL;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ACONST_NULL();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ACONST_NULL();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_M1 extends Instruction {

		private static Instruction instance;

		private Instruction_ICONST_M1() {
			opcode = Opcodes.OPCODE_ICONST_M1;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_M1();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_M1();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_0 extends Instruction {

		private static Instruction instance;

		private Instruction_ICONST_0() {
			opcode = Opcodes.OPCODE_ICONST_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_0();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_1 extends Instruction {

		private static Instruction instance;

		private Instruction_ICONST_1() {
			opcode = Opcodes.OPCODE_ICONST_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_1();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_2 extends Instruction {

		private static Instruction instance;

		private Instruction_ICONST_2() {
			opcode = Opcodes.OPCODE_ICONST_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_2();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_2();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_3 extends Instruction {

		private static Instruction instance;

		private Instruction_ICONST_3() {
			opcode = Opcodes.OPCODE_ICONST_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_3();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_3();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_4 extends Instruction {

		private static Instruction instance;

		private Instruction_ICONST_4() {
			opcode = Opcodes.OPCODE_ICONST_4;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_4();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_4();
			}
			return instance;
		}

	}

	public static class Instruction_ICONST_5 extends Instruction {

		private static Instruction instance;

		private Instruction_ICONST_5() {
			opcode = Opcodes.OPCODE_ICONST_5;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ICONST_5();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ICONST_5();
			}
			return instance;
		}

	}

	public static class Instruction_LCONST_0 extends Instruction {

		private static Instruction instance;

		private Instruction_LCONST_0() {
			opcode = Opcodes.OPCODE_LCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LCONST_0();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LCONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_LCONST_1 extends Instruction {

		private static Instruction instance;

		private Instruction_LCONST_1() {
			opcode = Opcodes.OPCODE_LCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LCONST_1();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_LCONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_FCONST_0 extends Instruction {

		private static Instruction instance;

		private Instruction_FCONST_0() {
			opcode = Opcodes.OPCODE_FCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCONST_0();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_FCONST_1 extends Instruction {

		private static Instruction instance;

		private Instruction_FCONST_1() {
			opcode = Opcodes.OPCODE_FCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCONST_1();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_FCONST_2 extends Instruction {

		private static Instruction instance;

		private Instruction_FCONST_2() {
			opcode = Opcodes.OPCODE_FCONST_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FCONST_2();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_FCONST_2();
			}
			return instance;
		}

	}

	public static class Instruction_DCONST_0 extends Instruction {

		private static Instruction instance;

		private Instruction_DCONST_0() {
			opcode = Opcodes.OPCODE_DCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DCONST_0();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DCONST_0();
			}
			return instance;
		}

	}

	public static class Instruction_DCONST_1 extends Instruction {

		private static Instruction instance;

		private Instruction_DCONST_1() {
			opcode = Opcodes.OPCODE_DCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DCONST_1();
			}
			return instance;
		}

		public static Instruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_DCONST_1();
			}
			return instance;
		}

	}

	public static class Instruction_BIPUSH extends Instruction {

		public int b;

		private Instruction_BIPUSH() {
			opcode = Opcodes.OPCODE_BIPUSH;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_BIPUSH instr = new Instruction_BIPUSH(); 
			instr.b = bcs.bytes[ bcs.index++ ];
			return instr;
		}

		public static Instruction getInstance(int b) {
			Instruction_BIPUSH instr = new Instruction_BIPUSH(); 
			instr.b = b;
			return instr;
		}

	}

	public static class Instruction_SIPUSH extends Instruction {

		public int s;

		private Instruction_SIPUSH() {
			opcode = Opcodes.OPCODE_SIPUSH;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_SIPUSH instr = new Instruction_SIPUSH(); 
			instr.s = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static Instruction getInstance(int s) {
			Instruction_SIPUSH instr = new Instruction_SIPUSH(); 
			instr.s = s;
			return instr;
		}

	}

	public static class Instruction_LDC extends Instruction {

		public int index;

		private Instruction_LDC() {
			opcode = Opcodes.OPCODE_LDC;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_LDC instr = new Instruction_LDC(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_LDC instr = new Instruction_LDC(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_LDC_W extends Instruction {

		public int index;

		private Instruction_LDC_W() {
			opcode = Opcodes.OPCODE_LDC_W;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_LDC_W instr = new Instruction_LDC_W(); 
			instr.index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_LDC_W instr = new Instruction_LDC_W(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_LDC2_W extends Instruction {

		public int index;

		private Instruction_LDC2_W() {
			opcode = Opcodes.OPCODE_LDC2_W;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_LDC2_W instr = new Instruction_LDC2_W(); 
			instr.index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_LDC2_W instr = new Instruction_LDC2_W(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_ILOAD extends Instruction {

		public int index;

		private Instruction_ILOAD() {
			opcode = Opcodes.OPCODE_ILOAD;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_ILOAD instr = new Instruction_ILOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_ILOAD instr = new Instruction_ILOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_LLOAD extends Instruction {

		public int index;

		private Instruction_LLOAD() {
			opcode = Opcodes.OPCODE_LLOAD;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_LLOAD instr = new Instruction_LLOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_LLOAD instr = new Instruction_LLOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_FLOAD extends Instruction {

		public int index;

		private Instruction_FLOAD() {
			opcode = Opcodes.OPCODE_FLOAD;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_FLOAD instr = new Instruction_FLOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_FLOAD instr = new Instruction_FLOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_DLOAD extends Instruction {

		public int index;

		private Instruction_DLOAD() {
			opcode = Opcodes.OPCODE_DLOAD;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_DLOAD instr = new Instruction_DLOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_DLOAD instr = new Instruction_DLOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_ALOAD extends Instruction {

		public int index;

		private Instruction_ALOAD() {
			opcode = Opcodes.OPCODE_ALOAD;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_ALOAD instr = new Instruction_ALOAD(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static Instruction getInstance(int index) {
			Instruction_ALOAD instr = new Instruction_ALOAD(); 
			instr.index = index;
			return instr;
		}

	}

	public static class Instruction_ILOAD_0 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_ILOAD_0() {
			opcode = Opcodes.OPCODE_ILOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 0;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_0();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_ILOAD_1 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_ILOAD_1() {
			opcode = Opcodes.OPCODE_ILOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_1();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_ILOAD_2 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_ILOAD_2() {
			opcode = Opcodes.OPCODE_ILOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 2;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_2();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_2();
			}
			return instance;
		}
	
	}

	public static class Instruction_ILOAD_3 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_ILOAD_3() {
			opcode = Opcodes.OPCODE_ILOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 3;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_3();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ILOAD_3();
			}
			return instance;
		}
	
	}

	public static class Instruction_LLOAD_0 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_LLOAD_0() {
			opcode = Opcodes.OPCODE_LLOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 0;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_0();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_LLOAD_1 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_LLOAD_1() {
			opcode = Opcodes.OPCODE_LLOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_1();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_LLOAD_2 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_LLOAD_2() {
			opcode = Opcodes.OPCODE_LLOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 2;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_2();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_2();
			}
			return instance;
		}
	
	}

	public static class Instruction_LLOAD_3 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_LLOAD_3() {
			opcode = Opcodes.OPCODE_LLOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 3;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_3();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LLOAD_3();
			}
			return instance;
		}
	
	}

	public static class Instruction_FLOAD_0 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_FLOAD_0() {
			opcode = Opcodes.OPCODE_FLOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 0;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_0();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_FLOAD_1 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_FLOAD_1() {
			opcode = Opcodes.OPCODE_FLOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_1();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_FLOAD_2 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_FLOAD_2() {
			opcode = Opcodes.OPCODE_FLOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 2;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_2();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_2();
			}
			return instance;
		}
	
	}

	public static class Instruction_FLOAD_3 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_FLOAD_3() {
			opcode = Opcodes.OPCODE_FLOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 3;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_3();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FLOAD_3();
			}
			return instance;
		}
	
	}

	public static class Instruction_DLOAD_0 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_DLOAD_0() {
			opcode = Opcodes.OPCODE_DLOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 0;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_0();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_DLOAD_1 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_DLOAD_1() {
			opcode = Opcodes.OPCODE_DLOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_1();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_DLOAD_2 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_DLOAD_2() {
			opcode = Opcodes.OPCODE_DLOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 2;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_2();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_2();
			}
			return instance;
		}
	
	}

	public static class Instruction_DLOAD_3 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_DLOAD_3() {
			opcode = Opcodes.OPCODE_DLOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 2;
			index = 3;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_3();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DLOAD_3();
			}
			return instance;
		}
	
	}

	public static class Instruction_ALOAD_0 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_ALOAD_0() {
			opcode = Opcodes.OPCODE_ALOAD_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 0;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_0();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_0();
			}
			return instance;
		}

	}

	public static class Instruction_ALOAD_1 extends Instruction {

		private static Instruction instance;

		public int index;

		private Instruction_ALOAD_1() {
			opcode = Opcodes.OPCODE_ALOAD_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_1();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_1();
			}
			return instance;
		}

	}

	public static class Instruction_ALOAD_2 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_ALOAD_2() {
			opcode = Opcodes.OPCODE_ALOAD_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 2;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_2();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_2();
			}
			return instance;
		}
	
	}

	public static class Instruction_ALOAD_3 extends Instruction {
	
		private static Instruction instance;
	
		public int index;
	
		private Instruction_ALOAD_3() {
			opcode = Opcodes.OPCODE_ALOAD_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
			index = 3;
		}
	
		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_3();
			}
			return instance;
		}
	
		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_ALOAD_3();
			}
			return instance;
		}
	
	}

	public static class Instruction_IALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_IALOAD() {
			opcode = Opcodes.OPCODE_IALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_IALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_IALOAD();
			}
			return instance;
		}

	}

	public static class Instruction_LALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_LALOAD() {
			opcode = Opcodes.OPCODE_LALOAD;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_LALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_LALOAD();
			}
			return instance;
		}

	}

	public static class Instruction_FALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_FALOAD() {
			opcode = Opcodes.OPCODE_FALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_FALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_FALOAD();
			}
			return instance;
		}

	}

	public static class Instruction_DALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_DALOAD() {
			opcode = Opcodes.OPCODE_DALOAD;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_DALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_DALOAD();
			}
			return instance;
		}

	}

	public static class Instruction_AALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_AALOAD() {
			opcode = Opcodes.OPCODE_AALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_AALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_AALOAD();
			}
			return instance;
		}

	}

	public static class Instruction_BALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_BALOAD() {
			opcode = Opcodes.OPCODE_BALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_BALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_BALOAD();
			}
			return instance;
		}

	}

	public static class Instruction_CALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_CALOAD() {
			opcode = Opcodes.OPCODE_CALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_CALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_CALOAD();
			}
			return instance;
		}

	}

	public static class Instruction_SALOAD extends Instruction {

		private static Instruction instance;

		private Instruction_SALOAD() {
			opcode = Opcodes.OPCODE_SALOAD;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static Instruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_SALOAD();
			}
			return instance;
		}

		public static Instruction getInstance(int index) {
			if ( instance == null ) {
				instance = new Instruction_SALOAD();
			}
			return instance;
		}

	}

























OPCODE_ISTORE
OPCODE_LSTORE
OPCODE_FSTORE
OPCODE_DSTORE
OPCODE_ASTORE

}
