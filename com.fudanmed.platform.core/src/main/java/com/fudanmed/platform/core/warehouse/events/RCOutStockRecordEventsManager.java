package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.events.RCOutStockRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCOutStockRecordEventsManager")
public class RCOutStockRecordEventsManager extends EntityEventsManager<RCOutStockRecord> {
  @Autowired(required = false)
  private Collection<RCOutStockRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCOutStockRecordEventsListener> getListeners() {
    return listeners;
  }
}
