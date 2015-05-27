package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.events.RCTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCTypeEventsManager")
public class RCTypeEventsManager extends EntityEventsManager<RCType> {
  @Autowired(required = false)
  private Collection<RCTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCTypeEventsListener> getListeners() {
    return listeners;
  }
}
