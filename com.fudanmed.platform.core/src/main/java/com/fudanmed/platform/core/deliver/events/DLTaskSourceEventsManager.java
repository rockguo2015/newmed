package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLTaskSource;
import com.fudanmed.platform.core.deliver.events.DLTaskSourceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLTaskSourceEventsManager")
public class DLTaskSourceEventsManager extends EntityEventsManager<DLTaskSource> {
  @Autowired(required = false)
  private Collection<DLTaskSourceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLTaskSourceEventsListener> getListeners() {
    return listeners;
  }
}
