package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.events.RCProductStoreTransactionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductStoreTransactionEventsManager")
public class RCProductStoreTransactionEventsManager extends EntityEventsManager<RCProductStoreTransaction> {
  @Autowired(required = false)
  private Collection<RCProductStoreTransactionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductStoreTransactionEventsListener> getListeners() {
    return listeners;
  }
}
