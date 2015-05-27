package com.fudanmed.platform.core.entityextension.events;

import com.fudanmed.platform.core.entityextension.RCRangeType;
import com.fudanmed.platform.core.entityextension.events.RCRangeTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.entityextension.events.RCRangeTypeEventsManager")
public class RCRangeTypeEventsManager extends EntityEventsManager<RCRangeType> {
  @Autowired(required = false)
  private Collection<RCRangeTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCRangeTypeEventsListener> getListeners() {
    return listeners;
  }
}
