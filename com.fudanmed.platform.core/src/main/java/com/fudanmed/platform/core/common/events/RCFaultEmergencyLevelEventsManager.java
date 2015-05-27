package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCFaultEmergencyLevel;
import com.fudanmed.platform.core.common.events.RCFaultEmergencyLevelEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCFaultEmergencyLevelEventsManager")
public class RCFaultEmergencyLevelEventsManager extends EntityEventsManager<RCFaultEmergencyLevel> {
  @Autowired(required = false)
  private Collection<RCFaultEmergencyLevelEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCFaultEmergencyLevelEventsListener> getListeners() {
    return listeners;
  }
}
