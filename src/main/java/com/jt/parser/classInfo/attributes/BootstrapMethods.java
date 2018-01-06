package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

/**
 * BootstrapMethods属性是一个变长属性，位于ClassFile（§4.1）结构的属性表中。用于保存invokedynamic指令引用的引导方法限定符。
 * 
 * @author xieliqi
 *
 */
public class BootstrapMethods extends AbstractAttribute {

	private BootstrapMethod[] bootstrapMethods;

	public BootstrapMethods(int attributeNameIndex, int attributeLength, BootstrapMethod[] bootstrapMethods) {
		super(attributeNameIndex, attributeLength);
		this.bootstrapMethods = bootstrapMethods;
	}

	@Override
	public String getName() {
		return "BootstrapMethods";
	}

	public BootstrapMethod[] getBootstrapMethods() {
		return bootstrapMethods;
	}

	@Override
	public String toString() {
		return "BootstrapMethods [bootstrapMethods=" + Arrays.toString(bootstrapMethods) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

	public static class BootstrapMethod {
		private int bootstrapMethodRef;// u2
		private int[] bootstrapArguments;

		public BootstrapMethod(int bootstrapMethodRef, int[] bootstrapArguments) {
			this.bootstrapMethodRef = bootstrapMethodRef;
			this.bootstrapArguments = bootstrapArguments;
		}

		public int getBootstrapMethodRef() {
			return bootstrapMethodRef;
		}

		public int[] getBootstrapArguments() {
			return bootstrapArguments;
		}

		@Override
		public String toString() {
			return "BootstrapMethod [bootstrapMethodRef=" + bootstrapMethodRef + ", bootstrapArguments="
					+ Arrays.toString(bootstrapArguments) + "]";
		}

	}

}
