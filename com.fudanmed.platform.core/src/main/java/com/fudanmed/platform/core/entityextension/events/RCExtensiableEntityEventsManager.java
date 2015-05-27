package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.events.RCExtensiableEntityEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCExtensiableEntityEventsManager")
public class RCExtensiableEntityEventsManager extends EntityEventsManager<RCExtensiableEntity> {
  @Autowired(required = false)
  private Collection<RCExtensiableEntityEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCExtensiableEntityEventsListener> getListeners() {
    return listeners;
  }
}
