package com.jt.parser;

import java.io.DataInputStream;
import java.io.IOException;

import com.jt.parser.classInfo.Interfaces;

public class InterfacesParser {

	public static Interfaces parse(DataInputStream di) throws IOException {
		int count = di.readUnsignedShort();
		int[] interfaces = new int[count];
		for (int i = 0; i < count; i++) {
			interfaces[i] = di.readUnsignedShort();
		}
		return new Interfaces(interfaces);
	}
}
