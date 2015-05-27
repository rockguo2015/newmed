package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.events.RCWarehouseEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCWarehouseEventsManager")
public class RCWarehouseEventsManager extends EntityEventsManager<RCWarehouse> {
  @Autowired(required = false)
  private Collection<RCWarehouseEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWarehouseEventsListener> getListeners() {
    return listeners;
  }
}
