package edu.fudan.mylang.pf.test;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import edu.fudan.mylang.pf.IObjectFactory;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(HSQLDBRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public abstract class BaseHsqlTest extends Assert implements
		ApplicationContextAware {
	protected ApplicationContext appContext;

	protected TransactionTemplate getTransactionTemplate() {
		PlatformTransactionManager txManager = (PlatformTransactionManager) appContext
				.getBean("transactionManager");
		TransactionTemplate template = new TransactionTemplate(txManager);
		return template;
	}

	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		this.appContext = appContext;
	}

	@Autowired
	IObjectFactory objectFactory;

	public IObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(IObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
}
