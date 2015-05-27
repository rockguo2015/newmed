package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.events.RCDevicePMTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCDevicePMTypeEventsManager")
public class RCDevicePMTypeEventsManager extends EntityEventsManager<RCDevicePMType> {
  @Autowired(required = false)
  private Collection<RCDevicePMTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDevicePMTypeEventsListener> getListeners() {
    return listeners;
  }
}
