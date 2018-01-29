package com.jt.parser;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.jt.parser.classInfo.ClassAccessFlags;
import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.ClassInfoDisplay;

public class ClassFileParser {
	
	public static ClassInfo parseClassFile(String pathToFile) throws FileNotFoundException, IOException{
		FileInputStream file = new FileInputStream(pathToFile);
		return parseClassFile(file);
	}
	
	public static ClassInfo parseClassFile(InputStream is) throws IOException{
		DataInputStream di = new DataInputStream(is);
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
		ClassInfoDisplay.display(classInfo);
		di.close();
		return classInfo;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		InputStream is = ClassLoader.getSystemResourceAsStream("com/jt/test/TestAnnotation.class");
		System.out.println(is.available());
//		String classFile = "/Users/xieliqi/git/JvmToy/target/classes/com/jt/test/TestClass.class";
		ClassFileParser.parseClassFile(is);
	}
	
}
