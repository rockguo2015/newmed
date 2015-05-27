package edu.fudan.langlab.domain.task;

public interface TaskEventListener {
	void afterTaskCreated(Task task);
	void beforeTaskDelete(Task task);
}
