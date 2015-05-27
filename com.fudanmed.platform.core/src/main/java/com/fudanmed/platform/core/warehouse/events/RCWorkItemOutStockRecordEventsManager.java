package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord;
import com.fudanmed.platform.core.warehouse.events.RCWorkItemOutStockRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCWorkItemOutStockRecordEventsManager")
public class RCWorkItemOutStockRecordEventsManager extends EntityEventsManager<RCWorkItemOutStockRecord> {
  @Autowired(required = false)
  private Collection<RCWorkItemOutStockRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemOutStockRecordEventsListener> getListeners() {
    return listeners;
  }
}
