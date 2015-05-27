package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.warehouse.events.RCStockTakingItemEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCStockTakingItemEventsManager")
public class RCStockTakingItemEventsManager extends EntityEventsManager<RCStockTakingItem> {
  @Autowired(required = false)
  private Collection<RCStockTakingItemEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStockTakingItemEventsListener> getListeners() {
    return listeners;
  }
}
