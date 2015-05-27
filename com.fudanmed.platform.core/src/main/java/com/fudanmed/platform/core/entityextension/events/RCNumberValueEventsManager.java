package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCNumberValue;
import com.fudanmed.platform.core.entityextension.events.RCNumberValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCNumberValueEventsManager")
public class RCNumberValueEventsManager extends EntityEventsManager<RCNumberValue> {
  @Autowired(required = false)
  private Collection<RCNumberValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCNumberValueEventsListener> getListeners() {
    return listeners;
  }
}
