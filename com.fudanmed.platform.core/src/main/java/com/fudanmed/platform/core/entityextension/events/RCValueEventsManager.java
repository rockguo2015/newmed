package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.events.RCValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCValueEventsManager")
public class RCValueEventsManager extends EntityEventsManager<RCValue> {
  @Autowired(required = false)
  private Collection<RCValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCValueEventsListener> getListeners() {
    return listeners;
  }
}
