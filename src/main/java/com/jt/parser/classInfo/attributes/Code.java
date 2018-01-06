package com.jt.parser.classInfo.attributes;

import java.util.Arrays;

import com.jt.parser.classInfo.Attributes;

public class Code extends AbstractAttribute {

	private int maxStack;// u2
	private int maxLocals;// u2
	private byte[] codes;
	private ExceptionTable[] exceptionTables;
	private Attributes attributes;// u2
									// 仅允许：LineNumberTable、LocalVariableTable、LocalVariableTypeTable、StackMapTable

	public Code(int attributeNameIndex, int attributeLength, int maxStack, int maxLocals, byte[] codes,
			ExceptionTable[] exceptionTables, Attributes attributes) {
		super(attributeNameIndex, attributeLength);
		this.maxStack = maxStack;
		this.maxLocals = maxLocals;
		this.codes = codes;
		this.exceptionTables = exceptionTables;
		this.attributes = attributes;
	}

	@Override
	public String getName() {
		return "ConstantValue";
	}

	public int getMaxStack() {
		return maxStack;
	}

	public int getMaxLocals() {
		return maxLocals;
	}

	public byte[] getCodes() {
		return codes;
	}

	public ExceptionTable[] getExceptionTables() {
		return exceptionTables;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	@Override
	public String toString() {
		return "Code [maxStack=" + maxStack + ", maxLocals=" + maxLocals + ", codes=" + Arrays.toString(codes)
				+ ", exceptionTables=" + exceptionTables + ", attributes=" + attributes + ", attributeNameIndex="
				+ attributeNameIndex + ", attributeLength=" + attributeLength + ", getName()=" + getName() + "]";
	}

	public static class ExceptionTable {

		private int startPc;// u2
		private int endPc;// u2
		private int handlerPc;// u2
		private int catchType;// u2

		public ExceptionTable(int startPc, int endPc, int handlerPc, int catchType) {
			this.startPc = startPc;
			this.endPc = endPc;
			this.handlerPc = handlerPc;
			this.catchType = catchType;
		}

		public int getStartPc() {
			return startPc;
		}

		public int getEndPc() {
			return endPc;
		}

		public int getHandlerPc() {
			return handlerPc;
		}

		public int getCatchType() {
			return catchType;
		}

		@Override
		public String toString() {
			return "ExceptionTable [startPc=" + startPc + ", endPc=" + endPc + ", handlerPc=" + handlerPc
					+ ", catchType=" + catchType + "]";
		}

	}

}
