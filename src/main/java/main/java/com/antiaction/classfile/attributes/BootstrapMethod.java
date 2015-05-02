package com.antiaction.classfile.attributes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.antiaction.classfile.BuildingBlockAbstract;
import com.antiaction.classfile.ClassFileException;
import com.antiaction.classfile.ClassFileState;

public class BootstrapMethod extends BuildingBlockAbstract {

	public int attribute_name_index;

	public int num_bootstrap_arguments;

	public List<BootstrapArgument> bootstrap_arguments;

	@Override
	public void disassemble(ClassFileState cfs) throws ClassFileException {
		attribute_name_index = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		num_bootstrap_arguments = (cfs.bytes[ cfs.index++ ] & 255) << 8 | (cfs.bytes[ cfs.index++ ] & 255);
		BootstrapArgument bootstrapArgument;
		for ( int i=0; i<num_bootstrap_arguments; ++i ) {
			bootstrapArgument = new BootstrapArgument();
			bootstrapArgument.disassemble( cfs );
			bootstrap_arguments.add( bootstrapArgument );
		}
	}

	@Override
	public void resolve() throws ClassFileException {
		// TODO resolve...
	}

	@Override
	public void assemble(ByteArrayOutputStream out) throws IOException {
		out.write( (byte)(attribute_name_index >> 8) );
		out.write( (byte)(attribute_name_index & 255) );
		int num_bootstrap_arguments = bootstrap_arguments.size();
		out.write( (byte)(num_bootstrap_arguments >> 8) );
		out.write( (byte)(num_bootstrap_arguments & 255) );
		BootstrapArgument bootstrapArgument;
		for ( int i=0; i<num_bootstrap_arguments; ++i ) {
			bootstrapArgument = bootstrap_arguments.get( i );
			bootstrapArgument.assemble( out );
		}
		
	}

}
