package com.jt.parser;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.ConstantPools;

public class ClassFileParser {
	
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("/Users/xieliqi/Works/workspaces2/xxx-log4j/target/classes/BasicModel.class");
		DataInputStream di = new DataInputStream(file);
		ClassInfo classInfo = new ClassInfo();
		classInfo.setMagic(Integer.toHexString(di.readInt()).toUpperCase());
		classInfo.setMinorVersion(Integer.toHexString(di.readUnsignedShort()).toUpperCase());
		classInfo.setMajorVersion(Integer.toHexString(di.readUnsignedShort()).toUpperCase());
		classInfo.setConstantPools(new ConstantPools(di));
		di.close();
		classInfo.display();
	}

}
