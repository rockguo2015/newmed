package edu.fudan.langlab.domain.task.events;

import edu.fudan.langlab.domain.task.Task;
import edu.fudan.langlab.domain.task.events.TaskEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.task.events.TaskEventsManager")
public class TaskEventsManager extends EntityEventsManager<Task> {
  @Autowired(required = false)
  private Collection<TaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<TaskEventsListener> getListeners() {
    return listeners;
  }
}
