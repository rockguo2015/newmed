package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.events.RCInStockRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCInStockRecordEventsManager")
public class RCInStockRecordEventsManager extends EntityEventsManager<RCInStockRecord> {
  @Autowired(required = false)
  private Collection<RCInStockRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCInStockRecordEventsListener> getListeners() {
    return listeners;
  }
}
