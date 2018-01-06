package com.jt.parser.classInfo.attributes.annotations;

import java.util.Arrays;

public class AnnotationInfo {
	private int typeIndex;// u2
	private ElementValuePairs[] elementValuePairs;

	public AnnotationInfo(int typeIndex, ElementValuePairs[] elementValuePairs) {
		this.typeIndex = typeIndex;
		this.elementValuePairs = elementValuePairs;
	}

	public int getTypeIndex() {
		return typeIndex;
	}

	public ElementValuePairs[] getElementValuePairs() {
		return elementValuePairs;
	}

	@Override
	public String toString() {
		return "AnnotationInfo [typeIndex=" + typeIndex + ", elementValuePairs=" + Arrays.toString(elementValuePairs)
				+ "]";
	}

}