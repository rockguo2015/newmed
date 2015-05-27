package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCAcquireType;
import com.fudanmed.platform.core.device.events.RCAcquireTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCAcquireTypeEventsManager")
public class RCAcquireTypeEventsManager extends EntityEventsManager<RCAcquireType> {
  @Autowired(required = false)
  private Collection<RCAcquireTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCAcquireTypeEventsListener> getListeners() {
    return listeners;
  }
}
