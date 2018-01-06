package com.jt.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Types {

	public final static HashMap<String, String> TYPE_MAP;
	static {
		TYPE_MAP = new HashMap<String, String>();
		TYPE_MAP.put("B", "byte");
		TYPE_MAP.put("C", "char");
		TYPE_MAP.put("D", "double");
		TYPE_MAP.put("F", "float");
		TYPE_MAP.put("I", "int");
		TYPE_MAP.put("J", "long");
		TYPE_MAP.put("S", "short");
		TYPE_MAP.put("Z", "boolean");
		TYPE_MAP.put("V", "void");
	}

	public static String getJavaType(String jvmType) {
		String fullTypeName = "";
		while (jvmType.startsWith("[")) {
			fullTypeName += "[]";
			jvmType = jvmType.substring(1, jvmType.length());
		}
		if (jvmType.startsWith("L")) {
			// 处理泛型情况
			jvmType = getComplexJavaType(jvmType);
			jvmType = jvmType.replace('/', '.');
			fullTypeName = jvmType + fullTypeName;
		} else {
			fullTypeName = TYPE_MAP.get(jvmType) + fullTypeName;
		}
		return fullTypeName;
	}

	private static String getComplexJavaType(String jvmType) {
		String temp = "";
		int endIndex = 1;
		int startIndex = endIndex;
		while (endIndex < jvmType.length()) {
			if (jvmType.charAt(endIndex) == '<') {
				temp = jvmType.substring(startIndex, endIndex);
				temp += "<" + getJavaType(jvmType.substring(endIndex+1, jvmType.length())) + ">";
				break;
			} else if (jvmType.charAt(endIndex) == ';') {
				temp = jvmType.substring(startIndex, endIndex);
				break;
			}
			endIndex++;
		}
		return temp;
	}
	
	public static List<String> spiltJvmTypes(String types){
		List<String> typeList = new ArrayList<String>();
		String type = "";
		while(types.length()>0){
			if(types.startsWith("[")){
				type = getArr(types);
			}else if(types.startsWith("L")){
				type = getObject(types);
			}else {
				type = types.charAt(0)+"";
			}
			typeList.add(type);
			types = types.substring(type.length());
		}
		return typeList;
	}
	
	private static String getArr(String types){
		int index = 0;
		String type = "";
		while(types.charAt(index)=='['){
			index++;
		}
		if(types.charAt(index)=='L'){
			index += getObject(types.substring(index, types.length())).length();
		}else{
			index += 1;
		}
		type = types.substring(0, index);
		return type;
	}
	
	private static String getObject(String types){
		if(!types.startsWith("L")){
			return "";
		}
		int index = 1;
		int mathchLCount = 1;
		boolean isSpilt = true;
		while(mathchLCount > 0 && index < types.length()){
			char c = types.charAt(index);
			if(c==';'){
				mathchLCount--;
			}else if(isSpilt && c=='L'){
				mathchLCount++;
			}
			isSpilt = c=='<' || c=='[';
			index++;
		}
		if(types.length()==index){
			return types;
		}
		return types.substring(0, index);
	}

	public static void main(String[] args) {
		System.out.println(spiltJvmTypes("[[Ljava/util/List;Ljava/util/List<Ljava/util/List<Ljava/util/List<[Ljava/lang/String;>;>;>;IB"));

		System.out.println(getJavaType("Ljava/util/List<Ljava/util/List<Ljava/util/List<[Ljava/lang/String;>;>;>;"));
	}
	

}
