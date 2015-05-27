package edu.fudan.langlab.domain.workflow.events;

import edu.fudan.langlab.domain.workflow.Activity;
import edu.fudan.langlab.domain.workflow.events.ActivityEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.workflow.events.ActivityEventsManager")
public class ActivityEventsManager extends EntityEventsManager<Activity> {
  @Autowired(required = false)
  private Collection<ActivityEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<ActivityEventsListener> getListeners() {
    return listeners;
  }
}
