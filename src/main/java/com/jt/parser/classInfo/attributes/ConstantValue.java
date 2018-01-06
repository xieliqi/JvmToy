package com.jt.parser.classInfo.attributes;

public class ConstantValue extends AbstractAttribute {

	private int constantValueIndex;// u2 // 已用CONSTANT_Long、CONSTANT_Float、CONSTANT_Double、CONSTANT_Integer、CONSTANT_String

	public ConstantValue(int attributeNameIndex, int attributeLength, int constantValueIndex) {
		super(attributeNameIndex, attributeLength);
		this.constantValueIndex = constantValueIndex;
	}

	@Override
	public String getName() {
		return "ConstantValue";
	}

	public int getConstantValueIndex() {
		return constantValueIndex;
	}

	@Override
	public String toString() {
		return "ConstantValue [constantValueIndex=" + constantValueIndex + ", attributeNameIndex=" + attributeNameIndex
				+ ", attributeLength=" + attributeLength + ", getName()=" + getName() + "]";
	}
	
}
