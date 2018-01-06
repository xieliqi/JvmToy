package com.jt.parser.classInfo.attributes;

public abstract class AbstractAttribute {

	protected int attributeNameIndex;// u2
	protected int attributeLength;// u4

	public AbstractAttribute(int attributeNameIndex, int attributeLength) {
		this.attributeNameIndex = attributeNameIndex;
		this.attributeLength = attributeLength;
	}

	public int getAttributeNameIndex() {
		return attributeNameIndex;
	}

	public int getAttributeLength() {
		return attributeLength;
	}

	public abstract String getName();

}
