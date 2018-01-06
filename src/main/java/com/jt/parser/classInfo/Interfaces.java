package com.jt.parser.classInfo;

import java.util.Arrays;

public class Interfaces {

	private int[] interfaces;

	public Interfaces(int[] interfaces){
		this.interfaces = interfaces;
	}

	public int[] getInterfaces() {
		return interfaces;
	}

	@Override
	public String toString() {
		return "Interfaces [interfaces=" + Arrays.toString(interfaces) + "]";
	}

}
