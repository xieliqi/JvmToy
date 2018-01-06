package com.jt.parser.classInfo.constantpool;

public class ConstantMethodHandle extends ConstantTag{
	
	private int referenceKind;//u1
	private int referenceIndex;//u2
	
	public ConstantMethodHandle(int tag,int referenceKind,int referenceIndex) {
		this.tag = tag;
		this.referenceKind = referenceKind;
		this.referenceIndex = referenceIndex;
	}
	
	public int getReferenceKind() {
		return referenceKind;
	}

	public int getReferenceIndex() {
		return referenceIndex;
	}

	@Override
	public String toString() {
		return "ConstantMethodHandle [referenceKind=" + referenceKind + ", referenceIndex=" + referenceIndex + ", tag="
				+ tag + "]";
	}

}
