package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCOutStockType;
import com.fudanmed.platform.core.common.events.RCOutStockTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCOutStockTypeEventsManager")
public class RCOutStockTypeEventsManager extends EntityEventsManager<RCOutStockType> {
  @Autowired(required = false)
  private Collection<RCOutStockTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCOutStockTypeEventsListener> getListeners() {
    return listeners;
  }
}
