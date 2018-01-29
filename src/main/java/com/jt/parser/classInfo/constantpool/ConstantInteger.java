package com.jt.parser.classInfo.constantpool;

public class ConstantInteger extends ConstantTag{
	

	private int bytes;//u4
	
	public ConstantInteger(int tag,int bytes){
		this.tag = tag;
		this.bytes = bytes;
	}
	
	public int getValue() {
		return bytes;
	}

	@Override
	public String toString() {
		return "ConstantInteger " + bytes;
	}
	
}
