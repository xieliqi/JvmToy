package com.jt.test;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;

import com.jt.test.TestAnnotation.TestAnnotation2;

public abstract class TestClass {

	public String a;

	@InvisibleAnnotation(a = 1, b = 'a', c = 3, d = false, enum2 = TestEnum.A)

	@TestAnnotation(a = 1, b = 'a', c = 3, d = false, e = 1, value = @TestAnnotation2, enum2 = TestEnum.A, arr = {
			0 }, f = 0, g = 0, str = "")
	public List<String> b;

	public static final synchronized native void a();

	/**
	 * 注释
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 * @throws IOException
	 * @throws NullArgumentException
	 */
	@InvisibleAnnotation(a = 1, b = 'a', c = 3, d = false, enum2 = TestEnum.A)

	@TestAnnotation(a = 1, b = 'a', c = 3, d = false, e = 1, value = @TestAnnotation2, enum2 = TestEnum.A, arr = {
			0 }, f = 0, g = 0, str = "")
	public List<String> action(@ParamAnnotation("a")List<String> a, List<Integer> b, @ParamAnnotation("c")String c) throws IOException,NullArgumentException {
		Object obj = new Object();
		return null;
	}
	
	public void find(List<String>[] days,int... datas){
		
	}
}
