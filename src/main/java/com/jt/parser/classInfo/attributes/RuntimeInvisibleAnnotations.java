package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

import com.jt.parser.classInfo.attributes.annotations.AnnotationInfo;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class RuntimeInvisibleAnnotations extends AbstractAttribute {

	private AnnotationInfo[] annotations;

	public RuntimeInvisibleAnnotations(int attributeNameIndex, int attributeLength, AnnotationInfo[] annotations) {
		super(attributeNameIndex, attributeLength);
		this.annotations = annotations;
	}

	@Override
	public String getName() {
		return "RuntimeInvisibleAnnotations";
	}

	public AnnotationInfo[] getAnnotations() {
		return annotations;
	}

	@Override
	public String toString() {
		return "RuntimeInvisibleAnnotations [annotations=" + Arrays.toString(annotations) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

}
