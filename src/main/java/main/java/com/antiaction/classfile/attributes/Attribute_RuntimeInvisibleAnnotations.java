package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_RuntimeInvisibleAnnotations extends AttributeAbstract {

	List<Annotation> annotations;

	public Attribute_RuntimeInvisibleAnnotations() {
		classfileVersion = Constants.CLASSFILE_VERSION_49_0;
		jvmVersion = Constants.JVM_VERSION_5_0;
		usage = Constants.ATTR_LOCATION_CLASSFILE | Constants.ATTR_LOCATION_FIELD_INFO | Constants.ATTR_LOCATION_METHOD_INFO;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		cfs.assert_unexpected_eof( attribute_length );
		int num_annonations = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		annotations = new ArrayList<Annotation>();
		Annotation annotation;
		for ( int i=0; i<num_annonations; ++i ) {
			annotation = new Annotation();
			annotation.disassemble( cfs );
			annotations.add( annotation );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		Annotation annotation;
		for ( int i=0; i<annotations.size(); ++i ) {
			annotation = annotations.get( i );
			annotation.resolve();
		}
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int num_annonations = annotations.size();
		out.write( (byte)(num_annonations >> 8) );
		out.write( (byte)(num_annonations & 255) );
		Annotation annotation;
		for ( int i=0; i<annotations.size(); ++i ) {
			annotation = annotations.get( i );
			annotation.assemble( out );
		}
	}

}
