package com.jt.decompile;

import java.util.Arrays;

import com.jt.constant.OpCodes;

public class CodeInfoDisplay{
	
	@Override
	public String toString() {
		return "CodeInfoDisplay [" + OpCodes.getOpcodeName(op) + " " + Arrays.toString(pts) + ", ps=" + Arrays.toString(ps) + "]";
	}

	private int op;
	
	private short[] pts;

	private int[] ps;

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public short[] getPts() {
		return pts;
	}

	public void setPts(short[] pts) {
		this.pts = pts;
	}

	public int[] getPs() {
		return ps;
	}

	public void setPs(int[] ps) {
		this.ps = ps;
	}
	
}
