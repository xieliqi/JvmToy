package com.jt.parser.classInfo.attributes.annotations;

public class ElementValue {
	public final static char TAG_B = 'B';// byte
	public final static char TAG_C = 'C';// char
	public final static char TAG_D = 'D';// double
	public final static char TAG_F = 'F';// float
	public final static char TAG_I = 'I';// int
	public final static char TAG_J = 'J';// long
	public final static char TAG_S = 'S';// short
	public final static char TAG_Z = 'Z';// boolean
	public final static char TAG_SS = 's';// String
	public final static char TAG_EE = 'e';// enum constant
	public final static char TAG_CC = 'c';// class
	public final static char TAG_ANN = '@';// annotation type
	public final static char TAG_ARR = '[';// array

	private char tag;// u1

	private int constValueIndex;// u2 tag=[B, C, D, F,I, J, S, Z,s]
	private EnumConstValue enumConstValue;// tag=[e]
	private int classInfoIndex;// u2 tag=[c]
	private AnnotationInfo annotationValue;// u2 tag=[@]
	private ElementValue[] arrayValue;// u2 tag=[[]

	public ElementValue(char tag, int constValueIndex, EnumConstValue enumConstValue, int classInfoIndex,
			AnnotationInfo annotationValue, ElementValue[] arrayValue) {
		this.tag = tag;
		this.arrayValue = arrayValue;
		this.annotationValue = annotationValue;
		this.classInfoIndex = classInfoIndex;
		this.enumConstValue = enumConstValue;
		this.constValueIndex = constValueIndex;
	}

	public int getConstValueIndex() {
		return constValueIndex;
	}

	public EnumConstValue getEnumConstValue() {
		return enumConstValue;
	}

	public int getClassInfoIndex() {
		return classInfoIndex;
	}

	public AnnotationInfo getAnnotationValue() {
		return annotationValue;
	}

	public ElementValue[] getArrayValue() {
		return arrayValue;
	}

	public char getTag() {
		return tag;
	}

	@Override
	public String toString() {
		return "ElementValue [tag=" + tag + ", constValueIndex=" + constValueIndex + ", enumConstValue="
				+ enumConstValue + ", classInfoIndex=" + classInfoIndex + ", annotationValue=" + annotationValue
				+ ", arrayValue=" + arrayValue + "]";
	}

	public static class EnumConstValue {
		private int typeNameIndex;// u2
		private int constNameIndex;// u2

		public EnumConstValue(int typeNameIndex, int constNameIndex) {
			this.typeNameIndex = typeNameIndex;
			this.constNameIndex = constNameIndex;
		}

		public int getTypeNameIndex() {
			return typeNameIndex;
		}

		public int getConstNameIndex() {
			return constNameIndex;
		}

		@Override
		public String toString() {
			return "EnumConstValue [typeNameIndex=" + typeNameIndex + ", constNameIndex=" + constNameIndex + "]";
		}

	}

}