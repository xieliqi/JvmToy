package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

/**
 * 可选的定长属性，位于ClassFile（§4.1）结构属性表。ClassFile结构的属性表最多只能包含一个SourceDebugExtension属性。
 * @author xieliqi
 *
 */
public class SourceDebugExtension extends AbstractAttribute {

	private byte[] debugExtension;

	public SourceDebugExtension(int attributeNameIndex, int attributeLength, byte[] debugExtension) {
		super(attributeNameIndex, attributeLength);
		this.debugExtension = debugExtension;
	}

	@Override
	public String getName() {
		return "SourceDebugExtension";
	}

	public byte[] getDebugExtension() {
		return debugExtension;
	}

	@Override
	public String toString() {
		return "SourceDebugExtension [debugExtension=" + Arrays.toString(debugExtension) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + ", getName()=" + getName() + "]";
	}

}
