package com.jt.parser.classInfo.constantpool;

public class ConstantClass extends ConstantTag{
	
	private int nameIndex;//u2
	
	public ConstantClass(int tag,int nameIndex){
		this.tag = tag;
		this.nameIndex = nameIndex;
	}
	
	public int getNameIndex() {
		return nameIndex;
	}

	@Override
	public String toString() {
		return "ConstantClass #" + nameIndex;
	}

}
