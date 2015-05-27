package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCInStockRecordItem;
import com.fudanmed.platform.core.warehouse.events.RCInStockRecordItemEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCInStockRecordItemEventsManager")
public class RCInStockRecordItemEventsManager extends EntityEventsManager<RCInStockRecordItem> {
  @Autowired(required = false)
  private Collection<RCInStockRecordItemEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCInStockRecordItemEventsListener> getListeners() {
    return listeners;
  }
}
