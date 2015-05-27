package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLResourceEvent;
import com.fudanmed.platform.core.deliver.events.DLResourceEventEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLResourceEventEventsManager")
public class DLResourceEventEventsManager extends EntityEventsManager<DLResourceEvent> {
  @Autowired(required = false)
  private Collection<DLResourceEventEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLResourceEventEventsListener> getListeners() {
    return listeners;
  }
}
