package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.events.RCNumberWithUnitTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCNumberWithUnitTypeEventsManager")
public class RCNumberWithUnitTypeEventsManager extends EntityEventsManager<RCNumberWithUnitType> {
  @Autowired(required = false)
  private Collection<RCNumberWithUnitTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCNumberWithUnitTypeEventsListener> getListeners() {
    return listeners;
  }
}
