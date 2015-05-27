package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLTaskEvent;
import com.fudanmed.platform.core.deliver.events.DLTaskEventEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLTaskEventEventsManager")
public class DLTaskEventEventsManager extends EntityEventsManager<DLTaskEvent> {
  @Autowired(required = false)
  private Collection<DLTaskEventEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLTaskEventEventsListener> getListeners() {
    return listeners;
  }
}
