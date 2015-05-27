package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCStockTakingStatus;
import com.fudanmed.platform.core.warehouse.events.RCStockTakingStatusEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCStockTakingStatusEventsManager")
public class RCStockTakingStatusEventsManager extends EntityEventsManager<RCStockTakingStatus> {
  @Autowired(required = false)
  private Collection<RCStockTakingStatusEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStockTakingStatusEventsListener> getListeners() {
    return listeners;
  }
}
