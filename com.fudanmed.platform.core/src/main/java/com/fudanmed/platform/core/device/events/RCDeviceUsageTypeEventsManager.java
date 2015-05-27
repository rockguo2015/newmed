package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDeviceUsageType;
import com.fudanmed.platform.core.device.events.RCDeviceUsageTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceUsageTypeEventsManager")
public class RCDeviceUsageTypeEventsManager extends EntityEventsManager<RCDeviceUsageType> {
  @Autowired(required = false)
  private Collection<RCDeviceUsageTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceUsageTypeEventsListener> getListeners() {
    return listeners;
  }
}
