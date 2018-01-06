package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

import com.jt.parser.classInfo.attributes.annotations.ParameterAnnotations;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class RuntimeInvisibleParameterAnnotations extends AbstractAttribute {

	private ParameterAnnotations[] parameterAnnotations;

	public RuntimeInvisibleParameterAnnotations(int attributeNameIndex, int attributeLength,
			ParameterAnnotations[] parameterAnnotations) {
		super(attributeNameIndex, attributeLength);
		this.parameterAnnotations = parameterAnnotations;
	}

	@Override
	public String getName() {
		return "RuntimeInvisibleParameterAnnotations";
	}

	public ParameterAnnotations[] getParameterAnnotations() {
		return parameterAnnotations;
	}

	@Override
	public String toString() {
		return "RuntimeInvisibleParameterAnnotations [parameterAnnotations=" + Arrays.toString(parameterAnnotations)
				+ ", attributeNameIndex=" + attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

}
