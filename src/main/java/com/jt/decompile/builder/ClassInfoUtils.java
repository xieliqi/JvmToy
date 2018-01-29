package com.jt.decompile.builder;

import com.jt.parser.classInfo.ClassInfo;
import com.jt.parser.classInfo.constantpool.ConstantClass;
import com.jt.parser.classInfo.constantpool.ConstantDouble;
import com.jt.parser.classInfo.constantpool.ConstantFloat;
import com.jt.parser.classInfo.constantpool.ConstantInteger;
import com.jt.parser.classInfo.constantpool.ConstantLong;
import com.jt.parser.classInfo.constantpool.ConstantString;
import com.jt.parser.classInfo.constantpool.ConstantTag;
import com.jt.parser.classInfo.constantpool.ConstantUtf8;

public class ClassInfoUtils{
	
	public static ThreadLocal<ClassInfo> holder = new ThreadLocal<ClassInfo>();
	
	public static ClassInfoUtils getUtils(){
		ClassInfo ci = holder.get();
		if(ci==null){
			throw new IllegalArgumentException("ClassInfo not set!");
		}
		return new ClassInfoUtils(ci);
	}
	
	private ClassInfo classInfo;
	
	private ClassInfoUtils(ClassInfo classInfo){
		this.classInfo = classInfo;
	}
	
	public ConstantTag getConstant(int index){
		return classInfo.getConstantPools().getPoolInfos()[index];
	}
	
	public String getStringValue(int index){
		ConstantTag constant = getConstant(index);
		if(constant instanceof ConstantInteger){
			ConstantInteger integer = (ConstantInteger)constant;
			return integer.getValue()+"";
		}else if(constant instanceof ConstantDouble){
			ConstantDouble d = (ConstantDouble)constant;
			return d.getValue()+"D";
		}else if(constant instanceof ConstantFloat){
			ConstantFloat f = (ConstantFloat)constant;
			return f.getValue()+"F";
		}else if(constant instanceof ConstantLong){
			ConstantLong l = (ConstantLong)constant;
			return l.getValue()+"L";
		}else if(constant instanceof ConstantString){
			ConstantString s = (ConstantString)constant;
			return "\""+getUtf8(s.getStringIndex())+"\"";
		}else if(constant instanceof ConstantUtf8){
			ConstantUtf8 s = (ConstantUtf8)constant;
			return "\""+s.getValue()+"\"";
		}
		return null;
	}
	
	public String[] getClassNames(int[] indexes){
		String[] clss = new String[indexes.length];
		if(indexes.length>0){
			for (int i = 0; i < indexes.length;i++) {
				clss[i] = getClassName(indexes[i]);
			}
		}
		return clss;
	}
	
	public String getClassName(int index){
		if(index==0){
			return "";
		}
		ConstantTag[] constants = classInfo.getConstantPools().getPoolInfos();
		ConstantTag c = constants[index];
		int nameIndex = ((ConstantClass)c).getNameIndex();
		return getUtf8(nameIndex).replace('/', '.');
	}
	
	public String getUtf8(int index){
		ConstantTag[] constants = classInfo.getConstantPools().getPoolInfos();
		ConstantTag c = constants[index];
		return ((ConstantUtf8)c).getValue();
	}

}
