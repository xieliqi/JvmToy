package com.jt.parser;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.jt.parser.classInfo.ClassAccessFlags;
import com.jt.parser.classInfo.ClassInfo;

public class ClassFileParser {
	
	public static ClassInfo parseClassFile(String pathToFile) throws FileNotFoundException, IOException{
		FileInputStream file = new FileInputStream(pathToFile);
		DataInputStream di = new DataInputStream(file);
		ClassInfo classInfo = new ClassInfo();
		classInfo.setMagic(Integer.toHexString(di.readInt()).toUpperCase());
		classInfo.setMinorVersion(di.readUnsignedShort());
		classInfo.setMajorVersion(di.readUnsignedShort());
		classInfo.setConstantPools(ConstantPoolsParser.parse(di));
		classInfo.setAccessFlags(new ClassAccessFlags(di.readUnsignedShort()));
		classInfo.setThisClass(di.readUnsignedShort());
		classInfo.setSuperClass(di.readUnsignedShort());
		classInfo.setInterfaces(InterfacesParser.parse(di));
		classInfo.setFields(FieldsParser.parse(classInfo,di));
		classInfo.setMethods(MethodsParser.parse(classInfo,di));
		classInfo.setAttributes(AttributesParser.parse(classInfo,di));
		di.close();
		return classInfo;
	}
	
}
