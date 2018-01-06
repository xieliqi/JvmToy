package com.jt.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
	
	byte a();
	char b();
	short c();
	boolean d();
	int e();
	float f();
	double g();
	String str();
	int[] arr();
	TestAnnotation2 value();
	TestEnum enum2();
	
	public @interface TestAnnotation2 {
		
	}
}
