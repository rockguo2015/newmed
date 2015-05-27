package edu.fudan.langlab.domain.workflow.events;

import edu.fudan.langlab.domain.workflow.ProcessTask;
import edu.fudan.langlab.domain.workflow.events.ProcessTaskEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.workflow.events.ProcessTaskEventsManager")
public class ProcessTaskEventsManager extends EntityEventsManager<ProcessTask> {
  @Autowired(required = false)
  private Collection<ProcessTaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<ProcessTaskEventsListener> getListeners() {
    return listeners;
  }
}
