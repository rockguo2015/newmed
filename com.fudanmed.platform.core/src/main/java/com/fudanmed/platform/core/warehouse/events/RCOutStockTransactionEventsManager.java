package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCOutStockTransaction;
import com.fudanmed.platform.core.warehouse.events.RCOutStockTransactionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCOutStockTransactionEventsManager")
public class RCOutStockTransactionEventsManager extends EntityEventsManager<RCOutStockTransaction> {
  @Autowired(required = false)
  private Collection<RCOutStockTransactionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCOutStockTransactionEventsListener> getListeners() {
    return listeners;
  }
}
