package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;
import com.antiaction.classfile.Constants;

public class Attribute_BootstrapMethods extends AttributeAbstract {

	public List<BootstrapMethod> bootstrap_methods;

	public Attribute_BootstrapMethods() {
		classfileVersion = Constants.CLASSFILE_VERSION_51_0;
		jvmVersion = Constants.JVM_VERSION_7;
		usage = Constants.ATTR_LOCATION_CLASSFILE;
	}

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		int num_bootstrap_methods = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		bootstrap_methods = new ArrayList<BootstrapMethod>();
		BootstrapMethod bootstrapMethod;
		for ( int i=0; i<num_bootstrap_methods; ++i ) {
			bootstrapMethod = new BootstrapMethod();
			bootstrapMethod.disassemble( cfs );
			bootstrap_methods.add( bootstrapMethod );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve?
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		int num_bootstrap_methods = bootstrap_methods.size();
		out.write( (byte)(num_bootstrap_methods >> 8) );
		out.write( (byte)(num_bootstrap_methods & 255) );
		BootstrapMethod bootstrapMethod;
		for ( int i=0; i<num_bootstrap_methods; ++i ) {
			bootstrapMethod = bootstrap_methods.get( i );
			bootstrapMethod.assemble( out );
		}
	}

}
