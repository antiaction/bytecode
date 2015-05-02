package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class TargetInfo extends BuildingBlockAbstract {

	public static final byte[] targetTypeInfoArr = new byte[ 256 ];

	public static final byte[] targetTypeLocationArr = new byte[ 256 ];

	//  type parameter declaration of generic class or interface
	public static final int TARGET_INFO_0x00 = 0x00;
	// type parameter declaration of generic method or constructor
	public static final int TARGET_INFO_0x01 = 0x01;
	// type in extends clause of class or interface declaration (including the direct superclass of an anonymous class declaration), or in implements clause of interface declaration
	public static final int TARGET_INFO_0x10 = 0x10;
	// type in bound of type parameter declaration of generic class or interface
	public static final int TARGET_INFO_0x11 = 0x11;
	// type in bound of type parameter declaration of generic method or constructor
	public static final int TARGET_INFO_0x12 = 0x12;
	// type in field declaration
	public static final int TARGET_INFO_0x13 = 0x13;
	// return type of method, or type of newly constructed object
	public static final int TARGET_INFO_0x14 = 0x14;
	// receiver type of method or constructor
	public static final int TARGET_INFO_0x15 = 0x15;
	// type in formal parameter declaration of method, constructor, or lambda expression
	public static final int TARGET_INFO_0x16 = 0x16;
	// type in throws clause of method or constructor
	public static final int TARGET_INFO_0x17 = 0x17;
	// type in local variable declaration
	public static final int TARGET_INFO_0x40 = 0x40;
	// type in resource variable declaration
	public static final int TARGET_INFO_0x41 = 0x41;
	// type in exception parameter declaration
	public static final int TARGET_INFO_0x42 = 0x42;
	// type in instanceof expression
	public static final int TARGET_INFO_0x43 = 0x43;
	// type in new expression
	public static final int TARGET_INFO_0x44 = 0x44;
	// type in method reference expression using ::new
	public static final int TARGET_INFO_0x45 = 0x45;
	// type in method reference expression using ::Identifier
	public static final int TARGET_INFO_0x46 = 0x46;
	// type in cast expression
	public static final int TARGET_INFO_0x47 = 0x47;
	// type argument for generic constructor in new expression or explicit constructor invocation statement
	public static final int TARGET_INFO_0x48 = 0x48;
	// type argument for generic method in method invocation expression
	public static final int TARGET_INFO_0x49 = 0x49;
	// type argument for generic constructor in method reference expression using ::new
	public static final int TARGET_INFO_0x4A = 0x4A;
	// type argument for generic method in method reference expression using ::Identifier
	public static final int TARGET_INFO_0x4B = 0x4B;

	public static final int TYPE_PARAMETER_TARGET = 1;
	public static final int SUPERTYPE_TARGET = 2;
	public static final int TYPE_PARAMETER_BOUND_TARGET = 3;
	public static final int EMPTY_TARGET = 4;
	public static final int FORMAL_PARAMETER_TARGET = 5;
	public static final int THROWS_TARGET = 6;
	public static final int LOCALVAR_TARGET = 7;
	public static final int CATCH_TARGET = 8;
	public static final int OFFSET_TARGET = 9;
	public static final int TYPE_ARGUMENT_TARGET = 10;

	static {
		targetTypeInfoArr[ TARGET_INFO_0x00 ] = TYPE_PARAMETER_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x01 ] = TYPE_PARAMETER_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x10 ] = SUPERTYPE_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x11 ] = TYPE_PARAMETER_BOUND_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x12 ] = TYPE_PARAMETER_BOUND_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x13 ] = EMPTY_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x14 ] = EMPTY_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x15 ] = EMPTY_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x16 ] = FORMAL_PARAMETER_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x17 ] = THROWS_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x40 ] = LOCALVAR_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x41 ] = LOCALVAR_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x42 ] = CATCH_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x43 ] = OFFSET_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x44 ] = OFFSET_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x45 ] = OFFSET_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x46 ] = OFFSET_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x47 ] = TYPE_ARGUMENT_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x48 ] = TYPE_ARGUMENT_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x49 ] = TYPE_ARGUMENT_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x4A ] = TYPE_ARGUMENT_TARGET;
		targetTypeInfoArr[ TARGET_INFO_0x4B ] = TYPE_ARGUMENT_TARGET;
	}

	static {
		// type parameter declaration of generic class or interface
		targetTypeLocationArr[ TARGET_INFO_0x00 ] = Constants.ATTR_LOCATION_CLASSFILE;
		// type parameter declaration of generic method or constructor
		targetTypeLocationArr[ TARGET_INFO_0x01 ] = Constants.ATTR_LOCATION_METHOD_INFO;
		// type in extends clause of class or interface declaration, or in implements clause of interface declaration
		targetTypeLocationArr[ TARGET_INFO_0x10 ] = Constants.ATTR_LOCATION_CLASSFILE;
		// type in bound of type parameter declaration of generic class or interface
		targetTypeLocationArr[ TARGET_INFO_0x11 ] = Constants.ATTR_LOCATION_CLASSFILE;
		// type in bound of type parameter declaration of generic method or constructor
		targetTypeLocationArr[ TARGET_INFO_0x12 ] = Constants.ATTR_LOCATION_METHOD_INFO;
		// type in field declaration
		targetTypeLocationArr[ TARGET_INFO_0x13 ] = Constants.ATTR_LOCATION_FIELD_INFO;
		// return type of method or constructor
		targetTypeLocationArr[ TARGET_INFO_0x14 ] = Constants.ATTR_LOCATION_METHOD_INFO;
		// receiver type of method or constructor
		targetTypeLocationArr[ TARGET_INFO_0x15 ] = Constants.ATTR_LOCATION_METHOD_INFO;
		// type in formal parameter declaration of method, constructor, or lambda expression
		targetTypeLocationArr[ TARGET_INFO_0x16 ] = Constants.ATTR_LOCATION_METHOD_INFO;
		// type in throws clause of method or constructor
		targetTypeLocationArr[ TARGET_INFO_0x17 ] = Constants.ATTR_LOCATION_METHOD_INFO;
		// types in local variable declarations, resource variable declarations, exception parameter declarations, expressions
		targetTypeLocationArr[ TARGET_INFO_0x40 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x41 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x42 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x43 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x44 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x45 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x46 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x47 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x48 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x49 ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x4A ] = Constants.ATTR_LOCATION_CODE;
		targetTypeLocationArr[ TARGET_INFO_0x4B ] = Constants.ATTR_LOCATION_CODE;
	}

	public int tag;

	public int type_parameter_index;

	public int supertype_index;

	//public int type_parameter_index;
	public int bound_index;

	public int formal_parameter_index;

	public int throws_type_index;

	public List<Table> localvar_target;

	public int exception_table_index;

	public int offset;

	//public int offset;
	public int type_argument_index;

	public TypePath type_path;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		tag = (cfs.bytes[ cfs.index++ ] & 255);
		int valueItem = targetTypeInfoArr[ tag ];
		switch ( valueItem ) {
		case TYPE_PARAMETER_TARGET:
			type_parameter_index = (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case SUPERTYPE_TARGET:
			supertype_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case TYPE_PARAMETER_BOUND_TARGET:
			type_parameter_index = (cfs.bytes[ cfs.index++ ] & 255);
			bound_index = (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case EMPTY_TARGET:
			break;
		case FORMAL_PARAMETER_TARGET:
			formal_parameter_index = (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case THROWS_TARGET:
			throws_type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case LOCALVAR_TARGET:
			int table_length = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			localvar_target = new ArrayList<Table>();
			Table table;
			for ( int i=0; i<table_length; ++i ) {
				table = new Table();
				table.disassemble( cfs );
				localvar_target.add( table );
			}
			break;
		case CATCH_TARGET:
			exception_table_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case OFFSET_TARGET:
			offset = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case TYPE_ARGUMENT_TARGET:
			offset = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			type_argument_index = (cfs.bytes[ cfs.index++ ] & 255);
			break;
		default:
			throw new ClassFileException( "Invalid TargetInfo tag '" + (char)tag + "'" );
		}
		type_path = new TypePath();
		type_path.disassemble( cfs );
		// TODO Auto-generated method stub
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve some indexes
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(tag & 255) );
		int valueItem = targetTypeInfoArr[ tag ];
		switch ( valueItem ) {
		case TYPE_PARAMETER_TARGET:
			out.write( (byte)(type_parameter_index & 255) );
			break;
		case SUPERTYPE_TARGET:
			out.write( (byte)(supertype_index >> 8) );
			out.write( (byte)(supertype_index & 255) );
			break;
		case TYPE_PARAMETER_BOUND_TARGET:
			out.write( (byte)(type_parameter_index & 255) );
			out.write( (byte)(bound_index & 255) );
			break;
		case EMPTY_TARGET:
			break;
		case FORMAL_PARAMETER_TARGET:
			out.write( (byte)(formal_parameter_index & 255) );
			break;
		case THROWS_TARGET:
			out.write( (byte)(throws_type_index >> 8) );
			out.write( (byte)(throws_type_index & 255) );
			break;
		case LOCALVAR_TARGET:
			int table_length = localvar_target.size();
			out.write( (byte)(table_length >> 8) );
			out.write( (byte)(table_length & 255) );
			Table table;
			for ( int i=0; i<table_length; ++i ) {
				table = localvar_target.get( i );
				table.assemble( out );
			}
			break;
		case CATCH_TARGET:
			out.write( (byte)(exception_table_index >> 8) );
			out.write( (byte)(exception_table_index & 255) );
			break;
		case OFFSET_TARGET:
			out.write( (byte)(offset >> 8) );
			out.write( (byte)(offset & 255) );
			break;
		case TYPE_ARGUMENT_TARGET:
			out.write( (byte)(offset >> 8) );
			out.write( (byte)(offset & 255) );
			out.write( (byte)(type_argument_index & 255) );
			break;
		default:
			throw new IllegalStateException( "Invalid TargetInfo tag '" + (char)tag + "'" );
		}
		// TODO Auto-generated method stub
	}

}
