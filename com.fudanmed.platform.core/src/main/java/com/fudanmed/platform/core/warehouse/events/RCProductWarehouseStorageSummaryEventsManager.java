package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.events.RCProductWarehouseStorageSummaryEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductWarehouseStorageSummaryEventsManager")
public class RCProductWarehouseStorageSummaryEventsManager extends EntityEventsManager<RCProductWarehouseStorageSummary> {
  @Autowired(required = false)
  private Collection<RCProductWarehouseStorageSummaryEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductWarehouseStorageSummaryEventsListener> getListeners() {
    return listeners;
  }
}
