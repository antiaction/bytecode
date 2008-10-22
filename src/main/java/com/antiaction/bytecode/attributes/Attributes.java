/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import com.antiaction.bytecode.ByteCodeException;
import com.antiaction.bytecode.ByteCodeState;
import com.antiaction.bytecode.IAttribute;

public class Attributes {

	public static IAttribute parseAttribute(ByteCodeState bcs, String attribute_name) throws ByteCodeException {
		IAttribute attribute = null;

		int attribute_length = (bcs.bytes[ bcs.index++ ] & 255) << 24 | (bcs.bytes[ bcs.index++ ] & 255) << 16 | (bcs.bytes[ bcs.index++ ] & 255) << 8 | (bcs.bytes[ bcs.index++ ] & 255);

		bcs.assert_unexpected_eof( attribute_length );

		if ( "Code".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_Code.parseCode( bcs );
		}
		else if ( "ConstantValue".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_ConstantValue.parseConstantValue( bcs );
		}
		else if ( "Deprecated".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_Deprecated.parseDeprecated( bcs );
		}
		else if ( "Exceptions".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_Exceptions.parseExceptions( bcs );
		}
		else if ( "InnerClasses".compareToIgnoreCase( attribute_name ) == 0 ) {
			//Attribute_InnerClasses.parse( bcs );
		}
		else if ( "LineNumberTable".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_LineNumberTable.parseLineNumberTable( bcs );
		}
		else if ( "LocalVariableTable".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_LocalVariableTable.parseLocalVariableTable( bcs );
		}
		else if ( "SourceFile".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_SourceFile.parseSourceFile( bcs );
		}
		else if ( "Synthetic".compareToIgnoreCase( attribute_name ) == 0 ) {
			attribute = Attribute_Synthetic.parseSynthetic( bcs );
		}

		return attribute;
	}

}
