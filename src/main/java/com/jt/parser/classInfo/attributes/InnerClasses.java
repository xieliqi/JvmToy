package com.jt.parser.classInfo.attributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jt.parser.classInfo.InnerAccessFlags;

/**
 * 用于ClassFile结构的属性表
 * 
 * @author xieliqi
 *
 */
public class InnerClasses extends AbstractAttribute {

	private InnerClass[] innerClasses;

	public InnerClasses(int attributeNameIndex, int attributeLength, InnerClass[] innerClasses) {
		super(attributeNameIndex, attributeLength);
		this.innerClasses = innerClasses;
	}

	@Override
	public String getName() {
		return "InnerClasses";
	}

	public InnerClass[] getInnerClasses() {
		return innerClasses;
	}

	@Override
	public String toString() {
		return "InnerClasses [innerClasses=" + Arrays.toString(innerClasses) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

	public static class InnerClass {
		private int innerClassInfoIndex;// u2 指向常量池CONSTANT_Class_info
		private int outerClassInfoIndex;// u2 指向常量池CONSTANT_Class_info
		private int innerNameIndex;
		private InnerAccessFlags innerClassAccessFlags;// u2

		public InnerClass(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex,
				int innerClassAccessFlags) {
			this.innerClassInfoIndex = innerClassInfoIndex;
			this.outerClassInfoIndex = outerClassInfoIndex;
			this.innerNameIndex = innerNameIndex;
			this.innerClassAccessFlags = new InnerAccessFlags(innerClassAccessFlags);
		}

		public int getInnerClassInfoIndex() {
			return innerClassInfoIndex;
		}

		public int getOuterClassInfoIndex() {
			return outerClassInfoIndex;
		}

		public int getInnerNameIndex() {
			return innerNameIndex;
		}

		public InnerAccessFlags getInnerClassAccessFlags() {
			return innerClassAccessFlags;
		}

		@Override
		public String toString() {
			return "InnerClass [innerClassInfoIndex=" + innerClassInfoIndex + ", outerClassInfoIndex="
					+ outerClassInfoIndex + ", innerNameIndex=" + innerNameIndex + ", innerClassAccessFlags="
					+ innerClassAccessFlags + "]";
		}

	}

}
