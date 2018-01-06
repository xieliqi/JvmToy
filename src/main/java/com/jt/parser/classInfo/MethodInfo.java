package com.jt.parser.classInfo;

public class MethodInfo {
	private MethodAccessFlags accessFlags;//u2
	private int nameIndex;//u2
	private int descriptorIndex;//u2
	private Attributes attributes;
	
	public MethodInfo(int flags,int nameIndex,int descriptorIndex,Attributes attributes) {
		this.accessFlags = new MethodAccessFlags(flags);
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
		this.attributes = attributes;
	}
	
	public MethodAccessFlags getAccessFlags() {
		return accessFlags;
	}
	public int getNameIndex() {
		return nameIndex;
	}
	public int getDescriptorIndex() {
		return descriptorIndex;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	@Override
	public String toString() {
		return "MethodInfo [accessFlags=" + accessFlags + ", nameIndex=" + nameIndex + ", descriptorIndex="
				+ descriptorIndex + ", attributes=" + attributes + "]";
	}
	
}
