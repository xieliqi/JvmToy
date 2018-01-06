package com.jt.parser.classInfo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ClassAccessFlags {

	private final int MASK_PUBLIC = 0x0001;    // 0000 0000 0000 0001
	private final int MASK_FINAL = 0x0010;     // 0000 0000 0001 0000
	private final int MASK_SUPER = 0x0020;     // 0000 0000 0010 0000
	private final int MASK_INTERFACE = 0x0200; // 0000 0010 0000 0000
	private final int MASK_ABSTRACT = 0x0400;  // 0000 0100 0000 0000
	private final int MASK_SYNTHETIC = 0x1000; // 0001 0000 0000 0000
	private final int MASK_ANNOTATION = 0x2000;// 0010 0000 0000 0000
	private final int MASK_ENUM = 0x4000;      // 0100 0000 0000 0000

	private int flags;

	public ClassAccessFlags(int flags) {
		this.flags = flags;
	}
	
	public Set<String> getAccessFlagInfo(){
		Set<String> flags = new LinkedHashSet<String>();
		if(isPublic()){
			flags.add("public");
		}
		if(isInterface()){
			flags.add("interface");
		}else if(isEnum()){
			flags.add("enum");
		}else if(isAnnotation()){
			flags.add("@interface");
		}else{
			if(isFinal()){
				flags.add("final");
			}
			if(isAbstract()){
				flags.add("abstract");
			}
			flags.add("class");
		}
		return flags;
	}
	
	public boolean isPublic() {
		return (flags & MASK_PUBLIC) == MASK_PUBLIC;
	}

	public boolean isFinal() {
		return (flags & MASK_FINAL) == MASK_FINAL;
	}

	public boolean isSuper() {
		return (flags & MASK_SUPER) == MASK_SUPER;
	}

	public boolean isInterface() {
		return (flags & MASK_INTERFACE) == MASK_INTERFACE;
	}

	public boolean isAbstract() {
		return (flags & MASK_ABSTRACT) == MASK_ABSTRACT;
	}

	public boolean isSynthetic() {
		return (flags & MASK_SYNTHETIC) == MASK_SYNTHETIC;
	}

	public boolean isAnnotation() {
		return (flags & MASK_ANNOTATION) == MASK_ANNOTATION;
	}

	public boolean isEnum() {
		return (flags & MASK_ENUM) == MASK_ENUM;
	}

	@Override
	public String toString() {
		String str = "";
		if(isPublic()){
			str += "ACC_PUBLIC,";
		}
		if(isFinal()){
			str += "ACC_FINAL,";
		}
		if(isSuper()){
			str += "ACC_SUPER,";
		}
		if(isInterface()){
			str += "ACC_INTERFACE,";
		}
		if(isAbstract()){
			str += "ACC_ABSTRACT,";
		}
		if(isSynthetic()){
			str += "ACC_SYNTHETIC,";
		}
		if(isAnnotation()){
			str += "ACC_ANNOTATION,";
		}
		if(isEnum()){
			str += "ACC_ENUM,";
		}
		return str.substring(0, str.length()-1);
	}

}
