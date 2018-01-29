package com.jt.constant;

public class JavaVersions {

	/**
	 * Major version number of class files for Java 1.1.
	 * 
	 * @see #MINOR_1_1
	 */
	public static final short MAJOR_1_1 = 45;

	/**
	 * Minor version number of class files for Java 1.1.
	 * 
	 * @see #MAJOR_1_1
	 */
	public static final short MINOR_1_1 = 3;

	/**
	 * Major version number of class files for Java 1.2.
	 * 
	 * @see #MINOR_1_2
	 */
	public static final short MAJOR_1_2 = 46;

	/**
	 * Major version number of class files for Java 1.9.
	 * 
	 * @see #MINOR_1_9
	 */
	public static final short MAJOR_1_9 = 53;

	public String getJavaVersion(int classMajor, int classMinor) {
		if(classMajor==MAJOR_1_1 && classMinor==MINOR_1_1){
			return "1.1";
		}
		if(classMajor>=MAJOR_1_2 && classMajor<= MAJOR_1_9&&classMinor==0){
			return "1."+(classMajor-MAJOR_1_2+2);
		}
		throw new IllegalArgumentException("not support version:"+classMajor+"."+classMinor);
	}

}
