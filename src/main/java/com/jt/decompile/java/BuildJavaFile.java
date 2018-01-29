package com.jt.decompile.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.jt.constant.OpCodes;
import com.jt.decompile.AnnotationInfoDisplay;
import com.jt.decompile.ClassInfoDisplay;
import com.jt.decompile.CodeInfoDisplay;
import com.jt.decompile.FieldInfoDisplay;
import com.jt.decompile.MethodInfoDisplay;
import com.jt.decompile.ParamInfoDisplay;
import com.jt.decompile.builder.ClassInfoBuilder;
import com.jt.parser.ClassFileParser;

public class BuildJavaFile {

	public static void display(ClassInfoDisplay classInfo) {
		System.out.println("package " + classInfo.getPackageInfo() + ";");
		newLine();
		String classTitle = StringUtils.join(classInfo.getAccessFlags(), " ") + " " + classInfo.getClassName();
		if (StringUtils.isNotBlank(classInfo.getSuperClass())) {
			classTitle += " extends " + classInfo.getSuperClass();
		}
		if (classInfo.getInterfaces().length > 0) {
			classTitle += " implements " + StringUtils.join(classInfo.getInterfaces(), ",");
		}
		newLine(classTitle);
		newLine("{");
		if (classInfo.getFields().length > 0) {
			newLine();
			for (FieldInfoDisplay field : classInfo.getFields()) {
				if (field.isDeprecated()) {
					newLine("\t" + "@Deprecated");
				}
				if (field.getRuntimeInvisibleAnnotations() != null) {
					for (AnnotationInfoDisplay anno : field.getRuntimeInvisibleAnnotations()) {
						newLine("\t" + getAnnotationJava(anno));
					}
				}
				if (field.getRuntimeVisibleAnnotations() != null) {
					for (AnnotationInfoDisplay anno : field.getRuntimeVisibleAnnotations()) {
						newLine("\t" + getAnnotationJava(anno));
					}
				}
				String fieldStr = "\t" + StringUtils.join(field.getAccessFlags(), " ");
				fieldStr += " " + field.getFieldType();
				fieldStr += " " + field.getFieldName();
				if (StringUtils.isNotBlank(field.getFieldValue())) {
					fieldStr += " = " + field.getFieldValue();
				}
				fieldStr += ";";
				newLine(fieldStr);
				newLine();
			}
		}
		if (classInfo.getMethods().length > 0) {
			newLine();
			for (MethodInfoDisplay method : classInfo.getMethods()) {
				if (method == null) {
					continue;
				}
				if (method.isDeprecated()) {
					newLine("\t" + "@Deprecated");
				}
				if (method.getRuntimeInvisibleAnnotations() != null) {
					for (AnnotationInfoDisplay anno : method.getRuntimeInvisibleAnnotations()) {
						newLine("\t" + getAnnotationJava(anno));
					}
				}
				if (method.getRuntimeVisibleAnnotations() != null) {
					for (AnnotationInfoDisplay anno : method.getRuntimeVisibleAnnotations()) {
						newLine("\t" + getAnnotationJava(anno));
					}
				}
				String methodStr = "\t" + StringUtils.join(method.getAccessFlags(), " ");
				methodStr += " " + method.getReturnType();
				methodStr += " " + method.getMethodName();
				methodStr += "(";
				// 参数
				ParamInfoDisplay[] parameters = method.getParams();
				if (parameters != null) {
					for (int i = 0; i < parameters.length; i++) {
						if (i != 0) {
							methodStr += ",";
						}
						if(parameters[i].getRuntimeInvisibleAnnotations()!=null){
							methodStr += StringUtils .join(getAnnotationJavas(parameters[i].getRuntimeInvisibleAnnotations()), "");
						}
						if(parameters[i].getRuntimeVisibleAnnotations()!=null){
							methodStr += StringUtils.join(getAnnotationJavas(parameters[i].getRuntimeVisibleAnnotations()), "");
						}
						methodStr += parameters[i].getType() + " " + parameters[i].getName();
					}
				}
				methodStr += ")";
				if (method.getExceptions() != null) {
					methodStr += " throws ";
					methodStr += StringUtils.join(method.getExceptions(), ",");
				}
				if (method.isAbstract() || method.isNative()) {
					newLine(methodStr + ";");
				} else {
					newLine(methodStr);
					newLine("\t" + "{");
					displayCodeBlock(method);
					newLine("\t" + "}");
				}
				newLine();
			}
		}
		newLine("}");
	}

	private static void newLine() {
		System.out.println();
	}

	private static void newLine(String str) {
		System.out.println(str);
	}

	private static String[] getAnnotationJavas(AnnotationInfoDisplay[] annos) {
		String[] strArr = new String[annos.length];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = getAnnotationJava(annos[i]);
		}
		return strArr;
	}

	private static String getAnnotationJava(AnnotationInfoDisplay anno) {
		String annoJava = "";
		annoJava += "@" + anno.getClassName();
		if (!anno.getValues().isEmpty()) {
			annoJava += "(";
		}
		for (Entry<String, Object> entry : anno.getValues().entrySet()) {
			annoJava += entry.getKey() + "=";
			if (entry.getValue() instanceof AnnotationInfoDisplay) {
				annoJava += getAnnotationJava((AnnotationInfoDisplay) entry.getValue());
			} else {
				annoJava += (String) entry.getValue();
			}
			annoJava += ",";
		}
		if (!anno.getValues().isEmpty()) {
			annoJava = annoJava.substring(0, annoJava.length() - 1);
			annoJava += ")";
		}
		return annoJava;
	}

	private static void displayCodeBlock(MethodInfoDisplay method) {
		for (CodeInfoDisplay code : method.getCodes()) {
			String codeLine = "\t\t";
			codeLine += OpCodes.getOpcodeName(code.getOp());
			if(code.getPs()!=null){
				for (int p : code.getPs()) {
					codeLine += " "+p; 
				}
			}
			System.out.println(codeLine);
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String classFile = "/Users/xieliqi/git/JvmToy/target/classes/com/jt/test/TestClass.class";
		ClassInfoDisplay classInfo = ClassInfoBuilder.buildClassInfo(ClassFileParser.parseClassFile(classFile));
		display(classInfo);
	}
}
