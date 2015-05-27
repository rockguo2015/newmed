package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.events.RCProductWarehouseStorageEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductWarehouseStorageEventsManager")
public class RCProductWarehouseStorageEventsManager extends EntityEventsManager<RCProductWarehouseStorage> {
  @Autowired(required = false)
  private Collection<RCProductWarehouseStorageEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductWarehouseStorageEventsListener> getListeners() {
    return listeners;
  }
}
