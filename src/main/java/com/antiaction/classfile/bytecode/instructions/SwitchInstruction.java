/*
 * Created on 25/11/2008
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

public abstract class SwitchInstruction extends IInstruction {

	public int instruction_index;

	public static class Instruction_TABLESWITCH extends SwitchInstruction {

		int default_offset = 0;
		int low_endpoint = 0;
		int high_endpoint = 0;
		int[] offsets = null;

		private Instruction_TABLESWITCH() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_TABLESWITCH;
			length = 0;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			Instruction_TABLESWITCH instr = new Instruction_TABLESWITCH(); 
			instr.instruction_index = bcs.index - 1;

			byte pad;
			while ( bcs.index % 4 != 0 ) {
				bcs.assert_unexpected_eof( 1 );
				pad = bcs.bytes[ bcs.index++ ];
				if ( pad != 0 ) {
				}
			}
			bcs.assert_unexpected_eof( 12 );

			instr.default_offset = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.low_endpoint = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.high_endpoint = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			int noffsets = instr.high_endpoint - instr.low_endpoint + 1;
			instr.offsets = new int[ noffsets ];

			for ( int i=0; i<noffsets; ++i ) {
				bcs.assert_unexpected_eof( 4 );
				instr.offsets[ i ] = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			}

			instr.length = bcs.index - instr.instruction_index;

			return instr;
		}

		public static IInstruction getInstance(int s) {
			Instruction_TABLESWITCH instr = new Instruction_TABLESWITCH(); 
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

	public static class Instruction_LOOKUPSWITCH extends SwitchInstruction {

		int default_offset = 0;
		int npairs = 0;
		int[] keys = null;
		int[] offsets = null;

		private Instruction_LOOKUPSWITCH() {
			instruction_index = -1;
			opcode = Opcodes.OPCODE_LOOKUPSWITCH;
			length = 0;
			stack_consume_num = 1;
			stack_produce_num = 0;
		}

		public static IInstruction parse(BytecodeState bcs) throws BytecodeException {
			Instruction_LOOKUPSWITCH instr = new Instruction_LOOKUPSWITCH(); 
			instr.instruction_index = bcs.index - 1;

			byte pad;
			while ( bcs.index % 4 != 0 ) {
				bcs.assert_unexpected_eof( 1 );
				pad = bcs.bytes[ bcs.index++ ];
				if ( pad != 0 ) {
				}
			}
			bcs.assert_unexpected_eof( 8 );

			instr.default_offset = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			instr.npairs = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

			instr.keys = new int[ instr.npairs ];
			instr.offsets = new int[ instr.npairs ];

			for ( int i=0; i<instr.npairs; ++i ) {
				bcs.assert_unexpected_eof( 8 );
				instr.keys[ i ] = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
				instr.offsets[ i ] = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);
			}

			instr.length = bcs.index - instr.instruction_index;

			return instr;
		}

		public static IInstruction getInstance(int s) {
			Instruction_LOOKUPSWITCH instr = new Instruction_LOOKUPSWITCH(); 
			return instr;
		}

		@Override
		public void parseResolve(ClassFileState cfs, Bytecode bc) throws ClassFileException {
		}

	}

}
