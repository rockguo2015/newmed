package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.events.RCPMDeviceTypeEntryEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCPMDeviceTypeEntryEventsManager")
public class RCPMDeviceTypeEntryEventsManager extends EntityEventsManager<RCPMDeviceTypeEntry> {
  @Autowired(required = false)
  private Collection<RCPMDeviceTypeEntryEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPMDeviceTypeEntryEventsListener> getListeners() {
    return listeners;
  }
}
