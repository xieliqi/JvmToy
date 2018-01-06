package com.jt.parser.classInfo.attributes;
/**
 * 定长属性
 * 用于ClassFile结构的属性表。
 * 当且仅当Class为局部类或者匿名类时，才能具有EnclosingMethod属性。
 * 一个类最多只能有一个EnclosingMethod属性。
 * @author xieliqi
 *
 */
public class EnclosingMethod extends AbstractAttribute {

	private int classIndex;// u2 指向CONSTANT_Class_info
	private int methodIndex;// u2 为0或指向CONSTANT_NameAndType_info
	
	public EnclosingMethod(int attributeNameIndex, int attributeLength, int classIndex, int methodIndex) {
		super(attributeNameIndex, attributeLength);
		this.classIndex = classIndex;
		this.methodIndex = methodIndex;
	}

	@Override
	public String getName() {
		return "EnclosingMethod";
	}

	public int getClassIndex() {
		return classIndex;
	}

	public int getMethodIndex() {
		return methodIndex;
	}

	@Override
	public String toString() {
		return "EnclosingMethod [classIndex=" + classIndex + ", methodIndex=" + methodIndex + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + ", getName()=" + getName() + "]";
	}

}
