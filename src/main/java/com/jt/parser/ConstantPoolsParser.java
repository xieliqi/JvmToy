package com.jt.parser;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jt.parser.classInfo.constantpool.ConstantClass;
import com.jt.parser.classInfo.constantpool.ConstantDouble;
import com.jt.parser.classInfo.constantpool.ConstantFieldRef;
import com.jt.parser.classInfo.constantpool.ConstantFloat;
import com.jt.parser.classInfo.constantpool.ConstantInteger;
import com.jt.parser.classInfo.constantpool.ConstantInterfaceMethodRef;
import com.jt.parser.classInfo.constantpool.ConstantInvokeDynamic;
import com.jt.parser.classInfo.constantpool.ConstantLong;
import com.jt.parser.classInfo.constantpool.ConstantMethodHandle;
import com.jt.parser.classInfo.constantpool.ConstantMethodRef;
import com.jt.parser.classInfo.constantpool.ConstantMethodType;
import com.jt.parser.classInfo.constantpool.ConstantNameAndType;
import com.jt.parser.classInfo.constantpool.ConstantPools;
import com.jt.parser.classInfo.constantpool.ConstantString;
import com.jt.parser.classInfo.constantpool.ConstantTag;
import com.jt.parser.classInfo.constantpool.ConstantUtf8;

public class ConstantPoolsParser {

	private final static Map<Integer, String> TAG_MAP = new HashMap<Integer, String>(14);
	static {
		TAG_MAP.put(1, "CONSTANT_Utf8");
		TAG_MAP.put(3, "CONSTANT_Integer");
		TAG_MAP.put(4, "CONSTANT_Float");
		TAG_MAP.put(5, "CONSTANT_Long");
		TAG_MAP.put(6, "CONSTANT_Double");
		TAG_MAP.put(7, "CONSTANT_Class");
		TAG_MAP.put(8, "CONSTANT_String");
		TAG_MAP.put(9, "CONSTANT_Fieldref");
		TAG_MAP.put(10, "CONSTANT_Methodref");
		TAG_MAP.put(11, "CONSTANT_InterfaceMethodref");
		TAG_MAP.put(12, "CONSTANT_NameAndType");
		TAG_MAP.put(15, "CONSTANT_MethodHandle");
		TAG_MAP.put(16, "CONSTANT_MethodType");
		TAG_MAP.put(18, "CONSTANT_InvokeDynamic");
	}

	public static ConstantPools parse(DataInputStream di) throws IOException {
		int count = di.readUnsignedShort();
		ConstantTag[] poolInfos = new ConstantTag[count];
		for (int i = 1; i < count;) {
			int tag = di.readUnsignedByte();
			ConstantTag constant = parseTag(tag, di);
			poolInfos[i] = constant;
			i += constant.getSlot();
		}
		return new ConstantPools(poolInfos);
	}

	private static ConstantTag parseTag(int tag, DataInputStream di) throws IOException {
		switch (tag) {
		case 1:
			return new ConstantUtf8(tag, di.readUTF());
		case 3:
			return new ConstantInteger(tag, di.readInt());
		case 4:
			return new ConstantFloat(tag, di.readFloat());
		case 5:
			return new ConstantLong(tag, di.readLong());
		case 6:
			return new ConstantDouble(tag, di.readDouble());
		case 7:
			return new ConstantClass(tag, di.readUnsignedShort());
		case 8:
			return new ConstantString(tag, di.readUnsignedShort());
		case 9:
			return new ConstantFieldRef(tag, di.readUnsignedShort(), di.readUnsignedShort());
		case 10:
			return new ConstantMethodRef(tag, di.readUnsignedShort(), di.readUnsignedShort());
		case 11:
			return new ConstantInterfaceMethodRef(tag, di.readUnsignedShort(), di.readUnsignedShort());
		case 12:
			return new ConstantNameAndType(tag, di.readUnsignedShort(), di.readUnsignedShort());
		case 15:
			return new ConstantMethodHandle(tag, di.readUnsignedByte(), di.readUnsignedShort());
		case 16:
			return new ConstantMethodType(tag, di.readUnsignedShort());
		case 18:
			return new ConstantInvokeDynamic(tag, di.readUnsignedShort(), di.readUnsignedShort());
		default:
			throw new IllegalArgumentException("unkonown constant tag[" + tag + "]!");
		}
	}

}
