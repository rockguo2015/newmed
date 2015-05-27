package edu.fudan.mylang.pf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseService implements IBaseService {

	@Autowired
	IObjectFactory objectFactory;

	public IObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(IObjectFactory objectFactory) {
		this.objectFactory = objectFactory;

	}

}
