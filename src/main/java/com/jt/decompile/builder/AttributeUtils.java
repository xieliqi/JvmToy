package com.jt.decompile.builder;

import com.jt.constant.Types;
import com.jt.decompile.AnnotationInfoDisplay;
import com.jt.parser.classInfo.attributes.ConstantValue;
import com.jt.parser.classInfo.attributes.Exceptions;
import com.jt.parser.classInfo.attributes.RuntimeInvisibleAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeVisibleAnnotations;
import com.jt.parser.classInfo.attributes.Signature;

public class AttributeUtils {
	
	public static String getConstantValue(ConstantValue attr){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		return utils.getStringValue(attr.getConstantValueIndex());
	}
	
	public static String getOriginalSignature(Signature attr){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		String sign = utils.getUtf8(attr.getSignatureIndex());
		return sign;
	}
	
	public static String getSignature(Signature attr){
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		String sign = utils.getUtf8(attr.getSignatureIndex());
		return Types.getJavaType(sign);
	}
	
	public static AnnotationInfoDisplay[] getRuntimeVisibleAnnotations(RuntimeVisibleAnnotations attr){
		return AnnotationInfoBuilder.build(attr.getAnnotations());
	}
	
	public static AnnotationInfoDisplay[] getRuntimeInvisibleAnnotations(RuntimeInvisibleAnnotations attr){
		return AnnotationInfoBuilder.build(attr.getAnnotations());
	}

	public static String[] getExceptions(Exceptions attr) {
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		return utils.getClassNames(attr.getExceptionIndexTable());
	}

}
