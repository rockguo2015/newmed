package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDeviceIndicator;
import com.fudanmed.platform.core.device.events.RCDeviceIndicatorEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceIndicatorEventsManager")
public class RCDeviceIndicatorEventsManager extends EntityEventsManager<RCDeviceIndicator> {
  @Autowired(required = false)
  private Collection<RCDeviceIndicatorEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceIndicatorEventsListener> getListeners() {
    return listeners;
  }
}
