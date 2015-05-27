package com.fudanmed.platform.core.common.events;

import com.fudanmed.platform.core.common.RCWorkType;
import com.fudanmed.platform.core.common.events.RCWorkTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.events.RCWorkTypeEventsManager")
public class RCWorkTypeEventsManager extends EntityEventsManager<RCWorkType> {
  @Autowired(required = false)
  private Collection<RCWorkTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkTypeEventsListener> getListeners() {
    return listeners;
  }
}
