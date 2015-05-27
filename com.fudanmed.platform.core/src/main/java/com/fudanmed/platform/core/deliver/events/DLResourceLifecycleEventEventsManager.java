package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLResourceLifecycleEvent;
import com.fudanmed.platform.core.deliver.events.DLResourceLifecycleEventEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLResourceLifecycleEventEventsManager")
public class DLResourceLifecycleEventEventsManager extends EntityEventsManager<DLResourceLifecycleEvent> {
  @Autowired(required = false)
  private Collection<DLResourceLifecycleEventEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLResourceLifecycleEventEventsListener> getListeners() {
    return listeners;
  }
}
