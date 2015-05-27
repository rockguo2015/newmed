package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue;
import com.fudanmed.platform.core.entityextension.events.RCNumberWithUnitValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCNumberWithUnitValueEventsManager")
public class RCNumberWithUnitValueEventsManager extends EntityEventsManager<RCNumberWithUnitValue> {
  @Autowired(required = false)
  private Collection<RCNumberWithUnitValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCNumberWithUnitValueEventsListener> getListeners() {
    return listeners;
  }
}
