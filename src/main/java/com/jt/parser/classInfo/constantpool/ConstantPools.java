package com.jt.parser.classInfo.constantpool;

import java.util.Arrays;

public class ConstantPools {
	
	private ConstantTag[] poolInfos;
	
	public ConstantPools(ConstantTag[] poolInfos){
		this.poolInfos = poolInfos;
	}
	
	public String getUtf8String(int index){
		ConstantUtf8 c = (ConstantUtf8)poolInfos[index];
		return c.getValue();
	}

	public ConstantTag[] getPoolInfos() {
		return poolInfos;
	}

	@Override
	public String toString() {
		return "ConstantPools [poolInfos=" + Arrays.toString(poolInfos) + "]";
	}
	
}
