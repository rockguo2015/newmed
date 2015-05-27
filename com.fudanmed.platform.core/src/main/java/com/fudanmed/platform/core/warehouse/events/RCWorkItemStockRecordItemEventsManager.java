package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.events.RCWorkItemStockRecordItemEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCWorkItemStockRecordItemEventsManager")
public class RCWorkItemStockRecordItemEventsManager extends EntityEventsManager<RCWorkItemStockRecordItem> {
  @Autowired(required = false)
  private Collection<RCWorkItemStockRecordItemEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemStockRecordItemEventsListener> getListeners() {
    return listeners;
  }
}
