package com.jt.decompile;

import java.util.Set;

public class MethodInfoDisplay{
	
	private String methodName;
	
	private String returnType;
	
	private ParamInfoDisplay[] params;
	
	private Set<String> accessFlags;
	
	private boolean isDeprecated = false;
	
	private boolean isNative = false;
	
	private boolean isAbstract = false;

	private AnnotationInfoDisplay[] runtimeVisibleAnnotations;
	
	private AnnotationInfoDisplay[] runtimeInvisibleAnnotations;
	
	private String[] exceptions;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public Set<String> getAccessFlags() {
		return accessFlags;
	}

	public void setAccessFlags(Set<String> accessFlags) {
		this.accessFlags = accessFlags;
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

	public boolean isNative() {
		return isNative;
	}

	public void setNative(boolean isNative) {
		this.isNative = isNative;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public ParamInfoDisplay[] getParams() {
		return params;
	}

	public void setParams(ParamInfoDisplay[] params) {
		this.params = params;
	}

	public String[] getExceptions() {
		return exceptions;
	}

	public void setExceptions(String[] exceptions) {
		this.exceptions = exceptions;
	}
}
