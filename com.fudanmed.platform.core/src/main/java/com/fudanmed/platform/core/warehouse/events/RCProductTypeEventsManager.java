package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.events.RCProductTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductTypeEventsManager")
public class RCProductTypeEventsManager extends EntityEventsManager<RCProductType> {
  @Autowired(required = false)
  private Collection<RCProductTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductTypeEventsListener> getListeners() {
    return listeners;
  }
}
