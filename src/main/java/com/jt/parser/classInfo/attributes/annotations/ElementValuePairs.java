package com.jt.parser.classInfo.attributes.annotations;

public class ElementValuePairs {
	private int elementNameIndex;// u2
	private ElementValue value;

	public ElementValuePairs(int elementNameIndex, ElementValue value) {
		this.elementNameIndex = elementNameIndex;
		this.value = value;
	}

	public int getElementNameIndex() {
		return elementNameIndex;
	}

	public ElementValue getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ElementValuePairs [elementNameIndex=" + elementNameIndex + ", value=" + value + "]";
	}

	

}