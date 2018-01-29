package com.jt.parser.classInfo.attributes;
/**
 * 可选的定长属性，位于ClassFile，field_info或method_info结构的属性表中。
 * @author xieliqi
 *
 */
public class Deprecated extends AbstractAttribute {


	public Deprecated(int attributeNameIndex, int attributeLength) {
		super(attributeNameIndex, attributeLength);
	}

	@Override
	public String getName() {
		return "Deprecated";
	}

	@Override
	public String toString() {
		return "Deprecated [attributeNameIndex=" + attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

}
