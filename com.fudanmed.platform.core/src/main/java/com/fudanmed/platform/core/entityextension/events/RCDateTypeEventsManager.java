package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCDateType;
import com.fudanmed.platform.core.entityextension.events.RCDateTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCDateTypeEventsManager")
public class RCDateTypeEventsManager extends EntityEventsManager<RCDateType> {
  @Autowired(required = false)
  private Collection<RCDateTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDateTypeEventsListener> getListeners() {
    return listeners;
  }
}
