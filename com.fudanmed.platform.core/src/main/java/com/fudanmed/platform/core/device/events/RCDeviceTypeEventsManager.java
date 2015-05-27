package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.events.RCDeviceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceTypeEventsManager")
public class RCDeviceTypeEventsManager extends EntityEventsManager<RCDeviceType> {
  @Autowired(required = false)
  private Collection<RCDeviceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceTypeEventsListener> getListeners() {
    return listeners;
  }
}
