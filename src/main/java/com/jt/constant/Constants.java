package com.jt.constant;

import java.util.Arrays;
import java.util.Collections;

public class Constants {
	
	  public static final int JVM_CLASSFILE_MAGIC = 0xCAFEBABE;
	  
	  /** The name of the static initializer, also called &quot;class
	   *  initialization method&quot; or &quot;interface initialization
	   *   method&quot;. This is &quot;&lt;clinit&gt;&quot;.
	   */
	  public static final String STATIC_INITIALIZER_NAME = "<clinit>";

	  /** The name of every constructor method in a class, also called
	   * &quot;instance initialization method&quot;. This is &quot;&lt;init&gt;&quot;.
	   */
	  public static final String CONSTRUCTOR_NAME = "<init>";

	  /**
	   * The names of the interfaces implemented by arrays
	   */
	  private static final String[] INTERFACES_IMPLEMENTED_BY_ARRAYS = {"java.lang.Cloneable", "java.io.Serializable"};

	  /**
	   * @since 6.0
	   */
	  public static Iterable<String> getInterfacesImplementedByArrays() {
	      return Collections.unmodifiableList(Arrays.asList(INTERFACES_IMPLEMENTED_BY_ARRAYS));
	  }
}
