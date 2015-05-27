package edu.fudan.mylang.pf.entity;

import java.util.Date;

import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = Person.class)
public interface IPerson extends IModelObject {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract Date getBirthday();

	public abstract void setBirthday(Date birthday);

}