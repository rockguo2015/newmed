package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.warehouse.events.RCWorkItemStorageEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCWorkItemStorageEventsManager")
public class RCWorkItemStorageEventsManager extends EntityEventsManager<RCWorkItemStorage> {
  @Autowired(required = false)
  private Collection<RCWorkItemStorageEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemStorageEventsListener> getListeners() {
    return listeners;
  }
}
