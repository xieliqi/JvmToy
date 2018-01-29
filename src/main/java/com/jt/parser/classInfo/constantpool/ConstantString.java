package com.jt.parser.classInfo.constantpool;

public class ConstantString extends ConstantTag{
	
	private int stringIndex;//u2
	
	public ConstantString(int tag,int stringIndex){
		this.tag = tag;
		this.stringIndex = stringIndex;
	}
	
	public int getStringIndex() {
		return stringIndex;
	}

	@Override
	public String toString() {
		return "ConstantString #" + stringIndex;
	}

}
