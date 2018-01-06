package com.jt.decompile;

public class ParamInfoDisplay {

	private String name;

	private String type;

	private AnnotationInfoDisplay[] runtimeVisibleAnnotations;

	private AnnotationInfoDisplay[] runtimeInvisibleAnnotations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AnnotationInfoDisplay[] getRuntimeVisibleAnnotations() {
		return runtimeVisibleAnnotations;
	}

	public void setRuntimeVisibleAnnotations(AnnotationInfoDisplay[] runtimeVisibleAnnotations) {
		this.runtimeVisibleAnnotations = runtimeVisibleAnnotations;
	}

	public AnnotationInfoDisplay[] getRuntimeInvisibleAnnotations() {
		return runtimeInvisibleAnnotations;
	}

	public void setRuntimeInvisibleAnnotations(AnnotationInfoDisplay[] runtimeInvisibleAnnotations) {
		this.runtimeInvisibleAnnotations = runtimeInvisibleAnnotations;
	}

}
