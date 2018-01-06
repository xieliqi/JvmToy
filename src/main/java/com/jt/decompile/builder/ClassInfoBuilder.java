package com.jt.decompile.builder;

import com.jt.decompile.ClassInfoDisplay;
import com.jt.parser.classInfo.ClassAccessFlags;
import com.jt.parser.classInfo.ClassInfo;

public class ClassInfoBuilder {
	
	public static ClassInfoDisplay buildClassInfo(ClassInfo classInfo){
		ClassInfoUtils.holder.set(classInfo);
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		ClassInfoDisplay classInfoDisplay = new ClassInfoDisplay();
		classInfoDisplay.setClassName(utils.getClassName(classInfo.getThisClass()));
		classInfoDisplay.setSuperClass(utils.getClassName(classInfo.getSuperClass()));
		classInfoDisplay.setInterfaces(utils.getClassNames(classInfo.getInterfaces().getInterfaces()));
		classInfoDisplay.setAccessFlags(classInfo.getAccessFlags().getAccessFlagInfo());
		classInfoDisplay.setType(getType(classInfo));
//		classInfoDisplay.setImportClasses(importClasses);
//		classInfoDisplay.setInnerClasses(innerClasses);
		classInfoDisplay.setFields(FieldInfoBuilder.build(classInfo));
		classInfoDisplay.setMethods(MethodInfoBuilder.build(classInfo));

		return classInfoDisplay;
	}
	
	private static int getType(ClassInfo classInfo){
		int type = ClassInfoDisplay.TYPE_CLASS;
		ClassAccessFlags flags = classInfo.getAccessFlags();
		if(flags.isAnnotation()){
			type = ClassInfoDisplay.TYPE_ANNOTATION;
		}else if(flags.isEnum()){
			type = ClassInfoDisplay.TYPE_ENUM;
		}else if(flags.isInterface()){
			type = ClassInfoDisplay.TYPE_INTERFACE;
		}
		return type;
	}
	
}
