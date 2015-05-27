package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.events.RCFaultTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCFaultTypeEventsManager")
public class RCFaultTypeEventsManager extends EntityEventsManager<RCFaultType> {
  @Autowired(required = false)
  private Collection<RCFaultTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCFaultTypeEventsListener> getListeners() {
    return listeners;
  }
}
