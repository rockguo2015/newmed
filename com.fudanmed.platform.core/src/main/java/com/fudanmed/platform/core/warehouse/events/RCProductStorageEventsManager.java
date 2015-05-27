package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.events.RCProductStorageEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductStorageEventsManager")
public class RCProductStorageEventsManager extends EntityEventsManager<RCProductStorage> {
  @Autowired(required = false)
  private Collection<RCProductStorageEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductStorageEventsListener> getListeners() {
    return listeners;
  }
}
