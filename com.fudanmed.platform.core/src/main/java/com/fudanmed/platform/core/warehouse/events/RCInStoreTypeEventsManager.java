package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCInStoreType;
import com.fudanmed.platform.core.warehouse.events.RCInStoreTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCInStoreTypeEventsManager")
public class RCInStoreTypeEventsManager extends EntityEventsManager<RCInStoreType> {
  @Autowired(required = false)
  private Collection<RCInStoreTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCInStoreTypeEventsListener> getListeners() {
    return listeners;
  }
}
