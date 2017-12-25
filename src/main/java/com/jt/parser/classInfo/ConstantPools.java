package com.jt.parser.classInfo;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ConstantPools {
	
	private int count;
	private ConstantPoolInfo[] poolInfos;
	
	public ConstantPools(DataInputStream data) throws IOException{
		count = data.readUnsignedShort();
		
	}
	
	@Override
	public String toString() {
		return "ConstantPools [count=" + count + ", poolInfos=" + Arrays.toString(poolInfos) + "]";
	}

	public int getCount() {
		return count;
	}
	public ConstantPoolInfo[] getPoolInfos() {
		return poolInfos;
	}

}
