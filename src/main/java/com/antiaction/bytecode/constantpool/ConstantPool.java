/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.constantpool;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
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

	public static ConstantPool parseConstantPool(ClassFileState cfs, int constant_pool_count) throws ClassFileException {
		List<IConstantPool_Info> constantpool_infolist = new ArrayList<IConstantPool_Info>();
		constantpool_infolist.add( null );

		IConstantPool_Info cp_info = null;

		int constantpool_index = 0;
		int tag;
		while ( --constant_pool_count > 0 ) {
			if ( cfs.index + 1 > cfs.bytes.length ) {
				throw new ClassFileException( "Unexpected eof reading constant pool info tag", cfs.index );
			}
			tag = cfs.bytes[ cfs.index++ ] & 255;

			// debug
			//System.out.println( tag );

			switch ( tag ) {
			case CONSTANT_Utf8:
				cp_info = ConstantPool_Utf8.parseUtf8( cfs );
				break;
			case CONSTANT_Integer:
				cp_info = ConstantPool_Integer.parseInteger( cfs );
				break;
			case CONSTANT_Float:
				cp_info = ConstantPool_Float.parseFloat( cfs );
				break;
			case CONSTANT_Long:
				cp_info = ConstantPool_Long.parseLong( cfs );
				break;
			case CONSTANT_Double:
				cp_info = ConstantPool_Double.parseDouble( cfs );
				break;
			case CONSTANT_Class:
				cp_info = ConstantPool_Class.parseClass( cfs );
				break;
			case CONSTANT_String:
				cp_info = ConstantPool_String.parseString( cfs );
				break;
			case CONSTANT_Fieldref:
				cp_info = ConstantPool_Fieldref.parseFieldref( cfs );
				break;
			case CONSTANT_Methodref:
				cp_info = ConstantPool_Methodref.parseMethodref( cfs );
				break;
			case CONSTANT_InterfaceMethodref:
				cp_info = ConstantPool_InterfaceMethodref.parseInterfaceMethodref( cfs );
				break;
			case CONSTANT_NameAndType:
				cp_info = ConstantPool_NameAndType.parseNameAndType( cfs );
				break;
			default:
				throw new ClassFileException( "Unknown constant pool info tag (" + tag + ")", cfs.index );
			}

			++constantpool_index;

			constantpool_infolist.add( cp_info );
		}

		ConstantPool constantpool = new ConstantPool();
		constantpool.constantpool_infolist = constantpool_infolist;

		return constantpool;
	}

	public String getUtf8(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Utf8) ) {
			throw new ClassFileException( "cp_info utf-8 type expected" );
		}

		return ((ConstantPool_Utf8)cp_info).utf8;
	}

	public int getInteger(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Integer) ) {
			throw new ClassFileException( "cp_info integer type expected" );
		}

		return ((ConstantPool_Integer)cp_info).i;
	}

	public float getFloat(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Float) ) {
			throw new ClassFileException( "cp_info float type expected" );
		}

		return ((ConstantPool_Float)cp_info).f;
	}

	public long getLong(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Long) ) {
			throw new ClassFileException( "cp_info long type expected" );
		}

		return ((ConstantPool_Long)cp_info).l;
	}

	public double getDouble(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Double) ) {
			throw new ClassFileException( "cp_info double type expected" );
		}

		return ((ConstantPool_Double)cp_info).d;
	}

	public String getClassName(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Class) ) {
			throw new ClassFileException( "cp_info class type expected" );
		}

		ConstantPool_Class cp_class = (ConstantPool_Class)cp_info;

		if ( cp_class.name_index <= 0 || cp_class.name_index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info name index out of bounds" );
		}

		cp_info = constantpool_infolist.get( cp_class.name_index );
		if ( !(cp_info instanceof ConstantPool_Utf8) ) {
			throw new ClassFileException( "cp_info utf-8 type expected" );
		}

		return ((ConstantPool_Utf8)cp_info).utf8;
	}

	public IConstantPool_Info getConstantValue(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );

		return null;
	}

}
