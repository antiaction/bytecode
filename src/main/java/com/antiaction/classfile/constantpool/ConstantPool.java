/*
 * Created on 10/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.constantpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IConstantPool_Info;

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

	public static final int CT_CONST = 1;
	public static final int CT_UTF8 = 2;
	public static final int CT_CLASS = 3;
	public static final int CT_REF = 4;
	public static final int CT_NT = 5;

	public static final int[] cp_info2type = new int[ 12 + 1 ];

	static {
		cp_info2type[ CONSTANT_Integer ] = CT_CONST;
		cp_info2type[ CONSTANT_Float ] = CT_CONST;
		cp_info2type[ CONSTANT_Long ] = CT_CONST;
		cp_info2type[ CONSTANT_Double ] = CT_CONST;
   		cp_info2type[ CONSTANT_String ] = CT_CONST;
		cp_info2type[ CONSTANT_Utf8 ] = CT_UTF8;
		cp_info2type[ CONSTANT_Class ] = CT_CLASS;
		cp_info2type[ CONSTANT_Fieldref ] = CT_REF;
		cp_info2type[ CONSTANT_Methodref ] = CT_REF;
		cp_info2type[ CONSTANT_InterfaceMethodref ] = CT_REF;
		cp_info2type[ CONSTANT_NameAndType ] = CT_NT;
	}

	public List<IConstantPool_Info> constantpool_infolist = null;

	protected List<ConstantPool_Utf8> utf8_constants = new ArrayList<ConstantPool_Utf8>();

	protected List<ConstantPool_Integer> integer_constants = new ArrayList<ConstantPool_Integer>();

	protected List<ConstantPool_Float> float_constants = new ArrayList<ConstantPool_Float>();

	protected List<ConstantPool_Long> long_constants = new ArrayList<ConstantPool_Long>();

	protected List<ConstantPool_Double> double_constants = new ArrayList<ConstantPool_Double>();

	protected List<ConstantPool_Class> class_constants = new ArrayList<ConstantPool_Class>();

	protected List<ConstantPool_String> string_constants = new ArrayList<ConstantPool_String>();

	protected List<ConstantPool_Fieldref> fieldref_constants = new ArrayList<ConstantPool_Fieldref>();

	protected List<ConstantPool_Methodref> methodref_constants = new ArrayList<ConstantPool_Methodref>();

	protected List<ConstantPool_InterfaceMethodref> interfacemethodref_constants = new ArrayList<ConstantPool_InterfaceMethodref>();

	protected List<ConstantPool_NameAndType> nameandtype_constants = new ArrayList<ConstantPool_NameAndType>();

	public static ConstantPool createInstance() {
		ConstantPool constantpool = new ConstantPool();
		constantpool.constantpool_infolist = new ArrayList<IConstantPool_Info>();
		constantpool.constantpool_infolist.add( null );
		return constantpool;
	}

	public static ConstantPool parseConstantPool(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int constant_pool_count = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		// debug
		//System.out.println( "constant pool count: " + constant_pool_count );

		ConstantPool constantpool = new ConstantPool();
		constantpool.constantpool_infolist = new ArrayList<IConstantPool_Info>();
		constantpool.constantpool_infolist.add( null );

		IConstantPool_Info cp_info = null;

		int constantpool_index = 1;

		int tag;
		while ( constantpool_index < constant_pool_count ) {
			cfs.assert_unexpected_eof( 1 );

			tag = cfs.bytes[ cfs.index++ ] & 255;

			// debug
			//System.out.println( "index: " + constantpool_index + " - tag: " + tag );

			switch ( tag ) {
			case CONSTANT_Utf8:
				cp_info = ConstantPool_Utf8.parseUtf8( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.utf8_constants.add( (ConstantPool_Utf8)cp_info );
				break;
			case CONSTANT_Integer:
				cp_info = ConstantPool_Integer.parseInteger( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.integer_constants.add( (ConstantPool_Integer)cp_info );
				break;
			case CONSTANT_Float:
				cp_info = ConstantPool_Float.parseFloat( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.float_constants.add( (ConstantPool_Float)cp_info );
				break;
			case CONSTANT_Long:
				cp_info = ConstantPool_Long.parseLong( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index;
				constantpool_index += 2;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.constantpool_infolist.add( null );
				constantpool.long_constants.add( (ConstantPool_Long)cp_info );
				break;
			case CONSTANT_Double:
				cp_info = ConstantPool_Double.parseDouble( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index;
				constantpool_index += 2;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.constantpool_infolist.add( null );
				constantpool.double_constants.add( (ConstantPool_Double)cp_info );
				break;
			case CONSTANT_Class:
				cp_info = ConstantPool_Class.parseClass( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.class_constants.add( (ConstantPool_Class)cp_info );
				break;
			case CONSTANT_String:
				cp_info = ConstantPool_String.parseString( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.string_constants.add( (ConstantPool_String)cp_info );
				break;
			case CONSTANT_Fieldref:
				cp_info = ConstantPool_Fieldref.parseFieldref( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.fieldref_constants.add( (ConstantPool_Fieldref)cp_info );
				break;
			case CONSTANT_Methodref:
				cp_info = ConstantPool_Methodref.parseMethodref( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.methodref_constants.add( (ConstantPool_Methodref)cp_info );
				break;
			case CONSTANT_InterfaceMethodref:
				cp_info = ConstantPool_InterfaceMethodref.parseInterfaceMethodref( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.interfacemethodref_constants.add( (ConstantPool_InterfaceMethodref)cp_info );
				break;
			case CONSTANT_NameAndType:
				cp_info = ConstantPool_NameAndType.parseNameAndType( cfs );
				cp_info.cp = constantpool;
				cp_info.index = constantpool_index++;
				constantpool.constantpool_infolist.add( cp_info );
				constantpool.nameandtype_constants.add( (ConstantPool_NameAndType)cp_info );
				break;
			default:
				throw new ClassFileException( "Unknown constant pool info tag (" + tag + ")", cfs.index );
			}
		}

		for ( int i=1; i<constantpool.constantpool_infolist.size(); ++i ) {
			cp_info = constantpool.constantpool_infolist.get( i );
			if ( cp_info != null ) {
				cp_info.parseResolve( cfs );
			}
		}

		return constantpool;
	}

	public void build(ByteArrayOutputStream bytes) throws IOException {
		int constant_pool_count = constantpool_infolist.size();

		bytes.write( (byte)(constant_pool_count >> 8) );
		bytes.write( (byte)(constant_pool_count & 255) );

		IConstantPool_Info cp_info;
		for ( int i=1; i<constantpool_infolist.size(); ++i ) {
			cp_info = constantpool_infolist.get( i );
			if ( cp_info != null ) {
				cp_info.build( bytes );
			}
		}
	}

	public ConstantPool_Utf8 getUtf8(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Utf8) ) {
			throw new ClassFileException( "cp_info utf-8 type expected" );
		}

		return (ConstantPool_Utf8)cp_info;
	}

	public ConstantPool_Utf8 putUtf8(String utf8) throws ClassFileException {
		ConstantPool_Utf8 cp_utf8 = null;
		ConstantPool_Utf8 cp_tmp_utf8;

		int i = 0;
		boolean b = true;
		while ( b ) {
			if ( i < utf8_constants.size() ) {
				cp_tmp_utf8 = utf8_constants.get( i );
				if ( utf8.compareTo( cp_tmp_utf8.utf8 ) == 0 ) {
					cp_utf8 = cp_tmp_utf8;
					b = false;
				}
				else {
					++i;
				}
			}
			else {
				b = false;
			}
		}

		if ( cp_utf8 == null ) {
			cp_utf8 = ConstantPool_Utf8.createUtf8( this, utf8 );
			utf8_constants.add( cp_utf8 );
		}

		return cp_utf8;
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

	public ConstantPool_Class getClass(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_Class) ) {
			throw new ClassFileException( "cp_info class type expected" );
		}

		return (ConstantPool_Class)cp_info;
	}

	public ConstantPool_Class putClass(String class_name) throws ClassFileException {
		ConstantPool_Class cp_class = null;
		ConstantPool_Class cp_tmp_class;

		int i = 0;
		boolean b = true;
		while ( b ) {
			if ( i < class_constants.size() ) {
				cp_tmp_class = class_constants.get( i );
				if ( class_name.compareTo( cp_tmp_class.name ) == 0 ) {
					cp_class = cp_tmp_class;
					b = false;
				}
				else {
					++i;
				}
			}
			else {
				b = false;
			}
		}

		if ( cp_class == null ) {
			cp_class = ConstantPool_Class.createClass( this, class_name );
			class_constants.add( cp_class );
		}

		return cp_class;

	}

	public ConstantPool_NameAndType getNameAndType(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );
		if ( !(cp_info instanceof ConstantPool_NameAndType) ) {
			throw new ClassFileException( "cp_info name_and_type type expected" );
		}

		return (ConstantPool_NameAndType)cp_info;
	}

	public IConstantPool_Info getConstantValue(int index) throws ClassFileException {
		if ( index <= 0 || index >= constantpool_infolist.size() ) {
			throw new ClassFileException( "cp_info index out of bounds" );
		}

		IConstantPool_Info cp_info = constantpool_infolist.get( index );

		if ( cp_info2type[ cp_info.tag ] != CT_CONST ) {
			System.out.println( cp_info.tag );
			throw new ClassFileException( "cp_info not a constant value" );
		}

		return null;
	}

}
