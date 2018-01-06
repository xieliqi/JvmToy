package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class LocalVariableTypeTable extends AbstractAttribute {

	private LocalVariableTypeInfo[] localVariableTypeTable;

	public LocalVariableTypeTable(int attributeNameIndex, int attributeLength,
			LocalVariableTypeInfo[] localVariableTypeTable) {
		super(attributeNameIndex, attributeLength);
		this.localVariableTypeTable = localVariableTypeTable;
	}

	@Override
	public String getName() {
		return "LocalVariableTypeTable";
	}

	public LocalVariableTypeInfo[] getLocalVariableTypeTable() {
		return localVariableTypeTable;
	}

	@Override
	public String toString() {
		return "LocalVariableTypeTable [localVariableTypeTable=" + Arrays.toString(localVariableTypeTable)
				+ ", attributeNameIndex=" + attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

	public static class LocalVariableTypeInfo {
		private int startPc;// u2
		private int length;// u2
		private int nameIndex;// u2
		private int signatureIndex;// u2
		private int index;// u2

		public LocalVariableTypeInfo(int startPc, int length, int nameIndex, int signatureIndex, int index) {
			this.startPc = startPc;
			this.length = length;
			this.nameIndex = nameIndex;
			this.signatureIndex = signatureIndex;
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

		public int getSignatureIndex() {
			return signatureIndex;
		}

		public int getIndex() {
			return index;
		}

		@Override
		public String toString() {
			return "LocalVariableInfo [startPc=" + startPc + ", length=" + length + ", nameIndex=" + nameIndex
					+ ", signatureIndex=" + signatureIndex + ", index=" + index + "]";
		}

	}

}
