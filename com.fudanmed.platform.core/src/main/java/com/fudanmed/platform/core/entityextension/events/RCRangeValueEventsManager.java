package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCRangeValue;
import com.fudanmed.platform.core.entityextension.events.RCRangeValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCRangeValueEventsManager")
public class RCRangeValueEventsManager extends EntityEventsManager<RCRangeValue> {
  @Autowired(required = false)
  private Collection<RCRangeValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCRangeValueEventsListener> getListeners() {
    return listeners;
  }
}
