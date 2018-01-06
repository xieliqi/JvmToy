package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class LocalVariableTable extends AbstractAttribute {

	private LocalVariableInfo[] localVariableTable;

	public LocalVariableTable(int attributeNameIndex, int attributeLength, LocalVariableInfo[] localVariableTable) {
		super(attributeNameIndex, attributeLength);
		this.localVariableTable = localVariableTable;
	}

	@Override
	public String getName() {
		return "LocalVariableTable";
	}

	public LocalVariableInfo[] getLocalVariableTable() {
		return localVariableTable;
	}

	@Override
	public String toString() {
		return "LocalVariableTable [localVariableTable=" + Arrays.toString(localVariableTable) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

	public static class LocalVariableInfo {
		private int startPc;// u2
		private int length;// u2
		private int nameIndex;// u2
		private int descriptorIndex;// u2
		private int index;// u2

		public LocalVariableInfo(int startPc, int length, int nameIndex, int descriptorIndex, int index) {
			this.startPc = startPc;
			this.length = length;
			this.nameIndex = nameIndex;
			this.descriptorIndex = descriptorIndex;
			this.index = index;
		}

		public int getStartPc() {
			return startPc;
		}

		public int getLength() {
			return length;
		}

		public int getNameIndex() {
			return nameIndex;
		}

		public int getDescriptorIndex() {
			return descriptorIndex;
		}

		public int getIndex() {
			return index;
		}

		@Override
		public String toString() {
			return "LocalVariableInfo [startPc=" + startPc + ", length=" + length + ", nameIndex=" + nameIndex
					+ ", descriptorIndex=" + descriptorIndex + ", index=" + index + "]";
		}

	}

}
