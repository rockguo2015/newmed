package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.events.RCMaintenamceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCMaintenamceTypeEventsManager")
public class RCMaintenamceTypeEventsManager extends EntityEventsManager<RCMaintenamceType> {
  @Autowired(required = false)
  private Collection<RCMaintenamceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCMaintenamceTypeEventsListener> getListeners() {
    return listeners;
  }
}
