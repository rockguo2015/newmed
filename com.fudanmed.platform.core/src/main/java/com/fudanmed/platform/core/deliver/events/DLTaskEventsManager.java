package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.events.DLTaskEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLTaskEventsManager")
public class DLTaskEventsManager extends EntityEventsManager<DLTask> {
  @Autowired(required = false)
  private Collection<DLTaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLTaskEventsListener> getListeners() {
    return listeners;
  }
}
