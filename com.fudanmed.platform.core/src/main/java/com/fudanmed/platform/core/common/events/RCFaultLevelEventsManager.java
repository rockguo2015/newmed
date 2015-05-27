package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.events.RCFaultLevelEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCFaultLevelEventsManager")
public class RCFaultLevelEventsManager extends EntityEventsManager<RCFaultLevel> {
  @Autowired(required = false)
  private Collection<RCFaultLevelEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCFaultLevelEventsListener> getListeners() {
    return listeners;
  }
}
