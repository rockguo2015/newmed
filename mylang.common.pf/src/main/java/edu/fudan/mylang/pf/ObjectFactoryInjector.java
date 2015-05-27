package edu.fudan.mylang.pf;

import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class ObjectFactoryInjector implements PostLoadEventListener,
		PostUpdateEventListener, BeanFactoryAware {

	private static final long serialVersionUID = 6542367678846751305L;
	BeanFactory beanFactory;

	/*
	 * inject objectFactory into loaded entities.
	 * (non-Javadoc)
	 * @see org.hibernate.event.PostLoadEventListener#onPostLoad(org.hibernate.event.PostLoadEvent)
	 */
	public void onPostLoad(PostLoadEvent event) {
		if (event.getEntity() instanceof IContextAwareModelObject) {
			IObjectFactory pm = (IObjectFactory) beanFactory
					.getBean("objectFactory");
			((IContextAwareModelObject) event.getEntity()).setObjectFactory(pm);
			((IContextAwareModelObject) event.getEntity())
					.entityInitialized(beanFactory);
		}
	}

	public void onPostUpdate(PostUpdateEvent event) {
		if (event.getEntity() instanceof IContextAwareModelObject) {
			IObjectFactory pm = (IObjectFactory) beanFactory
					.getBean("objectFactory");
			((IContextAwareModelObject) event.getEntity()).setObjectFactory(pm);
			((IContextAwareModelObject) event.getEntity())
					.entityInitialized(beanFactory);
		}
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
