package com.jt.parser.classInfo;

import com.jt.parser.classInfo.constantpool.ConstantPools;

public class ClassInfo {
	
	private String magic;//u4
	private int minorVersion;//u2
	private int majorVersion;//u2
	private ConstantPools constantPools;
	private ClassAccessFlags accessFlags;//u2
	private int thisClass;//u2
	private int superClass;//u2
	private Interfaces interfaces;
	private Fields fields;
	private Methods methods;
	private Attributes attributes;
	
	public void display(){
		System.out.println("magic:"+magic);
		System.out.println("minorVersion:"+minorVersion);
		System.out.println("majorVersion:"+majorVersion);
		System.out.println("constantPools:"+constantPools);
		System.out.println("accessFlags:"+accessFlags);
		System.out.println("thisClass:"+thisClass);
		System.out.println("superClass:"+superClass);
		System.out.println("interfaces:"+interfaces);
		System.out.println("fields:"+fields);
		System.out.println("methods:"+methods);
		System.out.println("attributes:"+attributes);
	}
	
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	public void setConstantPools(ConstantPools constantPools) {
		this.constantPools = constantPools;
	}
	public void setAccessFlags(ClassAccessFlags accessFlags) {
		this.accessFlags = accessFlags;
	}
	public void setThisClass(int thisClass) {
		this.thisClass = thisClass;
	}
	public void setSuperClass(int superClass) {
		this.superClass = superClass;
	}
	public void setInterfaces(Interfaces interfaces) {
		this.interfaces = interfaces;
	}
	public void setMethods(Methods methods) {
		this.methods = methods;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public String getMagic() {
		return magic;
	}
	public int getMinorVersion() {
		return minorVersion;
	}
	public int getMajorVersion() {
		return majorVersion;
	}
	public ConstantPools getConstantPools() {
		return constantPools;
	}
	public ClassAccessFlags getAccessFlags() {
		return accessFlags;
	}
	public int getThisClass() {
		return thisClass;
	}
	public int getSuperClass() {
		return superClass;
	}
	public Interfaces getInterfaces() {
		return interfaces;
	}
	public Methods getMethods() {
		return methods;
	}
	public Attributes getAttributes() {
		return attributes;
	}

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}
	
}
