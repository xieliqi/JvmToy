package com.jt.parser.classInfo.constantpool;

public abstract class ConstantTag {
	
	protected int tag;
	
	public int getSlot(){
		return 1;
	}

	public int getTag() {
		return tag;
	}
	
}
