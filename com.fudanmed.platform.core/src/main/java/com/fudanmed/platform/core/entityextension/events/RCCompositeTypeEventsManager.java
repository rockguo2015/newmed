package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCCompositeType;
import com.fudanmed.platform.core.entityextension.events.RCCompositeTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCCompositeTypeEventsManager")
public class RCCompositeTypeEventsManager extends EntityEventsManager<RCCompositeType> {
  @Autowired(required = false)
  private Collection<RCCompositeTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCCompositeTypeEventsListener> getListeners() {
    return listeners;
  }
}
