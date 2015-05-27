package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.events.RCProductEntryEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductEntryEventsManager")
public class RCProductEntryEventsManager extends EntityEventsManager<RCProductEntry> {
  @Autowired(required = false)
  private Collection<RCProductEntryEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductEntryEventsListener> getListeners() {
    return listeners;
  }
}
