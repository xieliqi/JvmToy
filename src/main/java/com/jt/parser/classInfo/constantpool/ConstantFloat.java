package com.jt.parser.classInfo.constantpool;

public class ConstantFloat extends ConstantTag{
	
	private float bytes;//u4
	
	public ConstantFloat(int tag,float bytes){
		this.tag = tag;
		this.bytes = bytes;
	}
	
	public float getValue() {
		return bytes;
	}

	@Override
	public String toString() {
		return "ConstantFloat " + bytes;
	}

}
