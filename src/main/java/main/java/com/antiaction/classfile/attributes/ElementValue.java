package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class ElementValue extends BuildingBlockAbstract {

	public static byte[] types = new byte[ 256 ];
	public static byte[] valueItems = new byte[ 256 ];
	public static byte[] constantTypes = new byte[ 256 ];

	public static final int EV_TYPE_BYTE = 1;
	public static final int EV_TYPE_CHAR = 2;
	public static final int EV_TYPE_DOUBLE = 3;
	public static final int EV_TYPE_FLOAT = 4;
	public static final int EV_TYPE_INT = 5;
	public static final int EV_TYPE_LONG = 6;
	public static final int EV_TYPE_SHORT = 7;
	public static final int EV_TYPE_BOOLEAN = 8;
	public static final int EV_TYPE_STRING = 9;
	public static final int EV_TYPE_ENUM = 10;
	public static final int EV_TYPE_CLASS = 11;
	public static final int EV_TYPE_ANNOTATION = 12;
	public static final int EV_TYPE_ARRAY = 13;

	public static final int EV_CONST_VALUE_INDEX = 1;
	public static final int EV_ENUM_CONST_VALUE = 2;
	public static final int EV_CLASS_INFO_INDEX = 3;
	public static final int EV_ANNOTATION_VALUE = 4;
	public static final int EV_ARRAY_VALUE = 5;

	public static final int EV_CONSTTYPE_INTEGER = 1;
	public static final int EV_CONSTTYPE_LONG = 2;
	public static final int EV_CONSTTYPE_FLOAT = 3;
	public static final int EV_CONSTTYPE_DOUBLE = 4;
	public static final int EV_CONSTTYPE_UTF8 = 5;

	static {
		types[ 'B' ] = EV_TYPE_BYTE;
		types[ 'C' ] = EV_TYPE_CHAR;
		types[ 'D' ] = EV_TYPE_DOUBLE;
		types[ 'F' ] = EV_TYPE_FLOAT;
		types[ 'I' ] = EV_TYPE_INT;
		types[ 'J' ] = EV_TYPE_LONG;
		types[ 'S' ] = EV_TYPE_SHORT;
		types[ 'Z' ] = EV_TYPE_BOOLEAN;
		types[ 's' ] = EV_TYPE_STRING;
		types[ 'e' ] = EV_TYPE_ENUM;
		types[ 'c' ] = EV_TYPE_CLASS;
		types[ '@' ] = EV_TYPE_ANNOTATION;
		types[ '[' ] = EV_TYPE_ARRAY;
		valueItems[ 'B' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'C' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'D' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'F' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'I' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'J' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'S' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'Z' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 's' ] = EV_CONST_VALUE_INDEX;
		valueItems[ 'e' ] = EV_ENUM_CONST_VALUE;
		valueItems[ 'c' ] = EV_CLASS_INFO_INDEX;
		valueItems[ '@' ] = EV_ANNOTATION_VALUE;
		valueItems[ '[' ] = EV_ARRAY_VALUE;
		constantTypes[ 'B' ] = EV_CONSTTYPE_INTEGER;
		constantTypes[ 'C' ] = EV_CONSTTYPE_INTEGER;
		constantTypes[ 'D' ] = EV_CONSTTYPE_DOUBLE;
		constantTypes[ 'F' ] = EV_CONSTTYPE_FLOAT;
		constantTypes[ 'I' ] = EV_CONSTTYPE_INTEGER;
		constantTypes[ 'J' ] = EV_CONSTTYPE_LONG;
		constantTypes[ 'S' ] = EV_CONSTTYPE_INTEGER;
		constantTypes[ 'Z' ] = EV_CONSTTYPE_INTEGER;
		constantTypes[ 's' ] = EV_CONSTTYPE_UTF8;
	}

	public int tag;

	public int const_value_index;

	public int type_name_index;
	public int const_name_index;

	public int class_info_index;

	public Annotation annotation_value;

	public List<ElementValue> values;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		tag = (cfs.bytes[ cfs.index++ ] & 255);
		int valueItem = valueItems[ tag ];
		switch ( valueItem ) {
		case EV_CONST_VALUE_INDEX:
			const_value_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case EV_ENUM_CONST_VALUE:
			type_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			const_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case EV_CLASS_INFO_INDEX:
			class_info_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			break;
		case EV_ANNOTATION_VALUE:
			annotation_value = new Annotation();
			annotation_value.disassemble( cfs );
			break;
		case EV_ARRAY_VALUE:
			int num_values = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			values = new ArrayList<ElementValue>();
			ElementValue elementValue;
			for ( int i=0; i<num_values; ++i ) {
				elementValue = new ElementValue();
				elementValue.disassemble( cfs );
				values.add( elementValue );
			}
			break;
		default:
			throw new ClassFileException( "Invalid ElementValue tag '" + (char)tag + "'" );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve resolve resolve!
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(tag & 255) );
		int valueItem = valueItems[ tag ];
		switch ( valueItem ) {
		case EV_CONST_VALUE_INDEX:
			out.write( (byte)(const_value_index >> 8) );
			out.write( (byte)(const_value_index & 255) );
			break;
		case EV_ENUM_CONST_VALUE:
			out.write( (byte)(type_name_index >> 8) );
			out.write( (byte)(type_name_index & 255) );
			out.write( (byte)(const_name_index >> 8) );
			out.write( (byte)(const_name_index & 255) );
			break;
		case EV_CLASS_INFO_INDEX:
			out.write( (byte)(class_info_index >> 8) );
			out.write( (byte)(class_info_index & 255) );
			break;
		case EV_ANNOTATION_VALUE:
			annotation_value.assemble( out );
			break;
		case EV_ARRAY_VALUE:
			int num_values = values.size();
			out.write( (byte)(num_values >> 8) );
			out.write( (byte)(num_values & 255) );
			ElementValue elementValue;
			for ( int i=0; i<num_values; ++i ) {
				elementValue = values.get( i );
				elementValue.assemble( out );
			}
			break;
		default:
			throw new IllegalStateException( "Invalid ElementValue tag '" + (char)tag + "'" );
		}
	}

}
