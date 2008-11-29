/*
 * Created on 09/11/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.bytecode;

import com.antiaction.classfile.attributes.Attribute_Code;
import com.antiaction.classfile.bytecode.instructions.ArithmeticInstruction;
import com.antiaction.classfile.bytecode.instructions.ArrayLoadFromInstruction;
import com.antiaction.classfile.bytecode.instructions.ArrayStoreIntoInstruction;
import com.antiaction.classfile.bytecode.instructions.BranchInstruction;
import com.antiaction.classfile.bytecode.instructions.CompareInstruction;
import com.antiaction.classfile.bytecode.instructions.ConstInstruction;
import com.antiaction.classfile.bytecode.instructions.ConstantPoolLoadFromInstruction;
import com.antiaction.classfile.bytecode.instructions.ConvertInstruction;
import com.antiaction.classfile.bytecode.instructions.LocalVariableLoadInstruction;
import com.antiaction.classfile.bytecode.instructions.LocalVariableStoreInstruction;
import com.antiaction.classfile.bytecode.instructions.MethodReturnInstruction;
import com.antiaction.classfile.bytecode.instructions.MonitorInstruction;
import com.antiaction.classfile.bytecode.instructions.SpecialInstruction;
import com.antiaction.classfile.bytecode.instructions.StackInstruction;
import com.antiaction.classfile.bytecode.instructions.SwitchInstruction;

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
				instruction = SpecialInstruction.Instruction_NOP.parse( bcs );
				break;
			case Opcodes.OPCODE_ACONST_NULL:
				instruction = SpecialInstruction.Instruction_ACONST_NULL.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_M1:
				instruction = ConstInstruction.Instruction_ICONST_M1.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_0:
				instruction = ConstInstruction.Instruction_ICONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_1:
				instruction = ConstInstruction.Instruction_ICONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_2:
				instruction = ConstInstruction.Instruction_ICONST_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_3:
				instruction = ConstInstruction.Instruction_ICONST_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_4:
				instruction = ConstInstruction.Instruction_ICONST_4.parse( bcs );
				break;
			case Opcodes.OPCODE_ICONST_5:
				instruction = ConstInstruction.Instruction_ICONST_5.parse( bcs );
				break;
			case Opcodes.OPCODE_LCONST_0:
				instruction = ConstInstruction.Instruction_LCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LCONST_1:
				instruction = ConstInstruction.Instruction_LCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_0:
				instruction = ConstInstruction.Instruction_FCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_1:
				instruction = ConstInstruction.Instruction_FCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FCONST_2:
				instruction = ConstInstruction.Instruction_FCONST_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DCONST_0:
				instruction = ConstInstruction.Instruction_DCONST_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DCONST_1:
				instruction = ConstInstruction.Instruction_DCONST_1.parse( bcs );
				break;
			case Opcodes.OPCODE_BIPUSH:
				instruction = ConstInstruction.Instruction_BIPUSH.parse( bcs );
				break;
			case Opcodes.OPCODE_SIPUSH:
				instruction = ConstInstruction.Instruction_SIPUSH.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC:
				instruction = ConstantPoolLoadFromInstruction.Instruction_LDC.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC_W:
				instruction = ConstantPoolLoadFromInstruction.Instruction_LDC_W.parse( bcs );
				break;
			case Opcodes.OPCODE_LDC2_W:
				instruction = ConstantPoolLoadFromInstruction.Instruction_LDC2_W.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD:
				instruction = LocalVariableLoadInstruction.Instruction_ILOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD:
				instruction = LocalVariableLoadInstruction.Instruction_LLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD:
				instruction = LocalVariableLoadInstruction.Instruction_FLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD:
				instruction = LocalVariableLoadInstruction.Instruction_DLOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD:
				instruction = LocalVariableLoadInstruction.Instruction_ALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_0:
				instruction = LocalVariableLoadInstruction.Instruction_ILOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_1:
				instruction = LocalVariableLoadInstruction.Instruction_ILOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_2:
				instruction = LocalVariableLoadInstruction.Instruction_ILOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ILOAD_3:
				instruction = LocalVariableLoadInstruction.Instruction_ILOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_0:
				instruction = LocalVariableLoadInstruction.Instruction_LLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_1:
				instruction = LocalVariableLoadInstruction.Instruction_LLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_2:
				instruction = LocalVariableLoadInstruction.Instruction_LLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_LLOAD_3:
				instruction = LocalVariableLoadInstruction.Instruction_LLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_0:
				instruction = LocalVariableLoadInstruction.Instruction_FLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_1:
				instruction = LocalVariableLoadInstruction.Instruction_FLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_2:
				instruction = LocalVariableLoadInstruction.Instruction_FLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_FLOAD_3:
				instruction = LocalVariableLoadInstruction.Instruction_FLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_0:
				instruction = LocalVariableLoadInstruction.Instruction_DLOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_1:
				instruction = LocalVariableLoadInstruction.Instruction_DLOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_2:
				instruction = LocalVariableLoadInstruction.Instruction_DLOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DLOAD_3:
				instruction = LocalVariableLoadInstruction.Instruction_DLOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_0:
				instruction = LocalVariableLoadInstruction.Instruction_ALOAD_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_1:
				instruction = LocalVariableLoadInstruction.Instruction_ALOAD_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_2:
				instruction = LocalVariableLoadInstruction.Instruction_ALOAD_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ALOAD_3:
				instruction = LocalVariableLoadInstruction.Instruction_ALOAD_3.parse( bcs );
				break;
			case Opcodes.OPCODE_IALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_IALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_LALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_LALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_FALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_FALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_DALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_DALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_AALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_AALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_BALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_BALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_CALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_CALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_SALOAD:
				instruction = ArrayLoadFromInstruction.Instruction_SALOAD.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE:
				instruction = LocalVariableStoreInstruction.Instruction_ISTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE:
				instruction = LocalVariableStoreInstruction.Instruction_LSTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE:
				instruction = LocalVariableStoreInstruction.Instruction_FSTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE:
				instruction = LocalVariableStoreInstruction.Instruction_DSTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE:
				instruction = LocalVariableStoreInstruction.Instruction_ASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_0:
				instruction = LocalVariableStoreInstruction.Instruction_ISTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_1:
				instruction = LocalVariableStoreInstruction.Instruction_ISTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_2:
				instruction = LocalVariableStoreInstruction.Instruction_ISTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ISTORE_3:
				instruction = LocalVariableStoreInstruction.Instruction_ISTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_0:
				instruction = LocalVariableStoreInstruction.Instruction_LSTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_1:
				instruction = LocalVariableStoreInstruction.Instruction_LSTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_2:
				instruction = LocalVariableStoreInstruction.Instruction_LSTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_LSTORE_3:
				instruction = LocalVariableStoreInstruction.Instruction_LSTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_0:
				instruction = LocalVariableStoreInstruction.Instruction_FSTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_1:
				instruction = LocalVariableStoreInstruction.Instruction_FSTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_2:
				instruction = LocalVariableStoreInstruction.Instruction_FSTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_FSTORE_3:
				instruction = LocalVariableStoreInstruction.Instruction_FSTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_0:
				instruction = LocalVariableStoreInstruction.Instruction_DSTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_1:
				instruction = LocalVariableStoreInstruction.Instruction_DSTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_2:
				instruction = LocalVariableStoreInstruction.Instruction_DSTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_DSTORE_3:
				instruction = LocalVariableStoreInstruction.Instruction_DSTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_0:
				instruction = LocalVariableStoreInstruction.Instruction_ASTORE_0.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_1:
				instruction = LocalVariableStoreInstruction.Instruction_ASTORE_1.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_2:
				instruction = LocalVariableStoreInstruction.Instruction_ASTORE_2.parse( bcs );
				break;
			case Opcodes.OPCODE_ASTORE_3:
				instruction = LocalVariableStoreInstruction.Instruction_ASTORE_3.parse( bcs );
				break;
			case Opcodes.OPCODE_IASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_IASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_LASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_LASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_FASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_FASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_DASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_DASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_AASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_AASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_BASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_BASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_CASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_CASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_SASTORE:
				instruction = ArrayStoreIntoInstruction.Instruction_SASTORE.parse( bcs );
				break;
			case Opcodes.OPCODE_POP:
				instruction = StackInstruction.Instruction_POP.parse( bcs );
				break;
			case Opcodes.OPCODE_POP2:
				instruction = StackInstruction.Instruction_POP2.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP:
				instruction = StackInstruction.Instruction_DUP.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP_X1:
				instruction = StackInstruction.Instruction_DUP_X1.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP_X2:
				instruction = StackInstruction.Instruction_DUP_X2.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP2:
				instruction = StackInstruction.Instruction_DUP2.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP2_X1:
				instruction = StackInstruction.Instruction_DUP2_X1.parse( bcs );
				break;
			case Opcodes.OPCODE_DUP2_X2:
				instruction = StackInstruction.Instruction_DUP2_X2.parse( bcs );
				break;
			case Opcodes.OPCODE_SWAP:
				instruction = StackInstruction.Instruction_SWAP.parse( bcs );
				break;
			case Opcodes.OPCODE_IADD:
				instruction = ArithmeticInstruction.Instruction_IADD.parse( bcs );
				break;
			case Opcodes.OPCODE_LADD:
				instruction = ArithmeticInstruction.Instruction_LADD.parse( bcs );
				break;
			case Opcodes.OPCODE_FADD:
				instruction = ArithmeticInstruction.Instruction_FADD.parse( bcs );
				break;
			case Opcodes.OPCODE_DADD:
				instruction = ArithmeticInstruction.Instruction_DADD.parse( bcs );
				break;
			case Opcodes.OPCODE_ISUB:
				instruction = ArithmeticInstruction.Instruction_ISUB.parse( bcs );
				break;
			case Opcodes.OPCODE_LSUB:
				instruction = ArithmeticInstruction.Instruction_LSUB.parse( bcs );
				break;
			case Opcodes.OPCODE_FSUB:
				instruction = ArithmeticInstruction.Instruction_FSUB.parse( bcs );
				break;
			case Opcodes.OPCODE_DSUB:
				instruction = ArithmeticInstruction.Instruction_DSUB.parse( bcs );
				break;
			case Opcodes.OPCODE_IMUL:
				instruction = ArithmeticInstruction.Instruction_IMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_LMUL:
				instruction = ArithmeticInstruction.Instruction_LMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_FMUL:
				instruction = ArithmeticInstruction.Instruction_FMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_DMUL:
				instruction = ArithmeticInstruction.Instruction_DMUL.parse( bcs );
				break;
			case Opcodes.OPCODE_IDIV:
				instruction = ArithmeticInstruction.Instruction_IDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_LDIV:
				instruction = ArithmeticInstruction.Instruction_LDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_FDIV:
				instruction = ArithmeticInstruction.Instruction_FDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_DDIV:
				instruction = ArithmeticInstruction.Instruction_DDIV.parse( bcs );
				break;
			case Opcodes.OPCODE_IREM:
				instruction = ArithmeticInstruction.Instruction_IREM.parse( bcs );
				break;
			case Opcodes.OPCODE_LREM:
				instruction = ArithmeticInstruction.Instruction_LREM.parse( bcs );
				break;
			case Opcodes.OPCODE_FREM:
				instruction = ArithmeticInstruction.Instruction_FREM.parse( bcs );
				break;
			case Opcodes.OPCODE_DREM:
				instruction = ArithmeticInstruction.Instruction_DREM.parse( bcs );
				break;
			case Opcodes.OPCODE_INEG:
				instruction = ArithmeticInstruction.Instruction_IREM.parse( bcs );
				break;
			case Opcodes.OPCODE_LNEG:
				instruction = ArithmeticInstruction.Instruction_LREM.parse( bcs );
				break;
			case Opcodes.OPCODE_FNEG:
				instruction = ArithmeticInstruction.Instruction_FREM.parse( bcs );
				break;
			case Opcodes.OPCODE_DNEG:
				instruction = ArithmeticInstruction.Instruction_DREM.parse( bcs );
				break;
			case Opcodes.OPCODE_ISHL:
				instruction = ArithmeticInstruction.Instruction_ISHL.parse( bcs );
				break;
			case Opcodes.OPCODE_LSHL:
				instruction = ArithmeticInstruction.Instruction_LSHL.parse( bcs );
				break;
			case Opcodes.OPCODE_ISHR:
				instruction = ArithmeticInstruction.Instruction_ISHR.parse( bcs );
				break;
			case Opcodes.OPCODE_LSHR:
				instruction = ArithmeticInstruction.Instruction_LSHR.parse( bcs );
				break;
			case Opcodes.OPCODE_IUSHR:
				instruction = ArithmeticInstruction.Instruction_IUSHR.parse( bcs );
				break;
			case Opcodes.OPCODE_LUSHR:
				instruction = ArithmeticInstruction.Instruction_LUSHR.parse( bcs );
				break;
			case Opcodes.OPCODE_IAND:
				instruction = ArithmeticInstruction.Instruction_IAND.parse( bcs );
				break;
			case Opcodes.OPCODE_LAND:
				instruction = ArithmeticInstruction.Instruction_LAND.parse( bcs );
				break;
			case Opcodes.OPCODE_IOR:
				instruction = ArithmeticInstruction.Instruction_IOR.parse( bcs );
				break;
			case Opcodes.OPCODE_LOR:
				instruction = ArithmeticInstruction.Instruction_LOR.parse( bcs );
				break;
			case Opcodes.OPCODE_IXOR:
				instruction = ArithmeticInstruction.Instruction_IXOR.parse( bcs );
				break;
			case Opcodes.OPCODE_LXOR:
				instruction = ArithmeticInstruction.Instruction_LXOR.parse( bcs );
				break;
			case Opcodes.OPCODE_IINC:
				instruction = ArithmeticInstruction.Instruction_IINC.parse( bcs );
				break;
			case Opcodes.OPCODE_I2L:
				instruction = ConvertInstruction.Instruction_I2L.parse( bcs );
				break;
			case Opcodes.OPCODE_I2F:
				instruction = ConvertInstruction.Instruction_I2F.parse( bcs );
				break;
			case Opcodes.OPCODE_I2D:
				instruction = ConvertInstruction.Instruction_I2D.parse( bcs );
				break;
			case Opcodes.OPCODE_L2I:
				instruction = ConvertInstruction.Instruction_L2I.parse( bcs );
				break;
			case Opcodes.OPCODE_L2F:
				instruction = ConvertInstruction.Instruction_L2F.parse( bcs );
				break;
			case Opcodes.OPCODE_L2D:
				instruction = ConvertInstruction.Instruction_L2D.parse( bcs );
				break;
			case Opcodes.OPCODE_F2I:
				instruction = ConvertInstruction.Instruction_F2I.parse( bcs );
				break;
			case Opcodes.OPCODE_F2L:
				instruction = ConvertInstruction.Instruction_F2L.parse( bcs );
				break;
			case Opcodes.OPCODE_F2D:
				instruction = ConvertInstruction.Instruction_F2D.parse( bcs );
				break;
			case Opcodes.OPCODE_D2I:
				instruction = ConvertInstruction.Instruction_D2I.parse( bcs  );
				break;
			case Opcodes.OPCODE_D2L:
				instruction = ConvertInstruction.Instruction_D2L.parse( bcs );
				break;
			case Opcodes.OPCODE_D2F:
				instruction = ConvertInstruction.Instruction_D2F.parse( bcs );
				break;
			case Opcodes.OPCODE_I2B:
				instruction = ConvertInstruction.Instruction_I2B.parse( bcs );
				break;
			case Opcodes.OPCODE_I2C:
				instruction = ConvertInstruction.Instruction_I2C.parse( bcs );
				break;
			case Opcodes.OPCODE_I2S:
				instruction = ConvertInstruction.Instruction_I2S.parse( bcs );
				break;
			case Opcodes.OPCODE_LCMP:
				instruction = CompareInstruction.Instruction_LCMP.parse( bcs );
				break;
			case Opcodes.OPCODE_FCMPL:
				instruction = CompareInstruction.Instruction_FCMPL.parse( bcs );
				break;
			case Opcodes.OPCODE_FCMPG:
				instruction = CompareInstruction.Instruction_FCMPG.parse( bcs );
				break;
			case Opcodes.OPCODE_DCMPL:
				instruction = CompareInstruction.Instruction_DCMPL.parse( bcs );
				break;
			case Opcodes.OPCODE_DCMPG:
				instruction = CompareInstruction.Instruction_DCMPG.parse( bcs );
				break;
			case Opcodes.OPCODE_IFEQ:
				instruction = BranchInstruction.Instruction_IFEQ.parse( bcs );
				break;
			case Opcodes.OPCODE_IFNE:
				instruction = BranchInstruction.Instruction_IFNE.parse( bcs );
				break;
			case Opcodes.OPCODE_IFLT:
				instruction = BranchInstruction.Instruction_IFLT.parse( bcs );
				break;
			case Opcodes.OPCODE_IFGE:
				instruction = BranchInstruction.Instruction_IFGE.parse( bcs );
				break;
			case Opcodes.OPCODE_IFGT:
				instruction = BranchInstruction.Instruction_IFGT.parse( bcs );
				break;
			case Opcodes.OPCODE_IFLE:
				instruction = BranchInstruction.Instruction_IFLE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPEQ:
				instruction = BranchInstruction.Instruction_IF_ICMPEQ.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPNE:
				instruction = BranchInstruction.Instruction_IF_ICMPNE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPLT:
				instruction = BranchInstruction.Instruction_IF_ICMPLT.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPGE:
				instruction = BranchInstruction.Instruction_IF_ICMPGE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPGT:
				instruction = BranchInstruction.Instruction_IF_ICMPGT.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ICMPLE:
				instruction = BranchInstruction.Instruction_IF_ICMPLE.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ACMPEQ:
				instruction = BranchInstruction.Instruction_IF_ACMPEQ.parse( bcs );
				break;
			case Opcodes.OPCODE_IF_ACMPNE:
				instruction = BranchInstruction.Instruction_IF_ACMPNE.parse( bcs );
				break;
			case Opcodes.OPCODE_GOTO:
				instruction = BranchInstruction.Instruction_GOTO.parse( bcs );
				break;
			case Opcodes.OPCODE_JSR:
				instruction = SpecialInstruction.Instruction_JSR.parse( bcs );
				break;
			case Opcodes.OPCODE_RET:
				instruction = SpecialInstruction.Instruction_RET.parse( bcs );
				break;
			case Opcodes.OPCODE_TABLESWITCH:
				instruction = SwitchInstruction.Instruction_TABLESWITCH.parse( bcs );
				break;
			case Opcodes.OPCODE_LOOKUPSWITCH:
				instruction = SwitchInstruction.Instruction_LOOKUPSWITCH.parse( bcs );
				break;
			case Opcodes.OPCODE_IRETURN:
				instruction = MethodReturnInstruction.Instruction_IRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_LRETURN:
				instruction = MethodReturnInstruction.Instruction_LRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_FRETURN:
				instruction = MethodReturnInstruction.Instruction_FRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_DRETURN:
				instruction = MethodReturnInstruction.Instruction_DRETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_ARETURN:
				instruction = MethodReturnInstruction.Instruction_ARETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_RETURN:
				instruction = MethodReturnInstruction.Instruction_RETURN.parse( bcs );
				break;
			case Opcodes.OPCODE_GETSTATIC:
				instruction = SpecialInstruction.Instruction_GETSTATIC.parse( bcs );
				break;
			case Opcodes.OPCODE_PUTSTATIC:
				instruction = SpecialInstruction.Instruction_PUTSTATIC.parse( bcs );
				break;
			case Opcodes.OPCODE_GETFIELD:
				instruction = SpecialInstruction.Instruction_GETFIELD.parse( bcs );
				break;
			case Opcodes.OPCODE_PUTFIELD:
				instruction = SpecialInstruction.Instruction_PUTFIELD.parse( bcs );
				break;
			case Opcodes.OPCODE_INVOKEVIRTUAL:
				instruction = SpecialInstruction.Instruction_INVOKEVIRTUAL.parse( bcs );
				break;
			case Opcodes.OPCODE_INVOKESPECIAL:
				instruction = SpecialInstruction.Instruction_INVOKESPECIAL.parse( bcs );
				break;
			case Opcodes.OPCODE_INVOKESTATIC:
				instruction = SpecialInstruction.Instruction_INVOKESTATIC.parse( bcs );
				break;
			case Opcodes.OPCODE_INVOKEINTERFACE:
				instruction = SpecialInstruction.Instruction_INVOKEINTERFACE.parse( bcs );
				break;
			case Opcodes.OPCODE_NEW:
				instruction = SpecialInstruction.Instruction_NEW.parse( bcs );
				break;
			case Opcodes.OPCODE_NEWARRAY:
				instruction = SpecialInstruction.Instruction_NEWARRAY.parse( bcs );
				break;
			case Opcodes.OPCODE_ANEWARRAY:
				instruction = SpecialInstruction.Instruction_ANEWARRAY.parse( bcs );
				break;
			case Opcodes.OPCODE_ARRAYLENGTH:
				instruction = SpecialInstruction.Instruction_ARRAYLENGTH.parse( bcs );
				break;
			case Opcodes.OPCODE_ATHROW:
				instruction = SpecialInstruction.Instruction_ATHROW.parse( bcs );
				break;
			case Opcodes.OPCODE_CHECKCAST:
				instruction = SpecialInstruction.Instruction_CHECKCAST.parse( bcs );
				break;
			case Opcodes.OPCODE_INSTANCEOF:
				instruction = SpecialInstruction.Instruction_INSTANCEOF.parse( bcs );
				break;
			case Opcodes.OPCODE_MONITORENTER:
				instruction = MonitorInstruction.Instruction_MONITORENTER.parse( bcs );
				break;
			case Opcodes.OPCODE_MONITOREXIT:
				instruction = MonitorInstruction.Instruction_MONITOREXIT.parse( bcs );
				break;
			case Opcodes.OPCODE_WIDE:
				throw new BytecodeException( "Unknown opcode", bcs.index - 1 );
			case Opcodes.OPCODE_MULTINEWARRAY:
				instruction = SpecialInstruction.Instruction_MULTINEWARRAY.parse( bcs );
				break;
			case Opcodes.OPCODE_IFNULL:
				instruction = BranchInstruction.Instruction_IFNULL.parse( bcs );
				break;
			case Opcodes.OPCODE_IFNONNULL:
				instruction = BranchInstruction.Instruction_IFNONNULL.parse( bcs );
				break;
			case Opcodes.OPCODE_GOTO_W:
				instruction = BranchInstruction.Instruction_GOTO_W.parse( bcs );
				break;
			case Opcodes.OPCODE_JSR_W:
				instruction = SpecialInstruction.Instruction_JSR_W.parse( bcs );
				break;
			default:
				throw new BytecodeException( "Unknown opcode", bcs.index - 1 );
			}

			System.out.println( instruction );

		}

		return null;
	}

}
