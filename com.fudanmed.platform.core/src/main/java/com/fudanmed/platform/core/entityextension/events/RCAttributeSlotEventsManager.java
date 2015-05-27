package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCAttributeSlot;
import com.fudanmed.platform.core.entityextension.events.RCAttributeSlotEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCAttributeSlotEventsManager")
public class RCAttributeSlotEventsManager extends EntityEventsManager<RCAttributeSlot> {
  @Autowired(required = false)
  private Collection<RCAttributeSlotEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCAttributeSlotEventsListener> getListeners() {
    return listeners;
  }
}
