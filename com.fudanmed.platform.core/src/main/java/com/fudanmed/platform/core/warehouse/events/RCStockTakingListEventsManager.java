package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.events.RCStockTakingListEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCStockTakingListEventsManager")
public class RCStockTakingListEventsManager extends EntityEventsManager<RCStockTakingList> {
  @Autowired(required = false)
  private Collection<RCStockTakingListEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStockTakingListEventsListener> getListeners() {
    return listeners;
  }
}
