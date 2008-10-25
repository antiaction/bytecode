/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IAttribute;

public class Attributes {

	public static IAttribute parseAttribute(ClassFileState cfs, String attribute_name) throws ClassFileException {
		IAttribute attribute = null;

		int attribute_length = (cfs.bytes[ cfs.index++ ] & 255) << 24 | (cfs.bytes[ cfs.index++ ] & 255) << 16 | (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

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
		else if ( "SourceFile".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_SourceFile.parseSourceFile( cfs );
		}
		else if ( "Synthetic".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_Synthetic.parseSynthetic( cfs );
		}
		else {
			cfs.index += attribute_length;
		}

		return attribute;
	}

}
