package edu.fudan.langlab.domain.updater;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements
		ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		event.getApplicationContext().getBean(UpgradeExecutor.class).execute();
	}

}
