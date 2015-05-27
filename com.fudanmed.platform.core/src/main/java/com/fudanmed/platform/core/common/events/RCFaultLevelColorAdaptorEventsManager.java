package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.common.events.RCFaultLevelColorAdaptorEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCFaultLevelColorAdaptorEventsManager")
public class RCFaultLevelColorAdaptorEventsManager extends EntityEventsManager<RCFaultLevelColorAdaptor> {
  @Autowired(required = false)
  private Collection<RCFaultLevelColorAdaptorEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCFaultLevelColorAdaptorEventsListener> getListeners() {
    return listeners;
  }
}
