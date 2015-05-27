package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.events.RCPrimaryTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCPrimaryTypeEventsManager")
public class RCPrimaryTypeEventsManager extends EntityEventsManager<RCPrimaryType> {
  @Autowired(required = false)
  private Collection<RCPrimaryTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPrimaryTypeEventsListener> getListeners() {
    return listeners;
  }
}
