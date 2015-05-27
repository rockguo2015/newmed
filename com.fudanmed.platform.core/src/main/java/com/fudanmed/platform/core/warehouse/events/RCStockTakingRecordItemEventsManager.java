package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.warehouse.events.RCStockTakingRecordItemEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCStockTakingRecordItemEventsManager")
public class RCStockTakingRecordItemEventsManager extends EntityEventsManager<RCStockTakingRecordItem> {
  @Autowired(required = false)
  private Collection<RCStockTakingRecordItemEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStockTakingRecordItemEventsListener> getListeners() {
    return listeners;
  }
}
