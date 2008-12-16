/*
 * Created on 25/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode.instructions;

import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.bytecode.BytecodeState;
import com.antiaction.classfile.bytecode.IInstruction;
import com.antiaction.classfile.bytecode.Opcodes;

public abstract class ConvertInstruction extends IInstruction {

	public static class Instruction_I2L extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_I2L() {
			opcode = Opcodes.OPCODE_I2L;
			stack_consume_num = 1;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_I2L();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_I2L();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "i2l" };
		}

	}

	public static class Instruction_I2F extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_I2F() {
			opcode = Opcodes.OPCODE_I2F;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_I2F();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_I2F();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "i2f" };
		}

	}

	public static class Instruction_I2D extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_I2D() {
			opcode = Opcodes.OPCODE_I2D;
			stack_consume_num = 1;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_I2D();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_I2D();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "i2d" };
		}

	}

	public static class Instruction_L2I extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_L2I() {
			opcode = Opcodes.OPCODE_L2I;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_L2I();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_L2I();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "l2i" };
		}

	}

	public static class Instruction_L2F extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_L2F() {
			opcode = Opcodes.OPCODE_L2F;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_L2F();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_L2F();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "l2f" };
		}

	}

	public static class Instruction_L2D extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_L2D() {
			opcode = Opcodes.OPCODE_L2D;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_L2D();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_L2D();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "l2d" };
		}

	}

	public static class Instruction_F2I extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_F2I() {
			opcode = Opcodes.OPCODE_F2I;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_F2I();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_F2I();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "f2i" };
		}

	}

	public static class Instruction_F2L extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_F2L() {
			opcode = Opcodes.OPCODE_F2L;
			stack_consume_num = 1;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_F2L();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_F2L();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "f2l" };
		}

	}

	public static class Instruction_F2D extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_F2D() {
			opcode = Opcodes.OPCODE_F2D;
			stack_consume_num = 1;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_F2D();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_F2D();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "f2d" };
		}

	}

	public static class Instruction_D2I extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_D2I() {
			opcode = Opcodes.OPCODE_D2I;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_D2I();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_D2I();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "d2i" };
		}

	}

	public static class Instruction_D2L extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_D2L() {
			opcode = Opcodes.OPCODE_D2L;
			stack_consume_num = 2;
			stack_produce_num = 2;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_D2L();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_D2L();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "d2l" };
		}

	}

	public static class Instruction_D2F extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_D2F() {
			opcode = Opcodes.OPCODE_D2F;
			stack_consume_num = 2;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_D2F();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_D2F();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "d2f" };
		}

	}

	public static class Instruction_I2B extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_I2B() {
			opcode = Opcodes.OPCODE_I2B;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_I2B();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_I2B();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "i2b" };
		}

	}

	public static class Instruction_I2C extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_I2C() {
			opcode = Opcodes.OPCODE_I2C;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_I2C();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_I2C();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "i2c" };
		}

	}

	public static class Instruction_I2S extends ConvertInstruction {

		private static IInstruction instance;

		private Instruction_I2S() {
			opcode = Opcodes.OPCODE_I2S;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_I2S();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_I2S();
			}
			return instance;
		}

		public String[] toInstrString() {
			return new String[]{ "i2s" };
		}

	}

}
