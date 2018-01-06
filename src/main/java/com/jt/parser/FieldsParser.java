package com.jt.parser;

import java.io.DataInputStream;
import java.io.IOException;

import com.jt.parser.classInfo.Attributes;
import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.FieldInfo;
import com.jt.parser.classInfo.Fields;

public class FieldsParser {

	public static Fields parse(ClassInfo classInfo, DataInputStream di) throws IOException {
		int count = di.readUnsignedShort();
		FieldInfo[] fields = new FieldInfo[count];
		for (int i = 0; i < count; i++) {
			int flags = di.readUnsignedShort();
			int nameIndex = di.readUnsignedShort();
			int descriptorIndex = di.readUnsignedShort();
			Attributes attributes = AttributesParser.parse(classInfo, di);
			fields[i] = new FieldInfo(flags, nameIndex, descriptorIndex, attributes);
		}
		return new Fields(fields);
	}

}
