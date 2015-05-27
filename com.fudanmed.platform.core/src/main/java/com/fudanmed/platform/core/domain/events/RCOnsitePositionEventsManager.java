package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.events.RCOnsitePositionEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCOnsitePositionEventsManager")
public class RCOnsitePositionEventsManager extends EntityEventsManager<RCOnsitePosition> {
  @Autowired(required = false)
  private Collection<RCOnsitePositionEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCOnsitePositionEventsListener> getListeners() {
    return listeners;
  }
}
