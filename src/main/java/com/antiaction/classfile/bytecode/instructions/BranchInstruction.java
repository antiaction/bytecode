/*
 * Created on 24/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode.instructions;

import com.antiaction.classfile.bytecode.BytecodeException;
import com.antiaction.classfile.bytecode.BytecodeState;
import com.antiaction.classfile.bytecode.IInstruction;
import com.antiaction.classfile.bytecode.Opcodes;

public abstract class BranchInstruction extends IInstruction {

	public int instruction_index;

	public int branch_offset;

	public static class Instruction_IFEQ extends BranchInstruction {

		private Instruction_IFEQ() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFEQ;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFEQ();
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFEQ(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFNE extends BranchInstruction {

		private Instruction_IFNE() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFNE;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFNE(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFNE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFLT extends BranchInstruction {

		private Instruction_IFLT() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFLT;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFLT(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFLT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFGE extends BranchInstruction {

		private Instruction_IFGE() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFGE;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFGE(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFGE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFGT extends BranchInstruction {

		private Instruction_IFGT() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFGT;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFGT(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFGT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFLE extends BranchInstruction {

		private Instruction_IFLE() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFLE;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFLE(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFLE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPEQ extends BranchInstruction {

		private Instruction_IF_ICMPEQ() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ICMPEQ;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ICMPEQ(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ICMPEQ(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPNE extends BranchInstruction {

		private Instruction_IF_ICMPNE() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ICMPNE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ICMPNE(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ICMPNE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPLT extends BranchInstruction {

		private Instruction_IF_ICMPLT() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ICMPLT;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ICMPLT(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ICMPLT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPGE extends BranchInstruction {

		private Instruction_IF_ICMPGE() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ICMPGE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ICMPGE(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ICMPGE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPGT extends BranchInstruction {

		private Instruction_IF_ICMPGT() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ICMPGT;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ICMPGT(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ICMPGT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPLE extends BranchInstruction {

		private Instruction_IF_ICMPLE() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ICMPLE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ICMPLE(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ICMPLE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ACMPEQ extends BranchInstruction {

		private Instruction_IF_ACMPEQ() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ACMPEQ;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ACMPEQ(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ACMPEQ(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ACMPNE extends BranchInstruction {

		private Instruction_IF_ACMPNE() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IF_ACMPNE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IF_ACMPNE(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IF_ACMPNE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_GOTO extends BranchInstruction {

		private Instruction_GOTO() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_GOTO;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_GOTO(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_GOTO(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFNULL extends BranchInstruction {

		private Instruction_IFNULL() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFNULL;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFNULL(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFNULL(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFNONNULL extends BranchInstruction {

		private Instruction_IFNONNULL() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_IFNONNULL;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			BranchInstruction instr = new Instruction_IFNONNULL(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_IFNONNULL(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_GOTO_W extends BranchInstruction {

		private Instruction_GOTO_W() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_GOTO_W;
			length = 5;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static BranchInstruction parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 4 );
			BranchInstruction instr = new Instruction_GOTO_W(); 
			instr.instruction_index = bcs.index - 1;
			instr.branch_offset = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static BranchInstruction getInstance(int branch_offset) {
			BranchInstruction instr = new Instruction_GOTO_W(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

}
 