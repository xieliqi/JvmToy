package com.jt.parser;

import java.io.DataInputStream;
import java.io.IOException;

import com.jt.parser.classInfo.Attributes;
import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.attributes.AbstractAttribute;
import com.jt.parser.classInfo.attributes.AnnotationDefault;
import com.jt.parser.classInfo.attributes.BootstrapMethods;
import com.jt.parser.classInfo.attributes.BootstrapMethods.BootstrapMethod;
import com.jt.parser.classInfo.attributes.Code;
import com.jt.parser.classInfo.attributes.ConstantValue;
import com.jt.parser.classInfo.attributes.Deprecated;
import com.jt.parser.classInfo.attributes.EnclosingMethod;
import com.jt.parser.classInfo.attributes.Exceptions;
import com.jt.parser.classInfo.attributes.InnerClasses;
import com.jt.parser.classInfo.attributes.InnerClasses.InnerClass;
import com.jt.parser.classInfo.attributes.LineNumberTable;
import com.jt.parser.classInfo.attributes.LineNumberTable.LineNumberInfo;
import com.jt.parser.classInfo.attributes.LocalVariableTable;
import com.jt.parser.classInfo.attributes.LocalVariableTable.LocalVariableInfo;
import com.jt.parser.classInfo.attributes.LocalVariableTypeTable;
import com.jt.parser.classInfo.attributes.LocalVariableTypeTable.LocalVariableTypeInfo;
import com.jt.parser.classInfo.attributes.RuntimeInvisibleAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeInvisibleParameterAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeVisibleAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeVisibleParameterAnnotations;
import com.jt.parser.classInfo.attributes.Signature;
import com.jt.parser.classInfo.attributes.SourceDebugExtension;
import com.jt.parser.classInfo.attributes.SourceFile;
import com.jt.parser.classInfo.attributes.StackMapTable;
import com.jt.parser.classInfo.attributes.StackMapTable.StackMapFrame;
import com.jt.parser.classInfo.attributes.StackMapTable.VerificationTypeInfo;
import com.jt.parser.classInfo.attributes.Synthetic;
import com.jt.parser.classInfo.attributes.annotations.AnnotationInfo;
import com.jt.parser.classInfo.attributes.annotations.ElementValue;
import com.jt.parser.classInfo.attributes.annotations.ElementValue.EnumConstValue;
import com.jt.parser.classInfo.attributes.annotations.ElementValuePairs;
import com.jt.parser.classInfo.attributes.annotations.ParameterAnnotations;

public class AttributesParser {

	public static Attributes parse(ClassInfo classInfo, DataInputStream di) throws IOException {
		int count = di.readUnsignedShort();
		AbstractAttribute[] attributes = new AbstractAttribute[count];
		for (int i = 0; i < count; i++) {
			attributes[i] = parseAttribute(classInfo, di);
		}
		return new Attributes(attributes);
	}

	private static AbstractAttribute parseAttribute(ClassInfo classInfo, DataInputStream di) throws IOException {
		int attributeNameIndex = di.readUnsignedShort();
		int attributeLength = di.readInt();
		String attrName = classInfo.getConstantPools().getUtf8String(attributeNameIndex);
		if (attrName.equals("ConstantValue")) {
			int constantValueIndex = di.readUnsignedShort();
			return new ConstantValue(attributeNameIndex, attributeLength, constantValueIndex);
		}
		if (attrName.equals("Code")) {
			int maxStack = di.readUnsignedShort();
			int maxLocals = di.readUnsignedShort();
			int codeLength = di.readInt();
			byte[] codes = new byte[codeLength];
			di.read(codes);
			return new Code(attributeNameIndex, attributeLength, maxStack, maxLocals, codes, parseExceptionTables(di),
					parse(classInfo, di));
		}
		if (attrName.equals("StackMapTable")) {
			return new StackMapTable(attributeNameIndex, attributeLength, parseStackMapFrame(di));
		}
		if (attrName.equals("Exceptions")) {
			int numberOfExceptions = di.readUnsignedShort();
			int[] exceptionIndexTable = new int[numberOfExceptions];
			for (int i = 0; i < numberOfExceptions; i++) {
				exceptionIndexTable[i] = di.readUnsignedShort();
			}
			return new Exceptions(attributeNameIndex, attributeLength, exceptionIndexTable);
		}
		if (attrName.equals("InnerClasses")) {
			int numberOfClasses = di.readUnsignedShort();
			InnerClass[] innerClasses = new InnerClass[numberOfClasses];
			for (int i = 0; i < numberOfClasses; i++) {
				int innerClassInfoIndex = di.readUnsignedShort();
				int outerClassInfoIndex = di.readUnsignedShort();
				int innerNameIndex = di.readUnsignedShort();
				int innerClassAccessFlags = di.readUnsignedShort();
				innerClasses[i] = new InnerClass(innerClassInfoIndex, outerClassInfoIndex, innerNameIndex,
						innerClassAccessFlags);
			}
			return new InnerClasses(attributeNameIndex, attributeLength, innerClasses);
		}
		if (attrName.equals("EnclosingMethod")) {
			int classIndex = di.readUnsignedShort();
			int methodIndex = di.readUnsignedShort();
			return new EnclosingMethod(attributeNameIndex, attributeLength, classIndex, methodIndex);
		}
		if (attrName.equals("Synthetic")) {
			int classIndex = di.readUnsignedShort();
			int methodIndex = di.readUnsignedShort();
			return new Synthetic(attributeNameIndex, attributeLength, classIndex, methodIndex);
		}
		if (attrName.equals("Signature")) {
			int signatureIndex = di.readUnsignedShort();
			return new Signature(attributeNameIndex, attributeLength, signatureIndex);
		}
		if (attrName.equals("SourceFile")) {
			int sourceFileIndex = di.readUnsignedShort();
			return new SourceFile(attributeNameIndex, attributeLength, sourceFileIndex);
		}
		if (attrName.equals("SourceDebugExtension")) {
			byte[] debugExtension = new byte[attributeLength];
			di.read(debugExtension);
			return new SourceDebugExtension(attributeNameIndex, attributeLength, debugExtension);
		}
		if (attrName.equals("LineNumberTable")) {
			int lineNumberTableLength = di.readUnsignedShort();
			LineNumberInfo[] lineNumberTable = new LineNumberInfo[lineNumberTableLength];
			for (int i = 0; i < lineNumberTableLength; i++) {
				int startPc = di.readUnsignedShort();
				int lineNumber = di.readUnsignedShort();
				lineNumberTable[i] = new LineNumberInfo(startPc, lineNumber);
			}
			return new LineNumberTable(attributeNameIndex, attributeLength, lineNumberTable);
		}
		if (attrName.equals("LocalVariableTable")) {
			int localVariableTableLength = di.readUnsignedShort();
			LocalVariableInfo[] localVariableTable = new LocalVariableInfo[localVariableTableLength];
			for (int i = 0; i < localVariableTableLength; i++) {
				int startPc = di.readUnsignedShort();
				int length = di.readUnsignedShort();
				int nameIndex = di.readUnsignedShort();
				int descriptorIndex = di.readUnsignedShort();
				int index = di.readUnsignedShort();
				localVariableTable[i] = new LocalVariableInfo(startPc, length, nameIndex, descriptorIndex, index);
			}
			return new LocalVariableTable(attributeNameIndex, attributeLength, localVariableTable);
		}
		if (attrName.equals("LocalVariableTypeTable")) {
			int localVariableTypeTableLength = di.readUnsignedShort();
			LocalVariableTypeInfo[] localVariableTypeTable = new LocalVariableTypeInfo[localVariableTypeTableLength];
			for (int i = 0; i < localVariableTypeTableLength; i++) {
				int startPc = di.readUnsignedShort();
				int length = di.readUnsignedShort();
				int nameIndex = di.readUnsignedShort();
				int signatureIndex = di.readUnsignedShort();
				int index = di.readUnsignedShort();
				localVariableTypeTable[i] = new LocalVariableTypeInfo(startPc, length, nameIndex, signatureIndex,
						index);
			}
			return new LocalVariableTypeTable(attributeNameIndex, attributeLength, localVariableTypeTable);
		}
		if (attrName.equals("Deprecated")) {
			return new Deprecated(attributeNameIndex, attributeLength);
		}
		if (attrName.equals("RuntimeVisibleAnnotations")) {
			AnnotationInfo[] annotations = parseAnnotationInfo(di);
			return new RuntimeVisibleAnnotations(attributeNameIndex, attributeLength, annotations);
		}
		if (attrName.equals("RuntimeInvisibleAnnotations")) {
			AnnotationInfo[] annotations = parseAnnotationInfo(di);
			return new RuntimeInvisibleAnnotations(attributeNameIndex, attributeLength, annotations);
		}
		if (attrName.equals("RuntimeVisibleParameterAnnotations")) {
			int numParameters = di.readUnsignedByte();
			ParameterAnnotations[] parameterAnnotations = new ParameterAnnotations[numParameters];
			for (int i = 0; i < numParameters; i++) {
				AnnotationInfo[] annotations = parseAnnotationInfo(di);
				parameterAnnotations[i] = new ParameterAnnotations(annotations);
			}
			return new RuntimeVisibleParameterAnnotations(attributeNameIndex, attributeLength, parameterAnnotations);
		}
		if (attrName.equals("RuntimeInvisibleParameterAnnotations")) {
			int numParameters = di.readUnsignedByte();
			ParameterAnnotations[] parameterAnnotations = new ParameterAnnotations[numParameters];
			for (int i = 0; i < numParameters; i++) {
				AnnotationInfo[] annotations = parseAnnotationInfo(di);
				parameterAnnotations[i] = new ParameterAnnotations(annotations);
			}
			return new RuntimeInvisibleParameterAnnotations(attributeNameIndex, attributeLength, parameterAnnotations);
		}
		if (attrName.equals("AnnotationDefault")) {
			ElementValue defaultValue = parseElementValue(di);
			return new AnnotationDefault(attributeNameIndex, attributeLength, defaultValue);
		}
		if (attrName.equals("BootstrapMethods")) {
			int numBootstrapMethods = di.readUnsignedShort();
			BootstrapMethod[] bootstrapMethods = new BootstrapMethod[numBootstrapMethods];
			for (int i = 0; i < numBootstrapMethods; i++) {
				int bootstrapMethodRef = di.readUnsignedShort();
				int numBootstrapArguments = di.readUnsignedShort();
				int[] bootstrapArguments = new int[numBootstrapArguments];
				for (int j = 0; j < numBootstrapArguments; j++) {
					bootstrapArguments[i] = di.readUnsignedShort();
				}
				bootstrapMethods[i] = new BootstrapMethod(bootstrapMethodRef, bootstrapArguments);
			}
			return new BootstrapMethods(attributeNameIndex, attributeLength, bootstrapMethods);
		}
		return null;
	}

	private static Code.ExceptionTable[] parseExceptionTables(DataInputStream di) throws IOException {
		int exceptionTableLength = di.readUnsignedShort();
		Code.ExceptionTable[] exceptionTables = new Code.ExceptionTable[exceptionTableLength];
		for (int i = 0; i < exceptionTableLength; i++) {
			int startPc = di.readUnsignedShort();
			int endPc = di.readUnsignedShort();
			int handlerPc = di.readUnsignedShort();
			int catchType = di.readUnsignedShort();
			exceptionTables[i] = new Code.ExceptionTable(startPc, endPc, handlerPc, catchType);
		}
		return exceptionTables;
	}

	private static StackMapFrame[] parseStackMapFrame(DataInputStream di) throws IOException {
		int numberOfEntries = di.readUnsignedShort();
		StackMapFrame[] entries = new StackMapFrame[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++) {
			int frameType = di.readUnsignedByte();
			int offsetDelta = 0;
			VerificationTypeInfo[] locals = null;
			VerificationTypeInfo[] stackItems = null;
			if (frameType >= 0 && frameType <= 63) {
				// 无其他属性
				offsetDelta = frameType;
			} else if (frameType <= 127) {
				offsetDelta = frameType - 64;
				stackItems = parseVerificationTypeInfo(1, di);
			} else if (frameType <= 246) {
				// 保留
			} else if (frameType == 247) {
				offsetDelta = di.readUnsignedShort();
				stackItems = parseVerificationTypeInfo(1, di);
			} else if (frameType <= 250) {
				offsetDelta = di.readUnsignedShort();
			} else if (frameType == 251) {
				offsetDelta = di.readUnsignedShort();
			} else if (frameType <= 254) {
				offsetDelta = di.readUnsignedShort();
				locals = parseVerificationTypeInfo(frameType - 251, di);
			} else if (frameType == 255){
				offsetDelta = di.readUnsignedShort();
				locals = parseVerificationTypeInfo(di.readUnsignedShort(), di);
				stackItems = parseVerificationTypeInfo(di.readUnsignedShort(), di);
			}
			entries[i] = new StackMapFrame(frameType, offsetDelta, locals,stackItems);
		}
		return entries;
	}

	private static VerificationTypeInfo[] parseVerificationTypeInfo(int count, DataInputStream di) throws IOException {
		VerificationTypeInfo[] locals = new VerificationTypeInfo[count];
		for (int i = 0; i < count; i++) {
			int tag = di.readUnsignedByte();
			int cpoolIndex = 0;
			int offset = 0;
			if (tag == 7) {
				cpoolIndex = di.readUnsignedShort();
			} else if (tag == 8) {
				offset = di.readUnsignedShort();
			}
			locals[i] = new VerificationTypeInfo(tag, cpoolIndex, offset);
		}
		return locals;
	}

	private static AnnotationInfo[] parseAnnotationInfo(DataInputStream di) throws IOException {
		int numAnnotations = di.readUnsignedShort();
		AnnotationInfo[] annotations = new AnnotationInfo[numAnnotations];
		for (int i = 0; i < numAnnotations; i++) {
			int typeIndex = di.readUnsignedShort();
			ElementValuePairs[] elementValuePairs = parseElementValuePairs(di);
			annotations[i] = new AnnotationInfo(typeIndex, elementValuePairs);
		}
		return annotations;
	}

	private static ElementValue parseElementValue(DataInputStream di) throws IOException {
		char tag = (char) di.readUnsignedByte();
		int constValueIndex = 0;
		int classInfoIndex = 0;
		EnumConstValue enumConstValue = null;
		AnnotationInfo annotationValue = null;
		ElementValue[] arrayValue = null;
		if (tag == ElementValue.TAG_ARR) {
			int numValues = di.readUnsignedShort();
			arrayValue = new ElementValue[numValues];
			for (int i = 0; i < numValues; i++) {
				arrayValue[i] = parseElementValue(di);
			}
		} else if (tag == ElementValue.TAG_ANN) {
			int typeIndex = di.readUnsignedShort();
			ElementValuePairs[] elementValuePairs = parseElementValuePairs(di);
			annotationValue = new AnnotationInfo(typeIndex, elementValuePairs);
		} else if (tag == ElementValue.TAG_CC) {
			classInfoIndex = di.readUnsignedShort();
		} else if (tag == ElementValue.TAG_EE) {
			int typeNameIndex = di.readUnsignedShort();
			int constNameIndex = di.readUnsignedShort();
			enumConstValue = new EnumConstValue(typeNameIndex, constNameIndex);
		} else {
			constValueIndex = di.readUnsignedShort();
		}
		return new ElementValue(tag, constValueIndex, enumConstValue, classInfoIndex, annotationValue, arrayValue);
	}

	private static ElementValuePairs[] parseElementValuePairs(DataInputStream di) throws IOException {
		int numElementValuePairs = di.readUnsignedShort();
		ElementValuePairs[] elementValuePairs = new ElementValuePairs[numElementValuePairs];
		for (int i = 0; i < numElementValuePairs; i++) {
			int elementNameIndex = di.readUnsignedShort();
			ElementValue value = parseElementValue(di);
			elementValuePairs[i] = new ElementValuePairs(elementNameIndex, value);
		}
		return elementValuePairs;
	}
}
