package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLResourceType;
import com.fudanmed.platform.core.deliver.events.DLResourceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLResourceTypeEventsManager")
public class DLResourceTypeEventsManager extends EntityEventsManager<DLResourceType> {
  @Autowired(required = false)
  private Collection<DLResourceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLResourceTypeEventsListener> getListeners() {
    return listeners;
  }
}
