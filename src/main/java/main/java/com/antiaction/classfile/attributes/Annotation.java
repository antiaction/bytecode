package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class Annotation extends BuildingBlockAbstract {

	public int type_index;

	public List<ElementValuePair> element_value_pairs;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		type_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		int num_element_value_pairs = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		element_value_pairs = new ArrayList<ElementValuePair>();
		ElementValuePair elementValuePair;
		for ( int i=0; i<num_element_value_pairs; ++i ) {
			elementValuePair = new ElementValuePair();
			elementValuePair.disassemble( cfs );
			element_value_pairs.add( elementValuePair );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve resolve resolve!
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(type_index >> 8) );
		out.write( (byte)(type_index & 255) );
		int num_element_value_pairs = element_value_pairs.size();
		out.write( (byte)(num_element_value_pairs >> 8) );
		out.write( (byte)(num_element_value_pairs & 255) );
		ElementValuePair elementValuePair;
		for ( int i=0; i<num_element_value_pairs; ++i ) {
			elementValuePair = element_value_pairs.get( i );
			elementValuePair.assemble( out );
		}
	}

}
