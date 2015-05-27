package edu.fudan.mylang.pf;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDataType implements Serializable{

	private String workaround = "workaround";

	public String getWorkaround() {
		return this.workaround;
	}

	public BaseDataType setWorkaround(final String workaround) {
		this.workaround = workaround;
		return this;

	}
}
