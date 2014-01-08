/*
 * Created on 27/11/2008
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

public abstract class ArithmeticInstruction extends IInstruction {

	public static class Instruction_IADD extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "iadd" };
		}

	}

	public static class Instruction_LADD extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ladd" };
		}

	}

	public static class Instruction_FADD extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "fadd" };
		}

	}

	public static class Instruction_DADD extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "dadd" };
		}

	}

	public static class Instruction_ISUB extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "isub" };
		}

	}

	public static class Instruction_LSUB extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lsub" };
		}

	}

	public static class Instruction_FSUB extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "fsub" };
		}

	}

	public static class Instruction_DSUB extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "dsub" };
		}

	}

	public static class Instruction_IMUL extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "imul" };
		}

	}

	public static class Instruction_LMUL extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lmul" };
		}

	}

	public static class Instruction_FMUL extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "fmul" };
		}

	}

	public static class Instruction_DMUL extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "dmul" };
		}

	}

	public static class Instruction_IDIV extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "idiv" };
		}

	}

	public static class Instruction_LDIV extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ldiv" };
		}

	}

	public static class Instruction_FDIV extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "fdiv" };
		}

	}

	public static class Instruction_DDIV extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ddiv" };
		}

	}

	public static class Instruction_IREM extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "irem" };
		}

	}

	public static class Instruction_LREM extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lrem" };
		}

	}

	public static class Instruction_FREM extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "frem" };
		}

	}

	public static class Instruction_DREM extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "drem" };
		}

	}

	public static class Instruction_INEG extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ineg" };
		}

	}

	public static class Instruction_LNEG extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lneg" };
		}

	}

	public static class Instruction_FNEG extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "fneg" };
		}

	}

	public static class Instruction_DNEG extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "dneg" };
		}

	}

	public static class Instruction_ISHL extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ishl" };
		}

	}

	public static class Instruction_LSHL extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lshl" };
		}

	}

	public static class Instruction_ISHR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ishr" };
		}

	}

	public static class Instruction_LSHR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lshr" };
		}

	}

	public static class Instruction_IUSHR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "iushr" };
		}

	}

	public static class Instruction_LUSHR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lushr" };
		}

	}

	public static class Instruction_IAND extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "iand" };
		}

	}

	public static class Instruction_LAND extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "land" };
		}

	}

	public static class Instruction_IOR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ior" };
		}

	}

	public static class Instruction_LOR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lor" };
		}

	}

	public static class Instruction_IXOR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ixor" };
		}

	}

	public static class Instruction_LXOR extends ArithmeticInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "lxor" };
		}

	}

	public static class Instruction_IINC extends ArithmeticInstruction {

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

		public static IInstruction parseWide(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_IINC instr = new Instruction_IINC();
			instr.length = 5;
			instr.index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.constant = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index, int constant) {
			Instruction_IINC instr = new Instruction_IINC(); 
			instr.index = index;
			instr.constant = constant;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "iinc", Integer.toString( index ) + ", " + Integer.toString( constant ) };
		}

	}

}
