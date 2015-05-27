package edu.fudan.langlab.domain.workflow.events;

import edu.fudan.langlab.domain.workflow.StartActivity;
import edu.fudan.langlab.domain.workflow.events.StartActivityEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.workflow.events.StartActivityEventsManager")
public class StartActivityEventsManager extends EntityEventsManager<StartActivity> {
  @Autowired(required = false)
  private Collection<StartActivityEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<StartActivityEventsListener> getListeners() {
    return listeners;
  }
}
