package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCOutStockRecordItem;
import com.fudanmed.platform.core.warehouse.events.RCOutStockRecordItemEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCOutStockRecordItemEventsManager")
public class RCOutStockRecordItemEventsManager extends EntityEventsManager<RCOutStockRecordItem> {
  @Autowired(required = false)
  private Collection<RCOutStockRecordItemEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCOutStockRecordItemEventsListener> getListeners() {
    return listeners;
  }
}
