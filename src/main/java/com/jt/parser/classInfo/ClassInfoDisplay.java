package com.jt.parser.classInfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jt.decompile.builder.ClassInfoUtils;
import com.jt.parser.classInfo.attributes.AbstractAttribute;
import com.jt.parser.classInfo.constantpool.ConstantTag;

public class ClassInfoDisplay {
	
	public static void display(ClassInfo classInfo){
		ClassInfoUtils.holder.set(classInfo);
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		System.out.println("==========================");
		System.out.println("ThisClass:"+utils.getClassName(classInfo.getThisClass()));
		System.out.println("Magic:"+classInfo.getMagic());
		System.out.println("MinorVersion:"+classInfo.getMinorVersion());
		System.out.println("MajorVersion:"+classInfo.getMajorVersion());
		System.out.println("SuperClass:"+utils.getClassName(classInfo.getSuperClass()));
		System.out.println("Interfaces:"+StringUtils.join(interfaces(classInfo.getInterfaces().getInterfaces()),","));
		System.out.println("AccessFlags:"+classInfo.getAccessFlags().toString());
		System.out.println("ConstantPool:");
		constantPool(classInfo.getConstantPools().getPoolInfos());
		System.out.println("Fields:");
		fields("\t",classInfo.getFields().getFields());
		System.out.println("Methods:");
		methods("\t", classInfo.getMethods().getMethods());
		System.out.println("Attributes:");
		attributes("",classInfo.getAttributes().getAttributes());
	}
	
	private static List<String> interfaces(int[] interfaces){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		List<String> list = new ArrayList<String>();
		for (int i : interfaces) {
			list.add(utils.getClassName(i));
		}
		return list;
	}
	
	private static void constantPool(ConstantTag[] constantTags){
		for (int j = 1; j < constantTags.length; j++) {
			if(constantTags[j]!=null){
				System.out.println("\t#"+j+" = "+constantTags[j].toString());
			}
		}
	}
	
	private static void fields(String pre,FieldInfo[] fieldInfos){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		for (int j = 0; j < fieldInfos.length; j++) {
			FieldInfo fieldInfo = fieldInfos[j];
			System.out.println(pre+(j+1)+". "+utils.getUtf8(fieldInfo.getNameIndex())+" "+utils.getUtf8(fieldInfo.getDescriptorIndex()));
			System.out.println(pre+"\tAccessFlags:"+fieldInfo.getAccessFlags().toString());
			attributes(pre,fieldInfo.getAttributes().getAttributes());
		}
	}
	
	private static void methods(String pre,MethodInfo[] methodInfos){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		for (int j = 0; j < methodInfos.length; j++) {
			MethodInfo methodInfo = methodInfos[j];
			System.out.println(pre+(j+1)+". "+utils.getUtf8(methodInfo.getNameIndex())+" "+utils.getUtf8(methodInfo.getDescriptorIndex()));
			System.out.println(pre+"\tAccessFlags:"+methodInfo.getAccessFlags().toString());
			attributes(pre+"\t",methodInfo.getAttributes().getAttributes());
		}
	}
	
	private static void attributes(String pre,AbstractAttribute[] abstractAttributes){
		System.out.println(pre+"Attributes:");
		for (int i = 0; i < abstractAttributes.length; i++) {
			AbstractAttribute attr = abstractAttributes[i];
			System.out.println(pre+"\t"+(i+1)+". "+attr.toString());
		}
	}
}
