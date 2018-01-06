package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

import com.jt.parser.classInfo.attributes.annotations.AnnotationInfo;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class RuntimeVisibleAnnotations extends AbstractAttribute {

	private AnnotationInfo[] annotations;

	public RuntimeVisibleAnnotations(int attributeNameIndex, int attributeLength, AnnotationInfo[] annotations) {
		super(attributeNameIndex, attributeLength);
		this.annotations = annotations;
	}

	@Override
	public String getName() {
		return "RuntimeVisibleAnnotations";
	}

	public AnnotationInfo[] getAnnotations() {
		return annotations;
	}

	@Override
	public String toString() {
		return "RuntimeVisibleAnnotations [annotations=" + Arrays.toString(annotations) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

}
