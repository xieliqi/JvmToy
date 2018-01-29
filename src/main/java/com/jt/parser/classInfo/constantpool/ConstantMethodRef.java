package com.jt.parser.classInfo.constantpool;

public class ConstantMethodRef extends ConstantTag{
	
	private int classIndex;//u2
	private int nameAndTypeIndex;//u2
	
	public ConstantMethodRef(int tag,int classIndex,int nameAndTypeIndex) {
		this.tag = tag;
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}
	
	public int getClassIndex() {
		return classIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	@Override
	public String toString() {
		return "ConstantMethodRef #" + classIndex + ".#" + nameAndTypeIndex;
	}
	
}
