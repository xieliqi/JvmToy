package com.jt.decompile.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.jt.constant.Types;
import com.jt.decompile.AnnotationInfoDisplay;
import com.jt.parser.classInfo.attributes.annotations.AnnotationInfo;
import com.jt.parser.classInfo.attributes.annotations.ElementValue;
import com.jt.parser.classInfo.attributes.annotations.ElementValue.EnumConstValue;
import com.jt.parser.classInfo.attributes.annotations.ElementValuePairs;
import com.jt.parser.classInfo.constantpool.ConstantInteger;

public class AnnotationInfoBuilder {
	
	public static AnnotationInfoDisplay[] build(AnnotationInfo[] annotations){
		AnnotationInfoDisplay[] annoInfos = new AnnotationInfoDisplay[annotations.length];
		for (int i = 0; i < annotations.length; i++) {
			annoInfos[i] = convertAnnotation(annotations[i]);
		}
		return annoInfos;
	}
	
	public static AnnotationInfoDisplay convertAnnotation(AnnotationInfo anno){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		AnnotationInfoDisplay annoInfo = new AnnotationInfoDisplay();
		annoInfo.setClassName(Types.getJavaType(utils.getUtf8(anno .getTypeIndex())));
		Map<String, Object> pairMap = annoInfo.getValues();
		for (ElementValuePairs pair : anno.getElementValuePairs()) {
			String key = utils.getUtf8(pair.getElementNameIndex());
			Object value = convertElementValue(pair.getValue());
			pairMap.put(key, value);
		}
		return annoInfo;
	}
	
	public static Object convertElementValue(ElementValue value){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		String tag = String.valueOf(value.getTag());
		if(tag.equals("c")){
			String jvmType = utils.getUtf8(value.getClassInfoIndex());
			if(jvmType.equals("V")){
				return "Void";
			}
			return Types.getJavaType(jvmType);
		}else if(tag.equals("@")){
			return convertAnnotation(value.getAnnotationValue());
		}else if(tag.equals("[")){
			ElementValue[] array = value.getArrayValue();
			List<String> values = new ArrayList<String>(array.length);
			for (ElementValue e : array) {
				values.add((String)convertElementValue(e));
			}
			return "["+StringUtils.join(values,",")+"]";
		}else if(tag.equals("e")){
			EnumConstValue enumValue = value.getEnumConstValue();
			return Types.getJavaType(utils.getUtf8(enumValue.getTypeNameIndex()))+"."+utils.getUtf8(enumValue.getConstNameIndex());
		}else if(tag.equals("B") || tag.equals("I") || tag.equals("S") || tag.equals("D") || tag.equals("F") || tag.equals("J")||tag.equals("s")){
			return utils.getStringValue(value.getConstValueIndex());
		}else if(tag.equals("C")){
			ConstantInteger integer = (ConstantInteger)utils.getConstant(value.getConstValueIndex());
			return "'"+(char)integer.getValue()+"'";
		}else if(tag.equals("Z")){
			ConstantInteger integer = (ConstantInteger)utils.getConstant(value.getConstValueIndex());
			return integer.getValue()==0?"false":"true";
		}
		return null;
	}
	
}
