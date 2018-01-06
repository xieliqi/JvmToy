package com.jt.parser.classInfo.attributes;

import com.jt.parser.classInfo.attributes.annotations.ElementValue;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class AnnotationDefault extends AbstractAttribute {

	private ElementValue defaultValue;

	public AnnotationDefault(int attributeNameIndex, int attributeLength, ElementValue defaultValue) {
		super(attributeNameIndex, attributeLength);
		this.defaultValue = defaultValue;
	}

	@Override
	public String getName() {
		return "AnnotationDefault";
	}

	public ElementValue getDefaultValue() {
		return defaultValue;
	}

	@Override
	public String toString() {
		return "AnnotationDefault [defaultValue=" + defaultValue + ", attributeNameIndex=" + attributeNameIndex
				+ ", attributeLength=" + attributeLength + ", getName()=" + getName() + "]";
	}

}
