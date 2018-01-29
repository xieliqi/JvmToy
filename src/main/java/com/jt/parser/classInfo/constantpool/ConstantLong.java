package com.jt.parser.classInfo.constantpool;

public class ConstantLong extends ConstantTag{
	
	private long bytes;
	
	public ConstantLong(int tag,long bytes){
		this.tag = tag;
		this.bytes = bytes;
	}
	
	public long getValue(){
		return bytes;
	}

	@Override
	public String toString() {
		return "ConstantLong " + bytes;
	}

	@Override
	public int getSlot() {
		return 2;
	}
	
}
