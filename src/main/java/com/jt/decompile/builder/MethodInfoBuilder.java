package com.jt.decompile.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jt.constant.OpCodes;
import com.jt.constant.Types;
import com.jt.decompile.CodeInfoDisplay;
import com.jt.decompile.MethodInfoDisplay;
import com.jt.decompile.ParamInfoDisplay;
import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.MethodAccessFlags;
import com.jt.parser.classInfo.MethodInfo;
import com.jt.parser.classInfo.attributes.AbstractAttribute;
import com.jt.parser.classInfo.attributes.AnnotationDefault;
import com.jt.parser.classInfo.attributes.Code;
import com.jt.parser.classInfo.attributes.Deprecated;
import com.jt.parser.classInfo.attributes.Exceptions;
import com.jt.parser.classInfo.attributes.RuntimeInvisibleAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeInvisibleParameterAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeVisibleAnnotations;
import com.jt.parser.classInfo.attributes.RuntimeVisibleParameterAnnotations;
import com.jt.parser.classInfo.attributes.Signature;

public class MethodInfoBuilder {

	public static MethodInfoDisplay[] build(ClassInfo classInfo) {
		ClassInfoUtils utils = ClassInfoUtils.getUtils();
		MethodInfo[] methods = classInfo.getMethods().getMethods();
		int length = methods.length;
		MethodInfoDisplay[] methodInfos = new MethodInfoDisplay[length];
		for (int i = 0; i < length; i++) {
			MethodInfo method = methods[i];
			String methodName = utils.getUtf8(method.getNameIndex());
			if (methodName.equals("<init>")) {
				continue;
			}
			MethodAccessFlags flags = method.getAccessFlags();
			if (flags.isBridge() || flags.isSynthetic()) {
				continue;
			}
			MethodInfoDisplay methodInfo = new MethodInfoDisplay();
			methodInfo.setMethodName(methodName);
			methodInfo.setAccessFlags(flags.getAccessFlagInfo());
			methodInfo.setAbstract(flags.isAbstract());
			methodInfo.setNative(flags.isNative());
			getReturnTypeAndParams(methodInfo, utils.getUtf8(method.getDescriptorIndex()));
			convertAttributes(methodInfo, method);
			methodInfos[i] = methodInfo;
		}
		return methodInfos;
	}

	private static void getReturnTypeAndParams(MethodInfoDisplay methodInfo, String des) {
		String[] strs = des.split("\\)");
		// params
		strs[0] = strs[0].substring(1);
		if (StringUtils.isNotBlank(strs[0])) {
			List<String> params = Types.spiltJvmTypes(strs[0]);
			ParamInfoDisplay[] paramArr = new ParamInfoDisplay[params.size()];
			for (int i = 0; i < params.size(); i++) {
				ParamInfoDisplay paramInfo = new ParamInfoDisplay();
				paramInfo.setName("arg" + (i + 1));
				paramInfo.setType(Types.getJavaType(params.get(i)));
				paramArr[i] = paramInfo;
			}
			methodInfo.setParams(paramArr);
		}
		// return type
		methodInfo.setReturnType(Types.getJavaType(strs[1]));
	}

	private static void convertAttributes(MethodInfoDisplay methodInfo, MethodInfo method) {
		AbstractAttribute[] attrs = method.getAttributes().getAttributes();
		for (AbstractAttribute attr : attrs) {
			if (attr instanceof Code) {
				Code code = (Code) attr;
				code.getExceptionTables();
				parseCodes(methodInfo, code.getCodes());
				code.getAttributes();
			} else if (attr instanceof Exceptions) {
				methodInfo.setExceptions(AttributeUtils.getExceptions((Exceptions) attr));
			} else if (attr instanceof Signature) {
				getReturnTypeAndParams(methodInfo, AttributeUtils.getOriginalSignature((Signature) attr));
			} else if (attr instanceof Deprecated) {
				methodInfo.setDeprecated(true);
			} else if (attr instanceof RuntimeVisibleAnnotations) {
				methodInfo.setRuntimeVisibleAnnotations(
						AttributeUtils.getRuntimeVisibleAnnotations((RuntimeVisibleAnnotations) attr));
			} else if (attr instanceof RuntimeInvisibleAnnotations) {
				methodInfo.setRuntimeInvisibleAnnotations(
						AttributeUtils.getRuntimeInvisibleAnnotations((RuntimeInvisibleAnnotations) attr));
			} else if (attr instanceof RuntimeVisibleParameterAnnotations) {
				RuntimeVisibleParameterAnnotations pa = (RuntimeVisibleParameterAnnotations) attr;
				for (int i = 0; i < pa.getParameterAnnotations().length; i++) {
					methodInfo.getParams()[i].setRuntimeVisibleAnnotations(
							AnnotationInfoBuilder.build(pa.getParameterAnnotations()[i].getAnnotations()));
				}
			} else if (attr instanceof RuntimeInvisibleParameterAnnotations) {
				RuntimeInvisibleParameterAnnotations pa = (RuntimeInvisibleParameterAnnotations) attr;
				for (int i = 0; i < pa.getParameterAnnotations().length; i++) {
					methodInfo.getParams()[i].setRuntimeInvisibleAnnotations(
							AnnotationInfoBuilder.build(pa.getParameterAnnotations()[i].getAnnotations()));
				}
			} else if (attr instanceof AnnotationDefault) {
				System.out.println(attr);
				// AnnotationInfoBuilder.convertElementValue(((AnnotationDefault)
				// attr).getDefaultValue());
			}
		}
	}

	private static void parseCodes(MethodInfoDisplay methodInfo, byte[] codes) {
		List<CodeInfoDisplay> codeInfoList = new ArrayList<CodeInfoDisplay>();
		int index = 0;
		while (index < codes.length) {
			CodeInfoDisplay ci = new CodeInfoDisplay();
			int op = 0xff&(codes[index++]);
			ci.setOp(op);
			if (OpCodes.getNoOfOperands(op) > 0) {
				int otCount = (int)OpCodes.getOperandTypeCount(op);
				ci.setPs(new int[otCount]);
				ci.setPts(new short[otCount]);
				for (int i = 0; i < otCount; i++) {
					short type = OpCodes.getOperandType(op, i);
					ci.getPts()[i] = type;
					if(type==OpCodes.T_BYTE){
						ci.getPs()[i] = codes[index++];
					}else if(type==OpCodes.T_SHORT){
						ci.getPs()[i] = (short)(codes[index++] << 8) + (codes[index++] << 0);
					}else if(type==OpCodes.T_INT){
						ci.getPs()[i] = (int)((codes[index++] << 24) + (codes[index++] << 16) + (codes[index++] << 8) + (codes[index++] << 0));
					}
				}
			}
			codeInfoList.add(ci);
		}
		methodInfo.setCodes(codeInfoList);
	}

}
