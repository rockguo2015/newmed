package edu.fudan.mylang.pf;

import org.springframework.beans.factory.BeanFactory;

public interface IContextAwareModelObject {
	
	void setObjectFactory(IObjectFactory objectFactory);

	public void entityInitialized(BeanFactory beanFactory);
		
}
