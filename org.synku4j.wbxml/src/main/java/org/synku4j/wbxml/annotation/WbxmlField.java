package org.synku4j.wbxml.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface WbxmlField {
	String name() default "";
	int index() default NO_INDEX;
	String[] filters() default {};
	int limit() default -1;
	boolean required() default false;
	Class<?>[] classes() default {};
	
	static final int NO_INDEX = -1;
}
