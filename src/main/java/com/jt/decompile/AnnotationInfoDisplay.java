package com.jt.decompile;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnnotationInfoDisplay{
	
	private String className;
	
	private Map<String, Object> values;
	
	public AnnotationInfoDisplay() {
		values = new LinkedHashMap<String, Object>();
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}
	
}
