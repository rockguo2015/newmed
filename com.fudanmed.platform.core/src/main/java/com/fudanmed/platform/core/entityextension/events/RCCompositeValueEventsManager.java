package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.events.RCCompositeValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCCompositeValueEventsManager")
public class RCCompositeValueEventsManager extends EntityEventsManager<RCCompositeValue> {
  @Autowired(required = false)
  private Collection<RCCompositeValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCCompositeValueEventsListener> getListeners() {
    return listeners;
  }
}
