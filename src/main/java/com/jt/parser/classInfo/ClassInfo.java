package com.jt.parser.classInfo;

public class ClassInfo {
	
	private String magic;//u4
	private String minorVersion;//u2
	private String majorVersion;//u2
	private ConstantPools constantPools;
	private String accessFlags;//u2
	private String thisClass;//u2
	private String superClass;//u2
	private Interfaces interfaces;
	private Methods methods;
	private Attributes attributes;
	
	public void display(){
		System.out.println("magic:"+magic);
		System.out.println("minorVersion:"+minorVersion);
		System.out.println("majorVersion:"+majorVersion);
		System.out.println("constantPools:"+constantPools);
	}
	
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}
	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}
	public void setConstantPools(ConstantPools constantPools) {
		this.constantPools = constantPools;
	}
	public void setAccessFlags(String accessFlags) {
		this.accessFlags = accessFlags;
	}
	public void setThisClass(String thisClass) {
		this.thisClass = thisClass;
	}
	public void setSuperClass(String superClass) {
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
	public String getMinorVersion() {
		return minorVersion;
	}
	public String getMajorVersion() {
		return majorVersion;
	}
	public ConstantPools getConstantPools() {
		return constantPools;
	}
	public String getAccessFlags() {
		return accessFlags;
	}
	public String getThisClass() {
		return thisClass;
	}
	public String getSuperClass() {
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
	
}
