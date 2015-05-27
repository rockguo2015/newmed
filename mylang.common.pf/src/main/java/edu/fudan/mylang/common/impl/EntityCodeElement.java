package edu.fudan.mylang.common.impl;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import edu.fudan.mylang.common.IEntityCodeElement;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.event.IEntityEventsManager;

@Entity
@Table(name = "CODE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CODE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class EntityCodeElement extends BaseModelObject implements
		IEntityCodeElement {

	private String name;
	private String code;

	protected EntityCodeElement() {
	}

	public EntityCodeElement(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public Object toProxy() {
		// TODO Auto-generated method stub
		return null;
	}

}
