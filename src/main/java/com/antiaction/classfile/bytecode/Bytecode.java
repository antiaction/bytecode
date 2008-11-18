/*
 * Created on 09/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

import com.antiaction.classfile.attributes.Attribute_Code;

public class Bytecode {

	public static Bytecode parseBytecode(Attribute_Code codeAttr) throws BytecodeException {
		BytecodeState bcs = new BytecodeState( codeAttr.code );
		int c;

		while ( bcs.index < bcs.bytes.length ) {
			bcs.assert_unexpected_eof( 1 );

			c = bcs.bytes[ bcs.index++ ] & 255;
			System.out.println( c );

			switch ( c ) {
			case Opcodes.OPCODE_NOP:
				Instruction.Instruction_NOP.parse( bcs );
				break;
			case Opcodes.OPCODE_ACONST_NULL:
				Instruction.Instruction_ACONST_NULL.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_M1:
				Instruction.Instruction_ICONST_M1.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_0:
				Instruction.Instruction_ICONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_1:
				Instruction.Instruction_ICONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_2:
				Instruction.Instruction_ICONST_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_3:
				Instruction.Instruction_ICONST_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_4:
				Instruction.Instruction_ICONST_4.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_5:
				Instruction.Instruction_ICONST_5.parse( bcs );
				break;
			case Opcodes.OPCODE_LCONST_0:
				Instruction.Instruction_LCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LCONST_1:
				Instruction.Instruction_LCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_0:
				Instruction.Instruction_FCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_1:
				Instruction.Instruction_FCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_2:
				Instruction.Instruction_FCONST_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DCONST_0:
				Instruction.Instruction_DCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DCONST_1:
				Instruction.Instruction_DCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_BIPUSH:
				Instruction.Instruction_BIPUSH.parse( bcs );
				break;
			case Opcodes.OPCODE_SIPUSH:
				Instruction.Instruction_SIPUSH.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC:
				Instruction.Instruction_LDC.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC_W:
				Instruction.Instruction_LDC_W.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC2_W:
				Instruction.Instruction_LDC2_W.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD:
				Instruction.Instruction_ILOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD:
				Instruction.Instruction_LLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD:
				Instruction.Instruction_FLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD:
				Instruction.Instruction_DLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD:
				Instruction.Instruction_ALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_0:
				Instruction.Instruction_ILOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_1:
				Instruction.Instruction_ILOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_2:
				Instruction.Instruction_ILOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_3:
				Instruction.Instruction_ILOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_0:
				Instruction.Instruction_LLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_1:
				Instruction.Instruction_LLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_2:
				Instruction.Instruction_LLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_3:
				Instruction.Instruction_LLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_0:
				Instruction.Instruction_FLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_1:
				Instruction.Instruction_FLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_2:
				Instruction.Instruction_FLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_3:
				Instruction.Instruction_FLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_0:
				Instruction.Instruction_DLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_1:
				Instruction.Instruction_DLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_2:
				Instruction.Instruction_DLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_3:
				Instruction.Instruction_DLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_0:
				Instruction.Instruction_ALOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_1:
				Instruction.Instruction_ALOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_2:
				Instruction.Instruction_ALOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_3:
				Instruction.Instruction_ALOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_IALOAD:
				Instruction.Instruction_IALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_LALOAD:
				Instruction.Instruction_LALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_FALOAD:
				Instruction.Instruction_FALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_DALOAD:
				Instruction.Instruction_DALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_AALOAD:
				Instruction.Instruction_AALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_BALOAD:
				Instruction.Instruction_BALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_CALOAD:
				Instruction.Instruction_CALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_SALOAD:
				Instruction.Instruction_SALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE:
			case Opcodes.OPCODE_LSTORE:
			case Opcodes.OPCODE_FSTORE:
			case Opcodes.OPCODE_DSTORE:
			case Opcodes.OPCODE_ASTORE:
			case Opcodes.OPCODE_ISTORE_0:
			case Opcodes.OPCODE_ISTORE_1:
			case Opcodes.OPCODE_ISTORE_2:
			case Opcodes.OPCODE_ISTORE_3:
			case Opcodes.OPCODE_LSTORE_0:
			case Opcodes.OPCODE_LSTORE_1:
			case Opcodes.OPCODE_LSTORE_2:
			case Opcodes.OPCODE_LSTORE_3:
			case Opcodes.OPCODE_FSTORE_0:
			case Opcodes.OPCODE_FSTORE_1:
			case Opcodes.OPCODE_FSTORE_2:
			case Opcodes.OPCODE_FSTORE_3:
			case Opcodes.OPCODE_DSTORE_0:
			case Opcodes.OPCODE_DSTORE_1:
			case Opcodes.OPCODE_DSTORE_2:
			case Opcodes.OPCODE_DSTORE_3:
			case Opcodes.OPCODE_ASTORE_0:
			case Opcodes.OPCODE_ASTORE_1:
			case Opcodes.OPCODE_ASTORE_2:
			case Opcodes.OPCODE_ASTORE_3:
			case Opcodes.OPCODE_IASTORE:
			case Opcodes.OPCODE_LASTORE:
			case Opcodes.OPCODE_FASTORE:
			case Opcodes.OPCODE_DASTORE:
			case Opcodes.OPCODE_AASTORE:
			case Opcodes.OPCODE_BASTORE:
			case Opcodes.OPCODE_CASTORE:
			case Opcodes.OPCODE_SASTORE:
			case Opcodes.OPCODE_POP:
			case Opcodes.OPCODE_POP2:
			case Opcodes.OPCODE_DUP:
			case Opcodes.OPCODE_DUP_X1:
			case Opcodes.OPCODE_DUP_X2:
			case Opcodes.OPCODE_DUP2:
			case Opcodes.OPCODE_DUP2_X1:
			case Opcodes.OPCODE_DUP2_X2:
			case Opcodes.OPCODE_SWAP:
			case Opcodes.OPCODE_IADD:
			case Opcodes.OPCODE_LADD:
			case Opcodes.OPCODE_FADD:
			case Opcodes.OPCODE_DADD:
			case Opcodes.OPCODE_ISUB:
			case Opcodes.OPCODE_LSUB:
			case Opcodes.OPCODE_FSUB:
			case Opcodes.OPCODE_DSUB:
			case Opcodes.OPCODE_IMUL:
			case Opcodes.OPCODE_LMUL:
			case Opcodes.OPCODE_FMUL:
			case Opcodes.OPCODE_DMUL:
			case Opcodes.OPCODE_IDIV:
			case Opcodes.OPCODE_LDIV:
			case Opcodes.OPCODE_FDIV:
			case Opcodes.OPCODE_DDIV:
			case Opcodes.OPCODE_IREM:
			case Opcodes.OPCODE_LREM:
			case Opcodes.OPCODE_FREM:
			case Opcodes.OPCODE_DREM:
			case Opcodes.OPCODE_INEG:
			case Opcodes.OPCODE_LNEG:
			case Opcodes.OPCODE_FNEG:
			case Opcodes.OPCODE_DNEG:
			case Opcodes.OPCODE_ISHL:
			case Opcodes.OPCODE_LSHL:
			case Opcodes.OPCODE_ISHR:
			case Opcodes.OPCODE_LSHR:
			case Opcodes.OPCODE_IUSHR:
			case Opcodes.OPCODE_LUSHR:
			case Opcodes.OPCODE_IAND:
			case Opcodes.OPCODE_LAND:
			case Opcodes.OPCODE_IOR:
			case Opcodes.OPCODE_LOR:
			case Opcodes.OPCODE_IXOR:
			case Opcodes.OPCODE_LXOR:
			case Opcodes.OPCODE_IINC:
			case Opcodes.OPCODE_I2L:
			case Opcodes.OPCODE_I2F:
			case Opcodes.OPCODE_I2D:
			case Opcodes.OPCODE_L2I:
			case Opcodes.OPCODE_L2F:
			case Opcodes.OPCODE_L2D:
			case Opcodes.OPCODE_F2I:
			case Opcodes.OPCODE_F2L:
			case Opcodes.OPCODE_F2D:
			case Opcodes.OPCODE_D2I:
			case Opcodes.OPCODE_D2L:
			case Opcodes.OPCODE_D2F:
			case Opcodes.OPCODE_I2B:
			case Opcodes.OPCODE_I2C:
			case Opcodes.OPCODE_I2S:
			case Opcodes.OPCODE_LCMP:
			case Opcodes.OPCODE_FCMPL:
			case Opcodes.OPCODE_FCMPG:
			case Opcodes.OPCODE_DCMPL:
			case Opcodes.OPCODE_DCMPG:
			case Opcodes.OPCODE_IFEQ:
			case Opcodes.OPCODE_IFNE:
			case Opcodes.OPCODE_IFLT:
			case Opcodes.OPCODE_IFGE:
			case Opcodes.OPCODE_IFGT:
			case Opcodes.OPCODE_IFLE:
			case Opcodes.OPCODE_IF_ICMPEQ:
			case Opcodes.OPCODE_IF_ICMPNE:
			case Opcodes.OPCODE_IF_ICMPLT:
			case Opcodes.OPCODE_IF_ICMPGE:
			case Opcodes.OPCODE_IF_ICMPGT:
			case Opcodes.OPCODE_IF_ICMPLE:
			case Opcodes.OPCODE_IF_ACMPEQ:
			case Opcodes.OPCODE_IF_ACMPNE:
			case Opcodes.OPCODE_GOTO:
			case Opcodes.OPCODE_JSR:
			case Opcodes.OPCODE_RET:
			case Opcodes.OPCODE_TABLESWITCH:
			case Opcodes.OPCODE_LOOKUPSWITCH:
			case Opcodes.OPCODE_IRETURN:
			case Opcodes.OPCODE_LRETURN:
			case Opcodes.OPCODE_FRETURN:
			case Opcodes.OPCODE_DRETURN:
			case Opcodes.OPCODE_ARETURN:
			case Opcodes.OPCODE_RETURN:
			case Opcodes.OPCODE_GETSTATIC:
			case Opcodes.OPCODE_PUTSTATIC:
			case Opcodes.OPCODE_GETFIELD:
			case Opcodes.OPCODE_PUTFIELD:
			case Opcodes.OPCODE_INVOKEVIRTUAL:
			case Opcodes.OPCODE_INVOKESPECIAL:
			case Opcodes.OPCODE_INVOKESTATIC:
			case Opcodes.OPCODE_INVOKEINTERFACE:
			case Opcodes.OPCODE_NEW:
			case Opcodes.OPCODE_NEWARRAY:
			case Opcodes.OPCODE_ANEWARRAY:
			case Opcodes.OPCODE_ARRAYLENGTH:
			case Opcodes.OPCODE_ATHROW:
			case Opcodes.OPCODE_CHECKCAST:
			case Opcodes.OPCODE_INSTANCEOF:
			case Opcodes.OPCODE_MONITORENTER:
			case Opcodes.OPCODE_MONITOREXIT:
			case Opcodes.OPCODE_WIDE:
			case Opcodes.OPCODE_MULTINEWARRAY:
			case Opcodes.OPCODE_IFNULL:
			case Opcodes.OPCODE_IFNONNULL:
			case Opcodes.OPCODE_GOTO_W:
			case Opcodes.OPCODE_JSR_W:
			default:
				throw new BytecodeException( "Unknown opcode", bcs.index - 1 );
			}
		}

		return null;
	}

}
