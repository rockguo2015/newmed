package edu.fudan.langlab.domain.task;

import org.springframework.stereotype.Component;

@Component("DummyTaskEventListener")
public class DummyTaskEventListener implements TaskEventListener{

	@Override
	public void afterTaskCreated(Task task) {
		System.out.println("Dummy task created");
	}

	@Override
	public void beforeTaskDelete(Task task) {
		System.out.println("Dummy task to be deleted");
	}

}
