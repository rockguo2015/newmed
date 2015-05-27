package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCStringValue;
import com.fudanmed.platform.core.entityextension.events.RCStringValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCStringValueEventsManager")
public class RCStringValueEventsManager extends EntityEventsManager<RCStringValue> {
  @Autowired(required = false)
  private Collection<RCStringValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCStringValueEventsListener> getListeners() {
    return listeners;
  }
}
