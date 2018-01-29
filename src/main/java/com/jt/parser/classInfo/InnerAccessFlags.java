package com.jt.parser.classInfo;

import java.util.LinkedHashSet;
import java.util.Set;

public class InnerAccessFlags {

	private final int MASK_PUBLIC = 0x0001;    // 0000 0000 0000 0001
	private final int MASK_PRIVATE = 0x0002;   // 0000 0000 0000 0010
	private final int MASK_PROTECTED = 0x0004; // 0000 0000 0000 0100
	private final int MASK_STATIC = 0x0008;    // 0000 0000 0000 1000
	private final int MASK_FINAL = 0x0010;     // 0000 0000 0001 0000
	private final int MASK_INTERFACE = 0x0200; // 0000 0010 0000 0000
	private final int MASK_ABSTRACT = 0x0400;  // 0000 0100 0000 0000
	private final int MASK_SYNTHETIC = 0x1000; // 0001 0000 0000 0000
	private final int MASK_ANNOTATION = 0x2000;// 0010 0000 0000 0000
	private final int MASK_ENUM = 0x4000;      // 0100 0000 0000 0000

	private int flags;

	public InnerAccessFlags(int flags) {
		this.flags = flags;
	}
	
	public Set<String> getAccessFlagInfo(){
		Set<String> flags = new LinkedHashSet<String>();
		if(isPublic()){
			flags.add("public");
		}else if(isPrivate()){
			flags.add("private");
		}else if(isProtected()){
			flags.add("protected");
		}
		if(isInterface()){
			flags.add("interface");
		}else if(isEnum()){
			flags.add("enum");
		}else if(isAnnotation()){
			flags.add("@interface");
		}else{
			if(isAbstract()){
				flags.add("abstract");
			}else {
				if(isStatic()){
					flags.add("static");
				}
				if(isFinal()){
					flags.add("final");
				}
			}
			flags.add("class");
		}
		return flags;
	}

	public boolean isPublic() {
		return (flags & MASK_PUBLIC) == MASK_PUBLIC;
	}

	public boolean isPrivate() {
		return (flags & MASK_PRIVATE) == MASK_PRIVATE;
	}

	public boolean isProtected() {
		return (flags & MASK_PROTECTED) == MASK_PROTECTED;
	}

	public boolean isStatic() {
		return (flags & MASK_STATIC) == MASK_STATIC;
	}

	public boolean isFinal() {
		return (flags & MASK_FINAL) == MASK_FINAL;
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
		if(isPrivate()){
			str += "ACC_PRIVATE,";
		}
		if(isProtected()){
			str += "ACC_PROTECTED,";
		}
		if(isStatic()){
			str += "ACC_STATIC,";
		}
		if(isFinal()){
			str += "ACC_FINAL,";
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
		return str.substring(0, Math.max(0, str.length()-1));
	}

}
