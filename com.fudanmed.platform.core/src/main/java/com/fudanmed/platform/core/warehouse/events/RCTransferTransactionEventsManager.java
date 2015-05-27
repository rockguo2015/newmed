package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCTransferTransaction;
import com.fudanmed.platform.core.warehouse.events.RCTransferTransactionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCTransferTransactionEventsManager")
public class RCTransferTransactionEventsManager extends EntityEventsManager<RCTransferTransaction> {
  @Autowired(required = false)
  private Collection<RCTransferTransactionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCTransferTransactionEventsListener> getListeners() {
    return listeners;
  }
}
