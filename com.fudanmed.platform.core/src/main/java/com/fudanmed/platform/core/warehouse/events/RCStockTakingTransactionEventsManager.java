package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCStockTakingTransaction;
import com.fudanmed.platform.core.warehouse.events.RCStockTakingTransactionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCStockTakingTransactionEventsManager")
public class RCStockTakingTransactionEventsManager extends EntityEventsManager<RCStockTakingTransaction> {
  @Autowired(required = false)
  private Collection<RCStockTakingTransactionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStockTakingTransactionEventsListener> getListeners() {
    return listeners;
  }
}
