package edu.fudan.mylang.pf.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;

import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.pf.event.IEntityEventsManager;

@Entity
public class Person extends BaseModelObject implements IPerson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static IPerson createPerson(String name, IObjectFactory of) {
		Person p = new Person(name);
		p.preinitialize();
		of.create(p);
		return p;
	}

	public Person() {

	}

	@Basic
	private String name;

	@Basic
	private Date birthday;

	protected Person(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fs.model.persistence.entity.IPerson#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fs.model.persistence.entity.IPerson#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fs.model.persistence.entity.IPerson#getBirthday()
	 */
	@Override
	public Date getBirthday() {
		return birthday;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fs.model.persistence.entity.IPerson#setBirthday(java.util.Date)
	 */
	@Override
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public Object toProxy() {
		// TODO Auto-generated method stub
		return null;
	}

}
