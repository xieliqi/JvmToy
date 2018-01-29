package com.jt.parser.classInfo.constantpool;

public class ConstantDouble extends ConstantTag{
	
	private double value;//u4
	
	public ConstantDouble(int tag,double value){
		this.tag = tag;
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}

	@Override
	public String toString() {
		return "ConstantDouble " + value;
	}

	@Override
	public int getSlot() {
		return 2;
	}
	
}
