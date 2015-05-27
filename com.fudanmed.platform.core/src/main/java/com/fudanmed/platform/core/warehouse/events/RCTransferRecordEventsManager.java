package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.events.RCTransferRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCTransferRecordEventsManager")
public class RCTransferRecordEventsManager extends EntityEventsManager<RCTransferRecord> {
  @Autowired(required = false)
  private Collection<RCTransferRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCTransferRecordEventsListener> getListeners() {
    return listeners;
  }
}
