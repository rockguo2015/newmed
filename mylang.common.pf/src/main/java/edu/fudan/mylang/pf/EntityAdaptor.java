package edu.fudan.mylang.pf;

import org.springframework.beans.factory.BeanFactory;

public class EntityAdaptor<Adaptee> {

	private IObjectFactory objectFactory;
	private BeanFactory beanFactory;

	public void setObjectFactory(IObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	public IObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public Adaptee adaptee;

	public void setAdaptee(Object adaptee) {
		this.adaptee = (Adaptee) adaptee;
	}
}
