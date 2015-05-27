package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCNumberType;
import com.fudanmed.platform.core.entityextension.events.RCNumberTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCNumberTypeEventsManager")
public class RCNumberTypeEventsManager extends EntityEventsManager<RCNumberType> {
  @Autowired(required = false)
  private Collection<RCNumberTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCNumberTypeEventsListener> getListeners() {
    return listeners;
  }
}
