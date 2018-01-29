package com.jt.parser.classInfo.attributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用于Code属性中
 * 
 * @author xieliqi
 *
 */
public class StackMapTable extends AbstractAttribute {

	private StackMapFrame[] entries;

	public StackMapTable(int attributeNameIndex, int attributeLength, StackMapFrame[] entries) {
		super(attributeNameIndex, attributeLength);
		this.entries = entries;
	}

	@Override
	public String getName() {
		return "StackMapTable";
	}

	public StackMapFrame[] getEntries() {
		return entries;
	}

	@Override
	public String toString() {
		return "StackMapTable [entries=" + entries + ", attributeNameIndex=" + attributeNameIndex + ", attributeLength="
				+ attributeLength + ", getName()=" + getName() + "]";
	}

	/**
	 * <pre>
	 * frameType=[0-63]:SAME 
	 * frameType=[64-127]:SAME_LOCALS_1_STACK_ITEM
	 * 范围在128至246的类型标记值是为未来使用而预留的。
	 * frameType=[247]:SAME_LOCALS_1_STACK_ITEM_EXTENDED
	 * frameType=[248-250]:CHOP 
	 * frameType=[251]:SAME_FRAME_EXTENDED
	 * frameType=[252-254]:APPEND
	 * </pre>
	 * 
	 * @author xieliqi
	 *
	 */
	public static class StackMapFrame {

		private int frameType;// u1
		private int offsetDelta;// u2
								// SAME_LOCALS_1_STACK_ITEM_EXTENDED、CHOP、SAME_FRAME_EXTENDED、APPEND

		private VerificationTypeInfo[] locals;// SAME_LOCALS_1_STACK_ITEM、SAME_LOCALS_1_STACK_ITEM_EXTENDED、APPEND

		private VerificationTypeInfo[] stackItems;// SAME_LOCALS_1_STACK_ITEM、SAME_LOCALS_1_STACK_ITEM_EXTENDED、APPEND

		
		public StackMapFrame(int frameType, int offsetDelta, VerificationTypeInfo[] locals, VerificationTypeInfo[] stackItems) {
			this.frameType = frameType;
			this.offsetDelta = offsetDelta;
			this.locals = locals;
			this.stackItems = stackItems;
		}

		public int getFrameType() {
			return frameType;
		}

		public int getOffsetDelta() {
			return offsetDelta;
		}

		public VerificationTypeInfo[] getLocals() {
			return locals;
		}

		@Override
		public String toString() {
			return "StackMapFrame [frameType=" + frameType + ", offsetDelta=" + offsetDelta + ", locals="
					+ Arrays.toString(locals) + ", stackItems=" + Arrays.toString(stackItems) + "]";
		}

	}

	/**
	 * <pre>
	 * tag=0:ITEM_Top
	 * tag=1:ITEM_Integer
	 * tag=2:ITEM_Float
	 * tag=3:ITEM_Double
	 * tag=4:ITEM_Long
	 * tag=5:ITEM_Null
	 * tag=6:ITEM_UninitializedThis
	 * tag=7:ITEM_Object
	 * tag=9:ITEM_Uninitialized
	 * </pre>
	 */
	public static class VerificationTypeInfo {
		private int tag;// u1
		private int cpoolIndex;// u2 ITEM_Object
		private int offset;// u2 ITEM_Uninitialized

		public VerificationTypeInfo(int tag, int cpoolIndex, int offset) {
			this.tag = tag;
			this.cpoolIndex = cpoolIndex;
			this.offset = offset;
		}

		public int getTag() {
			return tag;
		}

		public int getCpoolIndex() {
			return cpoolIndex;
		}

		public int getOffset() {
			return offset;
		}

		@Override
		public String toString() {
			return "VerificationTypeInfo [tag=" + tag + ", cpoolIndex=" + cpoolIndex + ", offset=" + offset + "]";
		}

	}

}
