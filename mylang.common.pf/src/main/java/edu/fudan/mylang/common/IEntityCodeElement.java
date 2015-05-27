package edu.fudan.mylang.common;


import edu.fudan.mylang.common.impl.EntityCodeElement;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = EntityCodeElement.class)
public interface IEntityCodeElement extends IModelObject {

	String getCode();
	
	void setCode(String code);
	
	String getName();
	
	void setName(String name);
}
