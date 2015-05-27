package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.events.RCStockTakingRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCStockTakingRecordEventsManager")
public class RCStockTakingRecordEventsManager extends EntityEventsManager<RCStockTakingRecord> {
  @Autowired(required = false)
  private Collection<RCStockTakingRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStockTakingRecordEventsListener> getListeners() {
    return listeners;
  }
}
