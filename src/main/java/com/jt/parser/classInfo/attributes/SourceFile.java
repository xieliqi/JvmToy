package com.jt.parser.classInfo.attributes;
/**
 * 可选的定长属性，位于ClassFile。一个ClassFile结构中的属性表最多只能包含一个SourceFile属性。
 * @author xieliqi
 *
 */
public class SourceFile extends AbstractAttribute {

	private int sourceFileIndex;// u2 指向CONSTANT_Utf8_info

	public SourceFile(int attributeNameIndex, int attributeLength, int sourceFileIndex) {
		super(attributeNameIndex, attributeLength);
		this.sourceFileIndex = sourceFileIndex;
	}

	@Override
	public String getName() {
		return "SourceFile";
	}

	public int getSourceFileIndex() {
		return sourceFileIndex;
	}

	@Override
	public String toString() {
		return "SourceFile [sourceFileIndex=" + sourceFileIndex + ", attributeNameIndex=" + attributeNameIndex
				+ ", attributeLength=" + attributeLength + ", getName()=" + getName() + "]";
	}

}
