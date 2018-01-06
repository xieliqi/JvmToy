package com.jt.decompile;

import java.util.Set;

public class FieldInfoDisplay {

	private String fieldName;

	private String fieldType;
	
	private Set<String> accessFlags;

	private String fieldValue;

	private boolean isDeprecated = false;

	private AnnotationInfoDisplay[] runtimeVisibleAnnotations;
	
	private AnnotationInfoDisplay[] runtimeInvisibleAnnotations;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Set<String> getAccessFlags() {
		return accessFlags;
	}

	public void setAccessFlags(Set<String> accessFlags) {
		this.accessFlags = accessFlags;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public boolean isDeprecated() {
		return isDeprecated;
	}

	public void setDeprecated(boolean isDeprecated) {
		this.isDeprecated = isDeprecated;
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
