package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCInStoreTransaction;
import com.fudanmed.platform.core.warehouse.events.RCInStoreTransactionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCInStoreTransactionEventsManager")
public class RCInStoreTransactionEventsManager extends EntityEventsManager<RCInStoreTransaction> {
  @Autowired(required = false)
  private Collection<RCInStoreTransactionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCInStoreTransactionEventsListener> getListeners() {
    return listeners;
  }
}
