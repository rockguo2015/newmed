package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockTransaction;
import com.fudanmed.platform.core.warehouse.events.RCWorkItemStockTransactionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCWorkItemStockTransactionEventsManager")
public class RCWorkItemStockTransactionEventsManager extends EntityEventsManager<RCWorkItemStockTransaction> {
  @Autowired(required = false)
  private Collection<RCWorkItemStockTransactionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemStockTransactionEventsListener> getListeners() {
    return listeners;
  }
}
