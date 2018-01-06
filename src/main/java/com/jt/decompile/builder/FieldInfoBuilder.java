package com.jt.decompile.builder;

import com.jt.constant.Types;
import com.jt.decompile.FieldInfoDisplay;
import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.FieldInfo;
import com.jt.parser.classInfo.attributes.AbstractAttribute;
import com.jt.parser.classInfo.attributes.ConstantValue;
import com.jt.parser.classInfo.attributes.Deprecated;
import com.jt.parser.classInfo.attributes.RuntimeInvisibleAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeVisibleAnnotations;
import com.jt.parser.classInfo.attributes.Signature;

public class FieldInfoBuilder {
	
	public static FieldInfoDisplay[] build(ClassInfo classInfo){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		FieldInfo[] fields = classInfo.getFields().getFields();
		int length = fields.length;
		FieldInfoDisplay[] fieldInfos = new FieldInfoDisplay[length];
		for (int i = 0; i < length; i++) {
			FieldInfo field = fields[i];
			if(!field.isSynthetic()){
				FieldInfoDisplay fieldInfo = new FieldInfoDisplay();
				fieldInfo.setFieldName(utils.getUtf8(field.getNameIndex()));
				fieldInfo.setFieldType(Types.getJavaType(utils.getUtf8(field.getDescriptorIndex())));
				String fieldValue = "";
				fieldInfo.setFieldValue(fieldValue);
				fieldInfo.setAccessFlags(field.getAccessFlags().getAccessFlagInfo());
				convertAttributes(fieldInfo, field);
				fieldInfos[i] = fieldInfo;
			}
		}
		return fieldInfos;
	}
	
	private static void convertAttributes(FieldInfoDisplay fieldInfo,FieldInfo field){
		AbstractAttribute[] attrs = field.getAttributes().getAttributes();
		for (AbstractAttribute attr : attrs) {
			if(attr instanceof ConstantValue){
				fieldInfo.setFieldValue(AttributeUtils.getConstantValue((ConstantValue)attr));
			}else if(attr instanceof Signature){
				fieldInfo.setFieldType(AttributeUtils.getSignature((Signature)attr));
			}else if(attr instanceof Deprecated){
				fieldInfo.setDeprecated(true);
			}else if(attr instanceof RuntimeVisibleAnnotations){
				fieldInfo.setRuntimeVisibleAnnotations(AttributeUtils.getRuntimeVisibleAnnotations((RuntimeVisibleAnnotations)attr));
			}else if(attr instanceof RuntimeInvisibleAnnotations){
				fieldInfo.setRuntimeInvisibleAnnotations(AttributeUtils.getRuntimeInvisibleAnnotations((RuntimeInvisibleAnnotations)attr));
			}
		}
	}
	
}
