/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.antiaction.classfile.ClassFile;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.IAttribute;
import com.antiaction.classfile.constantpool.ConstantPool_Utf8;

public class Attributes {

	protected ClassFile cf;

	public List<IAttribute> attributes_list = new ArrayList<IAttribute>();

	protected Map<String, IAttribute> attributes_map = new HashMap<String, IAttribute>();

	protected Attribute_SourceFile sourceFile_attr = null;

	private Attributes() {
	}

	public static Attributes createInstance(ClassFile cf) {
		Attributes attributes = new Attributes();
		attributes.cf = cf;
		return attributes;
	}

	public static Attributes parseAttributes(ClassFileState cfs, int attributes_count) throws ClassFileException {
		int attribute_name_index;
		ConstantPool_Utf8 attribute_name_cp;
		String attribute_name;
		int attribute_length;
		IAttribute attribute = null;

		Attributes attributes = new Attributes();
		attributes.cf = cfs.cf;

		while ( attributes_count > 0 ) {
			cfs.assert_unexpected_eof( 6 );

			attribute_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			attribute_name_cp = cfs.cf.constantpool.getUtf8( attribute_name_index );
			attribute_name = attribute_name_cp.utf8;

			// debug
			//System.out.println( attribute_name );

			attribute_length = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			cfs.assert_unexpected_eof( attribute_length );

			if ( "Code".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_Code.parseCode( cfs );
			}
			else if ( "ConstantValue".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_ConstantValue.parseConstantValue( cfs );
			}
			else if ( "Deprecated".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_Deprecated.parseDeprecated( cfs );
			}
			else if ( "Exceptions".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_Exceptions.parseExceptions( cfs );
			}
			else if ( "InnerClasses".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_InnerClasses.parseInnerClasses( cfs );
			}
			else if ( "LineNumberTable".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_LineNumberTable.parseLineNumberTable( cfs );
			}
			else if ( "LocalVariableTable".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_LocalVariableTable.parseLocalVariableTable( cfs );
			}
			else if ( "Signature".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_Signature.parseSignature( cfs );
			}
			else if ( "SourceFile".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_SourceFile.parseSourceFile( cfs );
			}
			else if ( "Synthetic".compareToIgnoreCase( attribute_name ) == 0 ) {
				attribute = Attribute_Synthetic.parseSynthetic( cfs );
			}
			else {
				attribute = Attribute_Custom.parseCustom( cfs, attribute_length );
			}

			attribute.attribute_name_index = attribute_name_index;
			attribute.attribute_name_cp = attribute_name_cp;
			attribute.attribute_name = attribute_name;

			attributes.attributes_list.add( attribute );
			attributes.attributes_map.put( attribute_name, attribute );

			--attributes_count;
		}

		return attributes;
	}

	public void buildResolve() throws ClassFileException {
		IAttribute attribute;
		for ( int i=0; i<attributes_list.size(); ++i ) {
			attribute = attributes_list.get( i );
			attribute.attribute_name_cp.buildResolve();
			attribute.attribute_name_index = attribute.attribute_name_cp.index;
			attribute.buildResolve();
		}
	}

	public void build(ByteArrayOutputStream bytes) throws IOException {
		int attributes_count = attributes_list.size();

		bytes.write( (byte)(attributes_count >> 8) );
		bytes.write( (byte)(attributes_count & 255) );

		IAttribute attribute;
		byte[] attrBytes;
		for ( int i=0; i<attributes_list.size(); ++i) {
			attribute = attributes_list.get( i );

			// debug
			//System.out.println( attribute.attribute_name + ": " + bytes.size() );

			bytes.write( (byte)(attribute.attribute_name_index >> 8) );
			bytes.write( (byte)(attribute.attribute_name_index & 255) );

			attrBytes = attribute.build();

			bytes.write( (byte)(attrBytes.length >> 24) );
			bytes.write( (byte)(attrBytes.length >> 16) );
			bytes.write( (byte)(attrBytes.length >> 8) );
			bytes.write( (byte)(attrBytes.length & 255) );

			bytes.write( attrBytes );
		}
	}

	public Attribute_SourceFile getSourceFile() {
		return sourceFile_attr;
	}

	public Attribute_SourceFile putSourceFile(String sourcefile) throws ClassFileException {
		Attribute_SourceFile a_sourcefile = Attribute_SourceFile.createSourceFil( cf.constantpool, sourcefile );
		return a_sourcefile;
	}

}
