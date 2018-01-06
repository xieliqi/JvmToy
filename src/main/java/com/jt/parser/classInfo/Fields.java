package com.jt.parser.classInfo;

import java.util.Arrays;

public class Fields {

	private FieldInfo[] fields;

	public Fields(FieldInfo[] fields) {
		this.fields = fields;
	}

	public FieldInfo[] getFields() {
		return fields;
	}

	@Override
	public String toString() {
		return "Fields [fields=" + Arrays.toString(fields) + "]";
	}

}
