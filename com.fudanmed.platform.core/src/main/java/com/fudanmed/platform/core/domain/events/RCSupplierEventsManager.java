package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.events.RCSupplierEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCSupplierEventsManager")
public class RCSupplierEventsManager extends EntityEventsManager<RCSupplier> {
  @Autowired(required = false)
  private Collection<RCSupplierEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCSupplierEventsListener> getListeners() {
    return listeners;
  }
}
