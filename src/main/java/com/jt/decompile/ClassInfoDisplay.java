package com.jt.decompile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassInfoDisplay {
	
	public static final int TYPE_CLASS = 1;
	public static final int TYPE_INTERFACE = 2;
	public static final int TYPE_ENUM = 3;
	public static final int TYPE_ANNOTATION = 4;

	private String className;

	private Set<String> accessFlags;

	private String superClass;

	private String[] interfaces;

	private Set<String> importClasses;
	
	private int type;
	
	private Object innerClasses;
	
	private FieldInfoDisplay[] fields;
	
	private MethodInfoDisplay[] methods;
	
	private boolean isDeprecated = false;
	
	private List<AnnotationInfoDisplay> annotations;
	
	public ClassInfoDisplay() {
		accessFlags = new HashSet<String>();
		importClasses = new HashSet<String>();
		annotations = new ArrayList<AnnotationInfoDisplay>();
	}
	
	public String getPackageInfo() {
		int endIndex = className.lastIndexOf(".");
		String packageInfo = className.substring(0, endIndex);
		return packageInfo;
	}
	
	public void addImportClass(String importClass){
		importClasses.add(importClass);
	}
	
	public void addAnnotation(AnnotationInfoDisplay annotation){
		annotations.add(annotation);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}


	public String getSuperClass() {
		if(superClass.equals("java.lang.Object")){
			return "";
		}
		return superClass;
	}

	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Object getInnerClasses() {
		return innerClasses;
	}

	public void setInnerClasses(Object innerClasses) {
		this.innerClasses = innerClasses;
	}

	public boolean isDeprecated() {
		return isDeprecated;
	}

	public void setDeprecated(boolean isDeprecated) {
		this.isDeprecated = isDeprecated;
	}

	public Set<String> getAccessFlags() {
		return accessFlags;
	}

	public void setAccessFlags(Set<String> accessFlags) {
		this.accessFlags = accessFlags;
	}

	public Set<String> getImportClasses() {
		return importClasses;
	}

	public void setImportClasses(Set<String> importClasses) {
		this.importClasses = importClasses;
	}

	public List<AnnotationInfoDisplay> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<AnnotationInfoDisplay> annotations) {
		this.annotations = annotations;
	}

	public String[] getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(String[] interfaces) {
		this.interfaces = interfaces;
	}

	public FieldInfoDisplay[] getFields() {
		return fields;
	}

	public void setFields(FieldInfoDisplay[] fields) {
		this.fields = fields;
	}

	public MethodInfoDisplay[] getMethods() {
		return methods;
	}

	public void setMethods(MethodInfoDisplay[] methods) {
		this.methods = methods;
	}
}
