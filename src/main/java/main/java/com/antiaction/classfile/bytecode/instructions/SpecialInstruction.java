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
import com.antiaction.classfile.bytecode.Label;
import com.antiaction.classfile.bytecode.Opcodes;

public abstract class SpecialInstruction extends IInstruction {

	public static class Instruction_NOP extends SpecialInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "nop" };
		}

	}

	public static class Instruction_ACONST_NULL extends SpecialInstruction {

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

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "aconst_null", "null" };
		}

	}

	public static class Instruction_JSR extends SpecialInstruction {

		public int instruction_index;

		public int branch_offset;

		public Label label;

		private Instruction_JSR() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_JSR;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_JSR instr = new Instruction_JSR(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			//instr.instruction_branch = instr;
			return instr;
		}

		public static IInstruction getInstance(int branch_offset) {
			Instruction_JSR instr = new Instruction_JSR(); 
			instr.branch_offset = branch_offset;
			//instr.instruction_branch = instr;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
			label = bc.jumpTarget( instruction_index + branch_offset );
		}

		public String[] toInstrString() {
			return new String[]{ "jsr", Integer.toString( branch_offset ), Integer.toString( instruction_index + branch_offset ) };
		}

	}

	public static class Instruction_JSR_W extends SpecialInstruction {

		public int instruction_index;

		public int branch_offset;

		public Label label;

		private Instruction_JSR_W() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_JSR_W;
			length = 5;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 4 );
			Instruction_JSR_W instr = new Instruction_JSR_W(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			//instr.instruction_branch = instr;
			return instr;
		}

		public static IInstruction getInstance(int branch_offset) {
			Instruction_JSR_W instr = new Instruction_JSR_W(); 
			instr.branch_offset = branch_offset;
			//instr.instruction_branch = instr;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
			label = bc.jumpTarget( instruction_index + branch_offset );
		}

		public String[] toInstrString() {
			return new String[]{ "jsr_w", Integer.toString( branch_offset ), Integer.toString( instruction_index + branch_offset ) };
		}

	}

	public static class Instruction_RET extends SpecialInstruction {

		public int index;

		private Instruction_RET() {
			opcode = Opcodes.OPCODE_RET;
			length = 2;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_RET instr = new Instruction_RET(); 
			instr.index = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction parseWide(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_RET instr = new Instruction_RET(); 
			instr.length = 3;
			instr.index = (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_RET instr = new Instruction_RET(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

		public String[] toInstrString() {
			return new String[]{ "ret", Integer.toString( index ) };
		}

	}

	public static class Instruction_GETSTATIC extends SpecialInstruction {

		public int index;

		private Instruction_GETSTATIC() {
			opcode = Opcodes.OPCODE_GETSTATIC;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_GETSTATIC instr = new Instruction_GETSTATIC(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_GETSTATIC instr = new Instruction_GETSTATIC(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_PUTSTATIC extends SpecialInstruction {

		public int index;

		private Instruction_PUTSTATIC() {
			opcode = Opcodes.OPCODE_PUTSTATIC;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_PUTSTATIC instr = new Instruction_PUTSTATIC(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_PUTSTATIC instr = new Instruction_PUTSTATIC(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_GETFIELD extends SpecialInstruction {

		public int index;

		private Instruction_GETFIELD() {
			opcode = Opcodes.OPCODE_GETFIELD;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_GETFIELD instr = new Instruction_GETFIELD(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_GETFIELD instr = new Instruction_GETFIELD(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_PUTFIELD extends SpecialInstruction {

		public int index;

		private Instruction_PUTFIELD() {
			opcode = Opcodes.OPCODE_PUTFIELD;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_PUTFIELD instr = new Instruction_PUTFIELD(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_PUTFIELD instr = new Instruction_PUTFIELD(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_INVOKEVIRTUAL extends SpecialInstruction {

		public int index;

		private Instruction_INVOKEVIRTUAL() {
			opcode = Opcodes.OPCODE_INVOKEVIRTUAL;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_INVOKEVIRTUAL instr = new Instruction_INVOKEVIRTUAL(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_INVOKEVIRTUAL instr = new Instruction_INVOKEVIRTUAL(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_INVOKESPECIAL extends SpecialInstruction {

		public int index;

		private Instruction_INVOKESPECIAL() {
			opcode = Opcodes.OPCODE_INVOKESPECIAL;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_INVOKESPECIAL instr = new Instruction_INVOKESPECIAL(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_INVOKESPECIAL instr = new Instruction_INVOKESPECIAL(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_INVOKESTATIC extends SpecialInstruction {

		public int index;

		private Instruction_INVOKESTATIC() {
			opcode = Opcodes.OPCODE_INVOKESTATIC;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_INVOKESTATIC instr = new Instruction_INVOKESTATIC(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_INVOKESTATIC instr = new Instruction_INVOKESTATIC(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_INVOKEINTERFACE extends SpecialInstruction {

		public int index;

		public int nargs;

		private Instruction_INVOKEINTERFACE() {
			opcode = Opcodes.OPCODE_INVOKEINTERFACE;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_INVOKEINTERFACE instr = new Instruction_INVOKEINTERFACE(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.nargs = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_INVOKEINTERFACE instr = new Instruction_INVOKEINTERFACE(); 
			instr.index = index;
			instr.nargs = 0;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_NEW extends SpecialInstruction {

		public int index;

		private Instruction_NEW() {
			opcode = Opcodes.OPCODE_NEW;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_NEW instr = new Instruction_NEW(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_NEW instr = new Instruction_NEW(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_NEWARRAY extends SpecialInstruction {

		public int atype;

		private Instruction_NEWARRAY() {
			opcode = Opcodes.OPCODE_NEWARRAY;
			length = 2;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 1 );
			Instruction_NEWARRAY instr = new Instruction_NEWARRAY(); 
			instr.atype = bcs.bytes[ bcs.index++ ] & 255;
			return instr;
		}

		public static IInstruction getInstance(int atype) {
			Instruction_NEWARRAY instr = new Instruction_NEWARRAY(); 
			instr.atype = atype;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_ANEWARRAY extends SpecialInstruction {

		public int index;

		private Instruction_ANEWARRAY() {
			opcode = Opcodes.OPCODE_ANEWARRAY;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_ANEWARRAY instr = new Instruction_ANEWARRAY(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_ANEWARRAY instr = new Instruction_ANEWARRAY(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_MULTINEWARRAY extends SpecialInstruction {

		public int index;

		private Instruction_MULTINEWARRAY() {
			opcode = Opcodes.OPCODE_MULTINEWARRAY;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_MULTINEWARRAY instr = new Instruction_MULTINEWARRAY(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_MULTINEWARRAY instr = new Instruction_MULTINEWARRAY(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_ARRAYLENGTH extends SpecialInstruction {

		private static IInstruction instance;

		private Instruction_ARRAYLENGTH() {
			opcode = Opcodes.OPCODE_ARRAYLENGTH;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ARRAYLENGTH();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ARRAYLENGTH();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_CHECKCAST extends SpecialInstruction {

		public int index;

		private Instruction_CHECKCAST() {
			opcode = Opcodes.OPCODE_CHECKCAST;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_CHECKCAST instr = new Instruction_CHECKCAST(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_CHECKCAST instr = new Instruction_CHECKCAST(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_INSTANCEOF extends SpecialInstruction {

		public int index;

		private Instruction_INSTANCEOF() {
			opcode = Opcodes.OPCODE_INSTANCEOF;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_INSTANCEOF instr = new Instruction_INSTANCEOF(); 
			instr.index = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			return instr;
		}

		public static IInstruction getInstance(int index) {
			Instruction_INSTANCEOF instr = new Instruction_INSTANCEOF(); 
			instr.index = index;
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_ATHROW extends SpecialInstruction {

		private static IInstruction instance;

		private Instruction_ATHROW() {
			opcode = Opcodes.OPCODE_ATHROW;
			stack_consume_num = 1;
			stack_produce_num = 1;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			if ( instance == null ) {
				instance = new Instruction_ATHROW();
			}
			return instance;
		}

		public static IInstruction getInstance() {
			if ( instance == null ) {
				instance = new Instruction_ATHROW();
			}
			return instance;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

}
