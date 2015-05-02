package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_RuntimeInvisibleTypeAnnotations extends AttributeAbstract {

	public List<TypeAnnotation> annotations;

	public Attribute_RuntimeInvisibleTypeAnnotations() {
		classfileVersion = Constants.CLASSFILE_VERSION_52_0;
		jvmVersion = Constants.JVM_VERSION_8;
		usage = Constants.ATTR_LOCATION_CLASSFILE | Constants.ATTR_LOCATION_FIELD_INFO | Constants.ATTR_LOCATION_METHOD_INFO | Constants.ATTR_LOCATION_CODE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		int num_annotations = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		annotations = new ArrayList<TypeAnnotation>();
		TypeAnnotation typeAnnotation;
		for ( int i=0; i<num_annotations; ++i ) {
			typeAnnotation = new TypeAnnotation();
			typeAnnotation.disassemble( cfs );
			annotations.add( typeAnnotation );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve...?
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int num_annotations = annotations.size();
		out.write( (byte)(num_annotations >> 8) );
		out.write( (byte)(num_annotations & 255) );
		TypeAnnotation typeAnnotation;
		for ( int i=0; i<num_annotations; ++i ) {
			typeAnnotation = annotations.get( i );
			typeAnnotation.assemble( out );
		}
	}

}
