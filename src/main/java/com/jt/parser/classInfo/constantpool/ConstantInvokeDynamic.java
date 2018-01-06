package com.jt.parser.classInfo.constantpool;

public class ConstantInvokeDynamic extends ConstantTag {

	private int bootstrapMethodAttrIndex;// u2
	private int nameAndTypeIndex;// u2

	public ConstantInvokeDynamic(int tag,int bootstrapMethodAttrIndex,int nameAndTypeIndex) {
		this.tag = tag;
		this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	public int getBootstrapMethodAttrIndex() {
		return bootstrapMethodAttrIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	@Override
	public String toString() {
		return "ConstantInvokeDynamic [bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex + ", nameAndTypeIndex="
				+ nameAndTypeIndex + ", tag=" + tag + "]";
	}

}
