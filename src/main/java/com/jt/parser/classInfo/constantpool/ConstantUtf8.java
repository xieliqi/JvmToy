package com.jt.parser.classInfo.constantpool;

public class ConstantUtf8 extends ConstantTag {

	private String utf8;

	public ConstantUtf8(int tag,String utf8){
		this.tag = tag;
		this.utf8 = utf8;
	}
	
	public String getValue(){
		return utf8;
	}

	@Override
	public String toString() {
		return "ConstantUtf8 " + utf8;
	}

}
