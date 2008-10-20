/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.constantpool;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;
import com.antiaction.bytecode.IConstantPool_Info;

public class ConstantPool {

	public static final int CONSTANT_Utf8 = 1;
	public static final int CONSTANT_Integer = 3;
	public static final int CONSTANT_Float = 4;
	public static final int CONSTANT_Long = 5;
	public static final int CONSTANT_Double = 6;
	public static final int CONSTANT_Class = 7;
	public static final int CONSTANT_String = 8;
	public static final int CONSTANT_Fieldref = 9;
	public static final int CONSTANT_Methodref = 10;
	public static final int CONSTANT_InterfaceMethodref = 11;
	public static final int CONSTANT_NameAndType = 12;
	//public static final int CONSTANT_ = ;

	public List<IConstantPool_Info> constantpool_infolist = null;

	public static ConstantPool parseConstantPool(ByteCodeState bcs, int constant_pool_count) throws ByteCodeException {
		List<IConstantPool_Info> constantpool_infolist = new ArrayList<IConstantPool_Info>();
		constantpool_infolist.add( null );

		IConstantPool_Info cp_info = null;

		int constantpool_index = 0;
		int tag;
		while ( --constant_pool_count > 0 ) {
			if ( bcs.index + 1 > bcs.bytes.length ) {
				throw new ByteCodeException( "Unexpected eof reading constant pool info tag", bcs.index );
			}
			tag = bcs.bytes[ bcs.index++ ] & 255;

			// debug
			//System.out.println( tag );

			switch ( tag ) {
			case CONSTANT_Utf8:
				cp_info = ConstantPool_Utf8.parseUtf8( bcs );
				break;
			case CONSTANT_Integer:
				cp_info = ConstantPool_Integer.parseInteger( bcs );
				break;
			case CONSTANT_Float:
				cp_info = ConstantPool_Float.parseFloat( bcs );
				break;
			case CONSTANT_Long:
				cp_info = ConstantPool_Long.parseLong( bcs );
				break;
			case CONSTANT_Double:
				cp_info = ConstantPool_Double.parseDouble( bcs );
				break;
			case CONSTANT_Class:
				cp_info = ConstantPool_Class.parseClass( bcs );
				break;
			case CONSTANT_String:
				cp_info = ConstantPool_String.parseString( bcs );
				break;
			case CONSTANT_Fieldref:
				cp_info = ConstantPool_Fieldref.parseFieldref( bcs );
				break;
			case CONSTANT_Methodref:
				cp_info = ConstantPool_Methodref.parseMethodref( bcs );
				break;
			case CONSTANT_InterfaceMethodref:
				cp_info = ConstantPool_InterfaceMethodref.parseInterfaceMethodref( bcs );
				break;
			case CONSTANT_NameAndType:
				cp_info = ConstantPool_NameAndType.parseNameAndType( bcs );
				break;
			default:
				throw new ByteCodeException( "Unknown constant pool info tag (" + tag + ")", bcs.index );
			}

			++constantpool_index;

			constantpool_infolist.add( cp_info );
		}

		ConstantPool constantpool = new ConstantPool();
		constantpool.constantpool_infolist = constantpool_infolist;

		return constantpool;
	}

	public String getUtf8(int index) throws ByteCodeException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ByteCodeException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Utf8) ) {
			throw new ByteCodeException( "cp_info utf-8 type expected" );
		}

		return ((ConstantPool_Utf8)cp_info).utf8;
	}

	public int getInteger(int index) throws ByteCodeException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ByteCodeException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Integer) ) {
			throw new ByteCodeException( "cp_info integer type expected" );
		}

		return ((ConstantPool_Integer)cp_info).i;
	}

	public float getFloat(int index) throws ByteCodeException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ByteCodeException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Float) ) {
			throw new ByteCodeException( "cp_info float type expected" );
		}

		return ((ConstantPool_Float)cp_info).f;
	}

	public long getLong(int index) throws ByteCodeException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ByteCodeException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Long) ) {
			throw new ByteCodeException( "cp_info long type expected" );
		}

		return ((ConstantPool_Long)cp_info).l;
	}

	public double getDouble(int index) throws ByteCodeException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ByteCodeException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Double) ) {
			throw new ByteCodeException( "cp_info double type expected" );
		}

		return ((ConstantPool_Double)cp_info).d;
	}

	public String getClassName(int index) throws ByteCodeException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ByteCodeException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Class) ) {
			throw new ByteCodeException( "cp_info class type expected" );
		}

		ConstantPool_Class cp_class = (ConstantPool_Class)cp_info;

		if ( cp_class.name_index <= 0 || cp_class.name_index >= constantpool_infolist.size() ) {
			throw new ByteCodeException( "cp_info name index out of bounds" );
		}

		cp_info = constantpool_infolist.get( cp_class.name_index );
		if ( !(cp_info instanceof ConstantPool_Utf8) ) {
			throw new ByteCodeException( "cp_info utf-8 type expected" );
		}

		return ((ConstantPool_Utf8)cp_info).utf8;
	}

}
