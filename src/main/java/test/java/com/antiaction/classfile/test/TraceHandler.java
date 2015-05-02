package com.antiaction.classfile.test;

import java.util.ArrayList;
import java.util.List;

import com.antiaction.classfile.ITraceHandler;

public class TraceHandler implements ITraceHandler {

	public List<Trace> traceList = new ArrayList<Trace>();

	public void reset() {
		traceList.clear();
	}

	@Override
	public void addIndex(int index, Object obj) {
		Trace trace = new Trace();
		trace.index = index;
		trace.obj = obj;
		traceList.add( trace );
	}

	public static class Trace {
		public int index;
		public Object obj;
	}

}
