package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.events.RCExtensiableEntityTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCExtensiableEntityTypeEventsManager")
public class RCExtensiableEntityTypeEventsManager extends EntityEventsManager<RCExtensiableEntityType> {
  @Autowired(required = false)
  private Collection<RCExtensiableEntityTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCExtensiableEntityTypeEventsListener> getListeners() {
    return listeners;
  }
}
