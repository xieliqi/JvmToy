package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

/**
 * 用于Code结构的属性表
 * 
 * @author xieliqi
 *
 */
public class LineNumberTable extends AbstractAttribute {

	private LineNumberInfo[] lineNumberTable;

	public LineNumberTable(int attributeNameIndex, int attributeLength, LineNumberInfo[] lineNumberTable) {
		super(attributeNameIndex, attributeLength);
		this.lineNumberTable = lineNumberTable;
	}

	@Override
	public String getName() {
		return "LineNumberTable";
	}

	public LineNumberInfo[] getLineNumberTable() {
		return lineNumberTable;
	}

	@Override
	public String toString() {
		return "LineNumberTable [lineNumberTable=" + Arrays.toString(lineNumberTable) + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + "]";
	}

	public static class LineNumberInfo {
		private int startPc;// u2
		private int lineNumber;// u2

		public LineNumberInfo(int startPc, int lineNumber) {
			this.startPc = startPc;
			this.lineNumber = lineNumber;
		}

		public int getStartPc() {
			return startPc;
		}

		public int getLineNumber() {
			return lineNumber;
		}

		@Override
		public String toString() {
			return "LineNumberInfo [startPc=" + startPc + ", lineNumber=" + lineNumber + "]";
		}

	}

}
