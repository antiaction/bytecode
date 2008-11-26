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

public abstract class Instruction_Branch extends IInstruction {

	public int branch_offset;

	public static class Instruction_IFEQ extends Instruction_Branch {

		private Instruction_IFEQ() {
			opcode = Opcodes.OPCODE_IFEQ;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFEQ(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFEQ(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFNE extends Instruction_Branch {

		private Instruction_IFNE() {
			opcode = Opcodes.OPCODE_IFNE;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFNE(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFNE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFLT extends Instruction_Branch {

		private Instruction_IFLT() {
			opcode = Opcodes.OPCODE_IFLT;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFLT(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFLT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFGE extends Instruction_Branch {

		private Instruction_IFGE() {
			opcode = Opcodes.OPCODE_IFGE;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFGE(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFGE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFGT extends Instruction_Branch {

		private Instruction_IFGT() {
			opcode = Opcodes.OPCODE_IFGT;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFGT(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFGT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFLE extends Instruction_Branch {

		private Instruction_IFLE() {
			opcode = Opcodes.OPCODE_IFLE;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFLE(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFLE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPEQ extends Instruction_Branch {

		private Instruction_IF_ICMPEQ() {
			opcode = Opcodes.OPCODE_IF_ICMPEQ;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ICMPEQ(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ICMPEQ(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPNE extends Instruction_Branch {

		private Instruction_IF_ICMPNE() {
			opcode = Opcodes.OPCODE_IF_ICMPNE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ICMPNE(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ICMPNE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPLT extends Instruction_Branch {

		private Instruction_IF_ICMPLT() {
			opcode = Opcodes.OPCODE_IF_ICMPLT;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ICMPLT(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ICMPLT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPGE extends Instruction_Branch {

		private Instruction_IF_ICMPGE() {
			opcode = Opcodes.OPCODE_IF_ICMPGE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ICMPGE(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ICMPGE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPGT extends Instruction_Branch {

		private Instruction_IF_ICMPGT() {
			opcode = Opcodes.OPCODE_IF_ICMPGT;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ICMPGT(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ICMPGT(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ICMPLE extends Instruction_Branch {

		private Instruction_IF_ICMPLE() {
			opcode = Opcodes.OPCODE_IF_ICMPLE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ICMPLE(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ICMPLE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ACMPEQ extends Instruction_Branch {

		private Instruction_IF_ACMPEQ() {
			opcode = Opcodes.OPCODE_IF_ACMPEQ;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ACMPEQ(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ACMPEQ(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IF_ACMPNE extends Instruction_Branch {

		private Instruction_IF_ACMPNE() {
			opcode = Opcodes.OPCODE_IF_ACMPNE;
			length = 3;
			stack_consume_num = 2;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IF_ACMPNE(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IF_ACMPNE(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_GOTO extends Instruction_Branch {

		private Instruction_GOTO() {
			opcode = Opcodes.OPCODE_GOTO;
			length = 3;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_GOTO(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_GOTO(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFNULL extends Instruction_Branch {

		private Instruction_IFNULL() {
			opcode = Opcodes.OPCODE_IFNULL;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFNULL(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFNULL(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_IFNONNULL extends Instruction_Branch {

		private Instruction_IFNONNULL() {
			opcode = Opcodes.OPCODE_IFNONNULL;
			length = 3;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 2 );
			Instruction_Branch instr = new Instruction_IFNONNULL(); 
			instr.branch_offset = bcs.bytes[ bcs.index++ ] << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_IFNONNULL(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

	public static class Instruction_GOTO_W extends Instruction_Branch {

		private Instruction_GOTO_W() {
			opcode = Opcodes.OPCODE_GOTO_W;
			length = 5;
			stack_consume_num = 0;
			stack_produce_num = 0;
		}

		public static Instruction_Branch parse(BytecodeState bcs) throws BytecodeException {
			bcs.assert_unexpected_eof( 4 );
			Instruction_Branch instr = new Instruction_GOTO_W(); 
			instr.branch_offset = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.instruction_branch = instr;
			return instr;
		}

		public static Instruction_Branch getInstance(int branch_offset) {
			Instruction_Branch instr = new Instruction_GOTO_W(); 
			instr.branch_offset = branch_offset;
			instr.instruction_branch = instr;
			return instr;
		}

	}

}
