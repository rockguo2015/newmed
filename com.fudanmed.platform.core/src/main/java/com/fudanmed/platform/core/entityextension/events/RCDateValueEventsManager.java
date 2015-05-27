package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCDateValue;
import com.fudanmed.platform.core.entityextension.events.RCDateValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCDateValueEventsManager")
public class RCDateValueEventsManager extends EntityEventsManager<RCDateValue> {
  @Autowired(required = false)
  private Collection<RCDateValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDateValueEventsListener> getListeners() {
    return listeners;
  }
}
