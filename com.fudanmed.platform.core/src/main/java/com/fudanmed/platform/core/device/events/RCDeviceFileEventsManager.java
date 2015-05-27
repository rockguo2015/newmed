package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDeviceFile;
import com.fudanmed.platform.core.device.events.RCDeviceFileEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceFileEventsManager")
public class RCDeviceFileEventsManager extends EntityEventsManager<RCDeviceFile> {
  @Autowired(required = false)
  private Collection<RCDeviceFileEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceFileEventsListener> getListeners() {
    return listeners;
  }
}
