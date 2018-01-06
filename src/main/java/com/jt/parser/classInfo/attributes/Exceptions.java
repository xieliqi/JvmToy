package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

public class Exceptions extends AbstractAttribute {


	private int[] exceptionIndexTable;//引用常量池中CONSTANT_Class_info
	
	public Exceptions(int attributeNameIndex, int attributeLength, int[] exceptionIndexTable) {
		super(attributeNameIndex, attributeLength);
		this.exceptionIndexTable = exceptionIndexTable;
	}

	@Override
	public String getName() {
		return "Exceptions";
	}

	public int[] getExceptionIndexTable() {
		return exceptionIndexTable;
	}

	@Override
	public String toString() {
		return "Exceptions [exceptionIndexTable=" + Arrays.toString(exceptionIndexTable) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}


}
