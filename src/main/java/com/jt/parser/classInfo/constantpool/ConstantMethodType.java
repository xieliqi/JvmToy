package com.jt.parser.classInfo.constantpool;

public class ConstantMethodType extends ConstantTag{
	
	private int descriptorIndex;//u2
	
	public ConstantMethodType(int tag,int descriptorIndex){
		this.tag = tag;
		this.descriptorIndex = descriptorIndex;
	}
	
	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	@Override
	public String toString() {
		return "ConstantMethodType #" + descriptorIndex;
	}

}
