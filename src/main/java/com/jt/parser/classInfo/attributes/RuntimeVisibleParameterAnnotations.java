package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

import com.jt.parser.classInfo.attributes.annotations.ParameterAnnotations;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class RuntimeVisibleParameterAnnotations extends AbstractAttribute {

	private ParameterAnnotations[] parameterAnnotations;

	public RuntimeVisibleParameterAnnotations(int attributeNameIndex, int attributeLength, ParameterAnnotations[] parameterAnnotations) {
		super(attributeNameIndex, attributeLength);
		this.parameterAnnotations = parameterAnnotations;
	}

	@Override
	public String getName() {
		return "RuntimeVisibleParameterAnnotations";
	}

	public ParameterAnnotations[] getParameterAnnotations() {
		return parameterAnnotations;
	}

	@Override
	public String toString() {
		return "RuntimeVisibleParameterAnnotations [parameterAnnotations=" + Arrays.toString(parameterAnnotations)
				+ ", attributeNameIndex=" + attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

}
