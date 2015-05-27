package edu.fudan.langlab.domain.task.events;

import edu.fudan.langlab.domain.task.NormalTask;
import edu.fudan.langlab.domain.task.events.NormalTaskEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.task.events.NormalTaskEventsManager")
public class NormalTaskEventsManager extends EntityEventsManager<NormalTask> {
  @Autowired(required = false)
  private Collection<NormalTaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<NormalTaskEventsListener> getListeners() {
    return listeners;
  }
}
