package com.uniquesoft.gwt.shared;

import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.common.base.Function;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.uniquesoft.gwt.shared.adaptor.EntityAdaptorProxy;

/**
 * This class is mainly used to record id for a UI component. UI entities all
 * inherit this class to record the id information. Id can help the find the
 * entity that related.
 * 
 */
public class GWTEntity implements IGWTEntity {

	private Long id;
	private String clazzName;
	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public static final String P_ID = "id";

	protected GWTEntity() {

	}

	/**
	 * Create a GWTEntity and init the id value
	 * 
	 * @param id
	 */
	public GWTEntity(Long id, String clazzName) {
		this.id = id;
		this.clazzName = clazzName;
	}

	
	public <T extends GWTEntity>T transform(T newEntity){
		newEntity.setId(this.id);
		newEntity.setProxy(this.theProxy);
		newEntity.setClazzName(this.clazzName);
		return newEntity;
	}
	/**
	 * @return get the GWTEntity's id value
	 */
	public Long getId() {
		return id;
	}

	/**
	 * transfer a value for the value
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	GWTNamedEntity theProxy;

	public void setProxy(GWTNamedEntity theProxy) {
		this.theProxy = theProxy;
	}

	public Object toProxy() {
		if (theProxy != null)
			return theProxy;
		else
			return this;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object) Rewrite the equals method,
	 * if their id values are the same, we can judge that the two bojects are
	 * the same.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (id == null)
			return ((GWTEntity) obj).getId() == null;
		return id.equals(((GWTEntity) obj).getId());
	}

	@Override
	public int hashCode() {
		if (id == null)
			return super.hashCode();
		return id.hashCode();
	}
}
