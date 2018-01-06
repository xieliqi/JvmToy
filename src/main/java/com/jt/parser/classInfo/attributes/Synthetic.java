package com.jt.parser.classInfo.attributes;
/**
 * 定长属性
 * 用于ClassFile结构的属性表。
 * 如果一个类成员没有在源文件中出现，则必须标记带有Synthetic属性，或者设置ACC_SYNTHETIC标志。
 * @author xieliqi
 *
 */
public class Synthetic extends AbstractAttribute {

	private int classIndex;// u2 指向CONSTANT_Class_info
	private int methodIndex;// u2 为0或指向CONSTANT_NameAndType_info
	
	public Synthetic(int attributeNameIndex, int attributeLength, int classIndex, int methodIndex) {
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
