package com.jt.parser.classInfo.constantpool;

public class ConstantNameAndType extends ConstantTag{
	
	private int nameIndex;//u2
	private int descriptorIndex;//u2
	
	public ConstantNameAndType(int tag,int nameIndex,int descriptorIndex){
		this.tag = tag;
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}
	
	public int getNameIndex() {
		return nameIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	@Override
	public String toString() {
		return "ConstantNameAndType #" + nameIndex + ", #" + descriptorIndex;
	}
	
}
