package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCAttribute;
import com.fudanmed.platform.core.entityextension.events.RCAttributeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCAttributeEventsManager")
public class RCAttributeEventsManager extends EntityEventsManager<RCAttribute> {
  @Autowired(required = false)
  private Collection<RCAttributeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCAttributeEventsListener> getListeners() {
    return listeners;
  }
}
