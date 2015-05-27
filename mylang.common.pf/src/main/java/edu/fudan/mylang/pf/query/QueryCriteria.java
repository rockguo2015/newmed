package edu.fudan.mylang.pf.query;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import edu.fudan.mylang.pf.IModelObject;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface QueryCriteria {
	Class<? extends IModelObject> entity();
}
