package com.jt.parser.classInfo;

import java.util.Arrays;

import com.jt.parser.classInfo.attributes.AbstractAttribute;

public class Attributes {
	
	private AbstractAttribute[] attributes;

	public Attributes(AbstractAttribute[] attributes){
		this.attributes = attributes;
	}

	public AbstractAttribute[] getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "Attributes [attributes=" + Arrays.toString(attributes) + "]";
	}

}
