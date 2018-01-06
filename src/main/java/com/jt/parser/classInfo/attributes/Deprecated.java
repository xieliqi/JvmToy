package com.jt.parser.classInfo.attributes;
/**
 * 可选的定长属性，位于ClassFile，field_info或method_info结构的属性表中。
 * @author xieliqi
 *
 */
public class Deprecated extends AbstractAttribute {

	private int signatureIndex;// u2 指向CONSTANT_Utf8_info

	public Deprecated(int attributeNameIndex, int attributeLength, int signatureIndex) {
		super(attributeNameIndex, attributeLength);
		this.signatureIndex = signatureIndex;
	}

	@Override
	public String getName() {
		return "Signature";
	}

	public int getSignatureIndex() {
		return signatureIndex;
	}

	@Override
	public String toString() {
		return "Signature [signatureIndex=" + signatureIndex + ", attributeNameIndex=" + attributeNameIndex
				+ ", attributeLength=" + attributeLength + ", getName()=" + getName() + "]";
	}

}
