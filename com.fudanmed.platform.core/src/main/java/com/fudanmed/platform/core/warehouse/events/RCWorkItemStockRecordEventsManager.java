package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.events.RCWorkItemStockRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCWorkItemStockRecordEventsManager")
public class RCWorkItemStockRecordEventsManager extends EntityEventsManager<RCWorkItemStockRecord> {
  @Autowired(required = false)
  private Collection<RCWorkItemStockRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemStockRecordEventsListener> getListeners() {
    return listeners;
  }
}
