package edu.fudan.langlab.uidl.domain.app.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;

public class BaseClientModule extends AbstractGinModule {

	@Override
	protected void configure() {

		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);


	}

}
