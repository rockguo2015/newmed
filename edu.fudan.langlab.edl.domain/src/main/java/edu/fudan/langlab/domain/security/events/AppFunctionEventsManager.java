package edu.fudan.langlab.domain.security.events;

import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.events.AppFunctionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.security.events.AppFunctionEventsManager")
public class AppFunctionEventsManager extends EntityEventsManager<AppFunction> {
  @Autowired(required = false)
  private Collection<AppFunctionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<AppFunctionEventsListener> getListeners() {
    return listeners;
  }
}
