package com.jt.parser;

import java.io.DataInputStream;
import java.io.IOException;

import com.jt.parser.classInfo.Attributes;
import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.MethodInfo;
import com.jt.parser.classInfo.Methods;

public class MethodsParser {

	public static Methods parse(ClassInfo classInfo, DataInputStream di) throws IOException {
		int count = di.readUnsignedShort();
		MethodInfo[] methods = new MethodInfo[count];
		for (int i = 0; i < count; i++) {
			int flags = di.readUnsignedShort();
			int nameIndex = di.readUnsignedShort();
			int descriptorIndex = di.readUnsignedShort();
			Attributes attributes = AttributesParser.parse(classInfo,di);
			methods[i] = new MethodInfo(flags, nameIndex, descriptorIndex, attributes);
		}
		return new Methods(methods);
	}
	
}
