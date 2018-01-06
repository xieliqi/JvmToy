package com.jt.parser.classInfo;

import java.util.Arrays;

public class Methods {
	
	private MethodInfo[] methods;

	public Methods(MethodInfo[] methods){
		this.methods = methods;
	}

	public MethodInfo[] getMethods() {
		return methods;
	}

	@Override
	public String toString() {
		return "Methods [methods=" + Arrays.toString(methods) + "]";
	}

}
