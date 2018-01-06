package com.jt.parser.classInfo.attributes.annotations;

import java.util.Arrays;

public class ParameterAnnotations {
	
	private AnnotationInfo[] annotations;

	public ParameterAnnotations(AnnotationInfo[] annotations) {
		this.annotations = annotations;
	}

	public AnnotationInfo[] getAnnotations() {
		return annotations;
	}

	@Override
	public String toString() {
		return "ParameterAnnotations [annotations=" + Arrays.toString(annotations) + "]";
	}

}
