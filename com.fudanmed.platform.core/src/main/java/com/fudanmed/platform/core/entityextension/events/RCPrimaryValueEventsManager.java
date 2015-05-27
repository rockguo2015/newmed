package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.events.RCPrimaryValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCPrimaryValueEventsManager")
public class RCPrimaryValueEventsManager extends EntityEventsManager<RCPrimaryValue> {
  @Autowired(required = false)
  private Collection<RCPrimaryValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPrimaryValueEventsListener> getListeners() {
    return listeners;
  }
}
