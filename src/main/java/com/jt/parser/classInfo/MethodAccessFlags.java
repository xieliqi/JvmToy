package com.jt.parser.classInfo;

import java.util.LinkedHashSet;
import java.util.Set;

public class MethodAccessFlags {

	private final int MASK_PUBLIC = 0x0001;       // 0000 0000 0000 0001
	private final int MASK_PRIVATE = 0x0002;      // 0000 0000 0000 0010
	private final int MASK_PROTECTED = 0x0004;    // 0000 0000 0000 0100
	private final int MASK_STATIC = 0x0008;       // 0000 0000 0000 1000
	private final int MASK_FINAL = 0x0010;        // 0000 0000 0001 0000
	private final int MASK_SYNCHRONIZED = 0x0020; // 0000 0000 0010 0000
	private final int MASK_BRIDGE = 0x0040;       // 0000 0000 0100 0000 
	private final int MASK_VARARGS = 0x0080;      // 0000 0000 1000 0000 
	private final int MASK_NATIVE = 0x0100;       // 0000 0001 0000 0000 
	private final int MASK_ABSTRACT = 0x0400;     // 0000 0100 0000 0000
	private final int MASK_STRICT = 0x0800;       // 0000 1000 0000 0000
	private final int MASK_SYNTHETIC = 0x1000;    // 0001 0000 0000 0000

	private int flags;

	public MethodAccessFlags(int flags) {
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
		if(isAbstract()){
			flags.add("abstract");
		}else{
			if(isStatic()){
				flags.add("static");
			}
			if(isFinal()){
				flags.add("final");
			}
			if(isSynchronized()){
				flags.add("synchronized");
			}
			if(isNative()){
				flags.add("native");
			}else if(isStrict()){
				flags.add("strictfp");
			}
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

	public boolean isSynchronized() {
		return (flags & MASK_SYNCHRONIZED) == MASK_SYNCHRONIZED;
	}

	public boolean isBridge() {
		return (flags & MASK_BRIDGE) == MASK_BRIDGE;
	}

	public boolean isVarargs() {
		return (flags & MASK_VARARGS) == MASK_VARARGS;
	}

	public boolean isNative() {
		return (flags & MASK_NATIVE) == MASK_NATIVE;
	}

	public boolean isAbstract() {
		return (flags & MASK_ABSTRACT) == MASK_ABSTRACT;
	}
	
	public boolean isStrict() {
		return (flags & MASK_STRICT) == MASK_STRICT;
	}

	public boolean isSynthetic() {
		return (flags & MASK_SYNTHETIC) == MASK_SYNTHETIC;
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
		if(isSynchronized()){
			str += "ACC_SYNCHRONIZED,";
		}
		if(isBridge()){
			str += "ACC_BRIDGE,";
		}
		if(isVarargs()){
			str += "ACC_VARARGS,";
		}
		if(isNative()){
			str += "ACC_NATIVE,";
		}
		if(isAbstract()){
			str += "ACC_ABSTRACT,";
		}
		if(isStrict()){
			str += "ACC_STRICT,";
		}
		if(isSynthetic()){
			str += "ACC_SYNTHETIC,";
		}
		return str.substring(0, str.length()-1);
	}

}
