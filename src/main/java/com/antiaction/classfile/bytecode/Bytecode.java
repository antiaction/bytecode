/*
 * Created on 09/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

import com.antiaction.classfile.attributes.Attribute_Code;
import com.antiaction.classfile.bytecode.instructions.Instruction_Branch;
import com.antiaction.classfile.bytecode.instructions.Instruction_Convert;
import com.antiaction.classfile.bytecode.instructions.Instruction_LocalVariableLoad;
import com.antiaction.classfile.bytecode.instructions.Instruction_LocalVariableStore;
import com.antiaction.classfile.bytecode.instructions.Instruction_MethodReturn;
import com.antiaction.classfile.bytecode.instructions.Instruction_Stack;

public class Bytecode {

	public static Bytecode parseBytecode(Attribute_Code codeAttr) throws BytecodeException {
		BytecodeState bcs = new BytecodeState( codeAttr.code );
		int c;
		IInstruction instruction = null;

		while ( bcs.index < bcs.bytes.length ) {
			bcs.assert_unexpected_eof( 1 );

			c = bcs.bytes[ bcs.index++ ] & 255;
			System.out.println( c );

			switch ( c ) {
			case Opcodes.OPCODE_NOP:
				instruction = IInstruction.Instruction_NOP.parse( bcs );
				break;
			case Opcodes.OPCODE_ACONST_NULL:
				instruction = IInstruction.Instruction_ACONST_NULL.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_M1:
				instruction = IInstruction.Instruction_ICONST_M1.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_0:
				instruction = IInstruction.Instruction_ICONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_1:
				instruction = IInstruction.Instruction_ICONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_2:
				instruction = IInstruction.Instruction_ICONST_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_3:
				instruction = IInstruction.Instruction_ICONST_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_4:
				instruction = IInstruction.Instruction_ICONST_4.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_5:
				instruction = IInstruction.Instruction_ICONST_5.parse( bcs );
				break;
			case Opcodes.OPCODE_LCONST_0:
				instruction = IInstruction.Instruction_LCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LCONST_1:
				instruction = IInstruction.Instruction_LCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_0:
				instruction = IInstruction.Instruction_FCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_1:
				instruction = IInstruction.Instruction_FCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_2:
				instruction = IInstruction.Instruction_FCONST_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DCONST_0:
				instruction = IInstruction.Instruction_DCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DCONST_1:
				instruction = IInstruction.Instruction_DCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_BIPUSH:
				instruction = IInstruction.Instruction_BIPUSH.parse( bcs );
				break;
			case Opcodes.OPCODE_SIPUSH:
				instruction = IInstruction.Instruction_SIPUSH.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC:
				instruction = IInstruction.Instruction_LDC.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC_W:
				instruction = IInstruction.Instruction_LDC_W.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC2_W:
				instruction = IInstruction.Instruction_LDC2_W.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD:
				instruction = Instruction_LocalVariableLoad.Instruction_ILOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD:
				instruction = Instruction_LocalVariableLoad.Instruction_LLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD:
				instruction = Instruction_LocalVariableLoad.Instruction_FLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD:
				instruction = Instruction_LocalVariableLoad.Instruction_DLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD:
				instruction = Instruction_LocalVariableLoad.Instruction_ALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_0:
				instruction = Instruction_LocalVariableLoad.Instruction_ILOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_1:
				instruction = Instruction_LocalVariableLoad.Instruction_ILOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_2:
				instruction = Instruction_LocalVariableLoad.Instruction_ILOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_3:
				instruction = Instruction_LocalVariableLoad.Instruction_ILOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_0:
				instruction = Instruction_LocalVariableLoad.Instruction_LLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_1:
				instruction = Instruction_LocalVariableLoad.Instruction_LLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_2:
				instruction = Instruction_LocalVariableLoad.Instruction_LLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_3:
				instruction = Instruction_LocalVariableLoad.Instruction_LLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_0:
				instruction = Instruction_LocalVariableLoad.Instruction_FLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_1:
				instruction = Instruction_LocalVariableLoad.Instruction_FLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_2:
				instruction = Instruction_LocalVariableLoad.Instruction_FLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_3:
				instruction = Instruction_LocalVariableLoad.Instruction_FLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_0:
				instruction = Instruction_LocalVariableLoad.Instruction_DLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_1:
				instruction = Instruction_LocalVariableLoad.Instruction_DLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_2:
				instruction = Instruction_LocalVariableLoad.Instruction_DLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_3:
				instruction = Instruction_LocalVariableLoad.Instruction_DLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_0:
				instruction = Instruction_LocalVariableLoad.Instruction_ALOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_1:
				instruction = Instruction_LocalVariableLoad.Instruction_ALOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_2:
				instruction = Instruction_LocalVariableLoad.Instruction_ALOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_3:
				instruction = Instruction_LocalVariableLoad.Instruction_ALOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_IALOAD:
				instruction = IInstruction.Instruction_IALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_LALOAD:
				instruction = IInstruction.Instruction_LALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_FALOAD:
				instruction = IInstruction.Instruction_FALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_DALOAD:
				instruction = IInstruction.Instruction_DALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_AALOAD:
				instruction = IInstruction.Instruction_AALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_BALOAD:
				instruction = IInstruction.Instruction_BALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_CALOAD:
				instruction = IInstruction.Instruction_CALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_SALOAD:
				instruction = IInstruction.Instruction_SALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE:
				instruction = Instruction_LocalVariableStore.Instruction_ISTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE:
				instruction = Instruction_LocalVariableStore.Instruction_LSTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE:
				instruction = Instruction_LocalVariableStore.Instruction_FSTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE:
				instruction = Instruction_LocalVariableStore.Instruction_DSTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE:
				instruction = Instruction_LocalVariableStore.Instruction_ASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_0:
				instruction = Instruction_LocalVariableStore.Instruction_ISTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_1:
				instruction = Instruction_LocalVariableStore.Instruction_ISTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_2:
				instruction = Instruction_LocalVariableStore.Instruction_ISTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_3:
				instruction = Instruction_LocalVariableStore.Instruction_ISTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_0:
				instruction = Instruction_LocalVariableStore.Instruction_LSTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_1:
				instruction = Instruction_LocalVariableStore.Instruction_LSTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_2:
				instruction = Instruction_LocalVariableStore.Instruction_LSTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_3:
				instruction = Instruction_LocalVariableStore.Instruction_LSTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_0:
				instruction = Instruction_LocalVariableStore.Instruction_FSTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_1:
				instruction = Instruction_LocalVariableStore.Instruction_FSTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_2:
				instruction = Instruction_LocalVariableStore.Instruction_FSTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_3:
				instruction = Instruction_LocalVariableStore.Instruction_FSTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_0:
				instruction = Instruction_LocalVariableStore.Instruction_DSTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_1:
				instruction = Instruction_LocalVariableStore.Instruction_DSTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_2:
				instruction = Instruction_LocalVariableStore.Instruction_DSTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_3:
				instruction = Instruction_LocalVariableStore.Instruction_DSTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_0:
				instruction = Instruction_LocalVariableStore.Instruction_ASTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_1:
				instruction = Instruction_LocalVariableStore.Instruction_ASTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_2:
				instruction = Instruction_LocalVariableStore.Instruction_ASTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_3:
				instruction = Instruction_LocalVariableStore.Instruction_ASTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_IASTORE:
				instruction = IInstruction.Instruction_IASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_LASTORE:
				instruction = IInstruction.Instruction_LASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_FASTORE:
				instruction = IInstruction.Instruction_FASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_DASTORE:
				instruction = IInstruction.Instruction_DASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_AASTORE:
				instruction = IInstruction.Instruction_AASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_BASTORE:
				instruction = IInstruction.Instruction_BASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_CASTORE:
				instruction = IInstruction.Instruction_CASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_SASTORE:
				instruction = IInstruction.Instruction_SASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_POP:
				instruction = Instruction_Stack.Instruction_POP.parse( bcs );
				break;
			case Opcodes.OPCODE_POP2:
				instruction = Instruction_Stack.Instruction_POP2.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP:
				instruction = Instruction_Stack.Instruction_DUP.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP_X1:
				instruction = Instruction_Stack.Instruction_DUP_X1.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP_X2:
				instruction = Instruction_Stack.Instruction_DUP_X2.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP2:
				instruction = Instruction_Stack.Instruction_DUP2.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP2_X1:
				instruction = Instruction_Stack.Instruction_DUP2_X1.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP2_X2:
				instruction = Instruction_Stack.Instruction_DUP2_X2.parse( bcs );
				break;
			case Opcodes.OPCODE_SWAP:
				instruction = Instruction_Stack.Instruction_SWAP.parse( bcs );
				break;
			case Opcodes.OPCODE_IADD:
				instruction = IInstruction.Instruction_IADD.parse( bcs );
				break;
			case Opcodes.OPCODE_LADD:
				instruction = IInstruction.Instruction_LADD.parse( bcs );
				break;
			case Opcodes.OPCODE_FADD:
				instruction = IInstruction.Instruction_FADD.parse( bcs );
				break;
			case Opcodes.OPCODE_DADD:
				instruction = IInstruction.Instruction_DADD.parse( bcs );
				break;
			case Opcodes.OPCODE_ISUB:
				instruction = IInstruction.Instruction_ISUB.parse( bcs );
				break;
			case Opcodes.OPCODE_LSUB:
				instruction = IInstruction.Instruction_LSUB.parse( bcs );
				break;
			case Opcodes.OPCODE_FSUB:
				instruction = IInstruction.Instruction_FSUB.parse( bcs );
				break;
			case Opcodes.OPCODE_DSUB:
				instruction = IInstruction.Instruction_DSUB.parse( bcs );
				break;
			case Opcodes.OPCODE_IMUL:
				instruction = IInstruction.Instruction_IMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_LMUL:
				instruction = IInstruction.Instruction_LMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_FMUL:
				instruction = IInstruction.Instruction_FMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_DMUL:
				instruction = IInstruction.Instruction_DMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_IDIV:
				instruction = IInstruction.Instruction_IDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_LDIV:
				instruction = IInstruction.Instruction_LDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_FDIV:
				instruction = IInstruction.Instruction_FDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_DDIV:
				instruction = IInstruction.Instruction_DDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_IREM:
				instruction = IInstruction.Instruction_IREM.parse( bcs );
				break;
			case Opcodes.OPCODE_LREM:
				instruction = IInstruction.Instruction_LREM.parse( bcs );
				break;
			case Opcodes.OPCODE_FREM:
				instruction = IInstruction.Instruction_FREM.parse( bcs );
				break;
			case Opcodes.OPCODE_DREM:
				instruction = IInstruction.Instruction_DREM.parse( bcs );
				break;
			case Opcodes.OPCODE_INEG:
				instruction = IInstruction.Instruction_IREM.parse( bcs );
				break;
			case Opcodes.OPCODE_LNEG:
				instruction = IInstruction.Instruction_LREM.parse( bcs );
				break;
			case Opcodes.OPCODE_FNEG:
				instruction = IInstruction.Instruction_FREM.parse( bcs );
				break;
			case Opcodes.OPCODE_DNEG:
				instruction = IInstruction.Instruction_DREM.parse( bcs );
				break;
			case Opcodes.OPCODE_ISHL:
				instruction = IInstruction.Instruction_ISHL.parse( bcs );
				break;
			case Opcodes.OPCODE_LSHL:
				instruction = IInstruction.Instruction_LSHL.parse( bcs );
				break;
			case Opcodes.OPCODE_ISHR:
				instruction = IInstruction.Instruction_ISHR.parse( bcs );
				break;
			case Opcodes.OPCODE_LSHR:
				instruction = IInstruction.Instruction_LSHR.parse( bcs );
				break;
			case Opcodes.OPCODE_IUSHR:
				instruction = IInstruction.Instruction_IUSHR.parse( bcs );
				break;
			case Opcodes.OPCODE_LUSHR:
				instruction = IInstruction.Instruction_LUSHR.parse( bcs );
				break;
			case Opcodes.OPCODE_IAND:
				instruction = IInstruction.Instruction_IAND.parse( bcs );
				break;
			case Opcodes.OPCODE_LAND:
				instruction = IInstruction.Instruction_LAND.parse( bcs );
				break;
			case Opcodes.OPCODE_IOR:
				instruction = IInstruction.Instruction_IOR.parse( bcs );
				break;
			case Opcodes.OPCODE_LOR:
				instruction = IInstruction.Instruction_LOR.parse( bcs );
				break;
			case Opcodes.OPCODE_IXOR:
				instruction = IInstruction.Instruction_IXOR.parse( bcs );
				break;
			case Opcodes.OPCODE_LXOR:
				instruction = IInstruction.Instruction_LXOR.parse( bcs );
				break;
			case Opcodes.OPCODE_IINC:
				instruction = IInstruction.Instruction_IINC.parse( bcs );
				break;
			case Opcodes.OPCODE_I2L:
				instruction = Instruction_Convert.Instruction_I2L.parse( bcs );
				break;
			case Opcodes.OPCODE_I2F:
				instruction = Instruction_Convert.Instruction_I2F.parse( bcs );
				break;
			case Opcodes.OPCODE_I2D:
				instruction = Instruction_Convert.Instruction_I2D.parse( bcs );
				break;
			case Opcodes.OPCODE_L2I:
				instruction = Instruction_Convert.Instruction_L2I.parse( bcs );
				break;
			case Opcodes.OPCODE_L2F:
				instruction = Instruction_Convert.Instruction_L2F.parse( bcs );
				break;
			case Opcodes.OPCODE_L2D:
				instruction = Instruction_Convert.Instruction_L2D.parse( bcs );
				break;
			case Opcodes.OPCODE_F2I:
				instruction = Instruction_Convert.Instruction_F2I.parse( bcs );
				break;
			case Opcodes.OPCODE_F2L:
				instruction = Instruction_Convert.Instruction_F2L.parse( bcs );
				break;
			case Opcodes.OPCODE_F2D:
				instruction = Instruction_Convert.Instruction_F2D.parse( bcs );
				break;
			case Opcodes.OPCODE_D2I:
				instruction = Instruction_Convert.Instruction_D2I.parse( bcs  );
				break;
			case Opcodes.OPCODE_D2L:
				instruction = Instruction_Convert.Instruction_D2L.parse( bcs );
				break;
			case Opcodes.OPCODE_D2F:
				instruction = Instruction_Convert.Instruction_D2F.parse( bcs );
				break;
			case Opcodes.OPCODE_I2B:
				instruction = Instruction_Convert.Instruction_I2B.parse( bcs );
				break;
			case Opcodes.OPCODE_I2C:
				instruction = Instruction_Convert.Instruction_I2C.parse( bcs );
				break;
			case Opcodes.OPCODE_I2S:
				instruction = Instruction_Convert.Instruction_I2S.parse( bcs );
				break;
			case Opcodes.OPCODE_LCMP:
				instruction = IInstruction.Instruction_LCMP.parse( bcs );
				break;
			case Opcodes.OPCODE_FCMPL:
				instruction = IInstruction.Instruction_FCMPL.parse( bcs );
				break;
			case Opcodes.OPCODE_FCMPG:
				instruction = IInstruction.Instruction_FCMPG.parse( bcs );
				break;
			case Opcodes.OPCODE_DCMPL:
				instruction = IInstruction.Instruction_DCMPL.parse( bcs );
				break;
			case Opcodes.OPCODE_DCMPG:
				instruction = IInstruction.Instruction_DCMPG.parse( bcs );
				break;
			case Opcodes.OPCODE_IFEQ:
				instruction = Instruction_Branch.Instruction_IFEQ.parse( bcs );
				break;
			case Opcodes.OPCODE_IFNE:
				instruction = Instruction_Branch.Instruction_IFNE.parse( bcs );
				break;
			case Opcodes.OPCODE_IFLT:
				instruction = Instruction_Branch.Instruction_IFLT.parse( bcs );
				break;
			case Opcodes.OPCODE_IFGE:
				instruction = Instruction_Branch.Instruction_IFGE.parse( bcs );
				break;
			case Opcodes.OPCODE_IFGT:
				instruction = Instruction_Branch.Instruction_IFGT.parse( bcs );
				break;
			case Opcodes.OPCODE_IFLE:
				instruction = Instruction_Branch.Instruction_IFLE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPEQ:
				instruction = Instruction_Branch.Instruction_IF_ICMPEQ.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPNE:
				instruction = Instruction_Branch.Instruction_IF_ICMPNE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPLT:
				instruction = Instruction_Branch.Instruction_IF_ICMPLT.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPGE:
				instruction = Instruction_Branch.Instruction_IF_ICMPGE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPGT:
				instruction = Instruction_Branch.Instruction_IF_ICMPGT.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPLE:
				instruction = Instruction_Branch.Instruction_IF_ICMPLE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ACMPEQ:
				instruction = Instruction_Branch.Instruction_IF_ACMPEQ.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ACMPNE:
				instruction = Instruction_Branch.Instruction_IF_ACMPNE.parse( bcs );
				break;
			case Opcodes.OPCODE_GOTO:
				instruction = Instruction_Branch.Instruction_GOTO.parse( bcs );
				break;
			case Opcodes.OPCODE_JSR:
			case Opcodes.OPCODE_RET:
			case Opcodes.OPCODE_TABLESWITCH:
			case Opcodes.OPCODE_LOOKUPSWITCH:
			case Opcodes.OPCODE_IRETURN:
				instruction = Instruction_MethodReturn.Instruction_IRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_LRETURN:
				instruction = Instruction_MethodReturn.Instruction_LRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_FRETURN:
				instruction = Instruction_MethodReturn.Instruction_FRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_DRETURN:
				instruction = Instruction_MethodReturn.Instruction_DRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_ARETURN:
				instruction = Instruction_MethodReturn.Instruction_ARETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_RETURN:
				instruction = Instruction_MethodReturn.Instruction_RETURN.parse( bcs );
				break;
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
				instruction = Instruction_Branch.Instruction_IFNULL.parse( bcs );
				break;
			case Opcodes.OPCODE_IFNONNULL:
				instruction = Instruction_Branch.Instruction_IFNONNULL.parse( bcs );
				break;
			case Opcodes.OPCODE_GOTO_W:
				instruction = Instruction_Branch.Instruction_GOTO_W.parse( bcs );
				break;
			case Opcodes.OPCODE_JSR_W:
			default:
				throw new BytecodeException( "Unknown opcode", bcs.index - 1 );
			}
		}

		return null;
	}

}
