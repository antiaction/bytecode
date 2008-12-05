/*
 * Created on 27/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode.instructions;

import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.bytecode.BytecodeState;
import com.antiaction.classfile.bytecode.IInstruction;
import com.antiaction.classfile.bytecode.Opcodes;

public abstract class ConstInstruction extends IInstruction {

	public int constant;

	public static class Instruction_ICONST_M1 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_M1() {
			opcode = Opcodes.OPCODE_ICONST_M1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = -1;
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

		public String[] toInstrString() {
			return new String[]{ "iconst_m1" };
		}

	}

	public static class Instruction_ICONST_0 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_0() {
			opcode = Opcodes.OPCODE_ICONST_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 0;
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

		public String[] toInstrString() {
			return new String[]{ "iconst_0" };
		}

	}

	public static class Instruction_ICONST_1 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_1() {
			opcode = Opcodes.OPCODE_ICONST_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 1;
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

		public String[] toInstrString() {
			return new String[]{ "iconst_1" };
		}

	}

	public static class Instruction_ICONST_2 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_2() {
			opcode = Opcodes.OPCODE_ICONST_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 2;
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

		public String[] toInstrString() {
			return new String[]{ "iconst_2" };
		}

	}

	public static class Instruction_ICONST_3 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_3() {
			opcode = Opcodes.OPCODE_ICONST_3;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 3;
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

		public String[] toInstrString() {
			return new String[]{ "iconst_3" };
		}

	}

	public static class Instruction_ICONST_4 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_4() {
			opcode = Opcodes.OPCODE_ICONST_4;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 4;
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

		public String[] toInstrString() {
			return new String[]{ "iconst_4" };
		}

	}

	public static class Instruction_ICONST_5 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_ICONST_5() {
			opcode = Opcodes.OPCODE_ICONST_5;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 5;
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

		public String[] toInstrString() {
			return new String[]{ "iconst_5" };
		}

	}

	public static class Instruction_LCONST_0 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_LCONST_0() {
			opcode = Opcodes.OPCODE_LCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
			constant = 0;
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

		public String[] toInstrString() {
			return new String[]{ "lconst_0" };
		}

	}

	public static class Instruction_LCONST_1 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_LCONST_1() {
			opcode = Opcodes.OPCODE_LCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
			constant = 1;
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

		public String[] toInstrString() {
			return new String[]{ "lconst_1" };
		}

	}

	public static class Instruction_FCONST_0 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_FCONST_0() {
			opcode = Opcodes.OPCODE_FCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 0;
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

		public String[] toInstrString() {
			return new String[]{ "fconst_0" };
		}

	}

	public static class Instruction_FCONST_1 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_FCONST_1() {
			opcode = Opcodes.OPCODE_FCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 1;
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

		public String[] toInstrString() {
			return new String[]{ "fconst_1" };
		}

	}

	public static class Instruction_FCONST_2 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_FCONST_2() {
			opcode = Opcodes.OPCODE_FCONST_2;
			stack_consume_num = 0;
			stack_produce_num = 1;
			constant = 2;
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

		public String[] toInstrString() {
			return new String[]{ "fconst_2" };
		}

	}

	public static class Instruction_DCONST_0 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_DCONST_0() {
			opcode = Opcodes.OPCODE_DCONST_0;
			stack_consume_num = 0;
			stack_produce_num = 2;
			constant = 0;
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

		public String[] toInstrString() {
			return new String[]{ "dconst_0" };
		}

	}

	public static class Instruction_DCONST_1 extends ConstInstruction {

		private static IInstruction instance;

		private Instruction_DCONST_1() {
			opcode = Opcodes.OPCODE_DCONST_1;
			stack_consume_num = 0;
			stack_produce_num = 2;
			constant = 1;
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

		public String[] toInstrString() {
			return new String[]{ "dconst_1" };
		}

	}

	public static class Instruction_BIPUSH extends ConstInstruction {

		private Instruction_BIPUSH() {
			opcode = Opcodes.OPCODE_BIPUSH;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_BIPUSH instr = new Instruction_BIPUSH(); 
			instr.constant = bcs.bytes[ bcs.index++ ];
			return instr;
		}

		public static IInstruction getInstance(int constant) {
			Instruction_BIPUSH instr = new Instruction_BIPUSH(); 
			instr.constant = constant;
			return instr;
		}

		public String[] toInstrString() {
			return new String[]{ "bipush", Integer.toString( constant ) };
		}

	}

	public static class Instruction_SIPUSH extends ConstInstruction {

		private Instruction_SIPUSH() {
			opcode = Opcodes.OPCODE_SIPUSH;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_SIPUSH instr = new Instruction_SIPUSH(); 
			instr.constant = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int constant) {
			Instruction_SIPUSH instr = new Instruction_SIPUSH(); 
			instr.constant = constant;
			return instr;
		}

		public String[] toInstrString() {
			return new String[]{ "sipush", Integer.toString( constant ) };
		}

	}

}
