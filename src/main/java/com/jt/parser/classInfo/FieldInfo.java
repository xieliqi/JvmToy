package com.jt.parser.classInfo;

import com.jt.parser.classInfo.attributes.AbstractAttribute;
import com.jt.parser.classInfo.attributes.Synthetic;

public class FieldInfo {
	private FieldAccessFlags accessFlags;// u2
	private int nameIndex;// u2
	private int descriptorIndex;// u2
	private Attributes attributes;
	private boolean isSynthetic = false;// 如果一个类成员没有在源文件中出现，则必须标记带有Synthetic属性，或者设置ACC_SYNTHETIC标志

	public FieldInfo(int flags, int nameIndex, int descriptorIndex, Attributes attributes) {
		this.accessFlags = new FieldAccessFlags(flags);
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
		this.attributes = attributes;
		for (AbstractAttribute attr : attributes.getAttributes()) {
			if (attr instanceof Synthetic) {
				isSynthetic = true;
				break;
			}
		}
	}

	public FieldAccessFlags getAccessFlags() {
		return accessFlags;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public int getDescriptorIndex() {
		return descriptorIndex;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public boolean isSynthetic() {
		return isSynthetic;
	}

	@Override
	public String toString() {
		return "FieldInfo [accessFlags=" + accessFlags + ", nameIndex=" + nameIndex + ", descriptor=" + descriptorIndex
				+ ", attributes=" + attributes + "]";
	}

}
