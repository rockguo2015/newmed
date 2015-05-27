package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.events.RCDeviceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceEventsManager")
public class RCDeviceEventsManager extends EntityEventsManager<RCDevice> {
  @Autowired(required = false)
  private Collection<RCDeviceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceEventsListener> getListeners() {
    return listeners;
  }
}
