package com.uniquesoft.gwt.shared.adaptor;

import com.uniquesoft.gwt.shared.IGWTEntity;

public class EntityAdaptorProxy<AdapteeProxy extends IGWTEntity> implements
		IGWTEntity {

	private AdapteeProxy adaptee;

	private String adaptorClazz;

	public EntityAdaptorProxy(){
		
	}
	public EntityAdaptorProxy(AdapteeProxy adaptee, String adaptorClazz) {
		this.adaptee = adaptee;
		this.adaptorClazz = adaptorClazz;
	}

	@Override
	public Long getId() {
		return adaptee.getId();
	}

	@Override
	public String getClazzName() {
		return adaptorClazz;
	}

	@Override
	public EntityAdaptorProxy<AdapteeProxy> toProxy() {
		return this;
	}

	public AdapteeProxy getAdapteeProxy() {
		return adaptee;
	}

}
