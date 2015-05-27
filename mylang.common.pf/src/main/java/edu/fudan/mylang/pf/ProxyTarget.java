package edu.fudan.mylang.pf;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.CLASS;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)

public @interface ProxyTarget {
	String value();
}
