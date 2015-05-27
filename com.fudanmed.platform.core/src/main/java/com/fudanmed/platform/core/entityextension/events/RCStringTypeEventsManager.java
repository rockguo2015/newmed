package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCStringType;
import com.fudanmed.platform.core.entityextension.events.RCStringTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCStringTypeEventsManager")
public class RCStringTypeEventsManager extends EntityEventsManager<RCStringType> {
  @Autowired(required = false)
  private Collection<RCStringTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStringTypeEventsListener> getListeners() {
    return listeners;
  }
}
