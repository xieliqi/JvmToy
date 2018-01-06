package com.jt.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface InvisibleAnnotation {
	
	byte a();
	char b();
	short c();
	boolean d();
	
	TestEnum enum2();
	
	
}
