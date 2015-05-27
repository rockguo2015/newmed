package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCTransferRecordItem;
import com.fudanmed.platform.core.warehouse.events.RCTransferRecordItemEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCTransferRecordItemEventsManager")
public class RCTransferRecordItemEventsManager extends EntityEventsManager<RCTransferRecordItem> {
  @Autowired(required = false)
  private Collection<RCTransferRecordItemEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCTransferRecordItemEventsListener> getListeners() {
    return listeners;
  }
}
