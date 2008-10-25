/*
 * Created on 14/10/2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

package com.antiaction.bytecode.attributes;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.bytecode.ClassFileException;
import com.antiaction.bytecode.ClassFileState;
import com.antiaction.bytecode.IAttribute;

public class Attribute_InnerClasses implements IAttribute {

	public List<InnerClassTable> innerClassTableList = new ArrayList<InnerClassTable>();

	public static IAttribute parseInnerClasses(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int number_of_classes = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		List<InnerClassTable> innerClassTableList = new ArrayList<InnerClassTable>();
		InnerClassTable innerClassTable;

		int inner_class_info_index;
		int outer_class_info_index;
		int inner_name_index;
		int inner_class_access_flags;

		// debug
		System.out.println( " Entries: " + number_of_classes );

		for ( int i=0; i<number_of_classes; ++i ) {
			cfs.assert_unexpected_eof( 8 );

			inner_class_info_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			outer_class_info_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			inner_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
			inner_class_access_flags = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

			innerClassTable = new InnerClassTable();
			innerClassTable.inner_class_info_index = inner_class_info_index;
			innerClassTable.outer_class_info_index = outer_class_info_index;
			innerClassTable.inner_name_index = inner_name_index;
			innerClassTable.inner_class_access_flags = inner_class_access_flags;
			innerClassTableList.add( innerClassTable );
		}

		Attribute_InnerClasses attribute = new Attribute_InnerClasses();
		attribute.innerClassTableList = innerClassTableList;

		return attribute;
	}

}
