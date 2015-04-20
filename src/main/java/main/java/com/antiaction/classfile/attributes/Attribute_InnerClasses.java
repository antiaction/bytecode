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
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.AttributeAbstrsct;

public class Attribute_InnerClasses extends AttributeAbstrsct {

	public List<InnerClassTable> innerClassTableList = new ArrayList<InnerClassTable>();

	public static AttributeAbstrsct parseInnerClasses(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( 2 );

		int number_of_classes = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);

		List<InnerClassTable> innerClassTableList = new ArrayList<InnerClassTable>();
		InnerClassTable innerClassTable;

		int inner_class_info_index;
		int outer_class_info_index;
		int inner_name_index;
		int inner_class_access_flags;

		// debug
		//System.out.println( " Entries: " + number_of_classes );

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

	@Override
	public void buildResolve() throws ClassFileException {
	}

	@Override
	public byte[] build() throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		int number_of_classes = innerClassTableList.size();

		bytes.write( (byte)(number_of_classes >> 8) );
		bytes.write( (byte)(number_of_classes & 255) );

		InnerClassTable innerClassTable;
		for ( int i=0; i<innerClassTableList.size(); ++i ) {
			innerClassTable = innerClassTableList.get( i );

			bytes.write( (byte)(innerClassTable.inner_class_info_index >> 8) );
			bytes.write( (byte)(innerClassTable.inner_class_info_index & 255) );

			bytes.write( (byte)(innerClassTable.outer_class_info_index >> 8) );
			bytes.write( (byte)(innerClassTable.outer_class_info_index & 255) );

			bytes.write( (byte)(innerClassTable.inner_name_index >> 8) );
			bytes.write( (byte)(innerClassTable.inner_name_index & 255) );

			bytes.write( (byte)(innerClassTable.inner_class_access_flags >> 8) );
			bytes.write( (byte)(innerClassTable.inner_class_access_flags & 255) );
		}

		return bytes.toByteArray();
	}

}
