package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDeviceTypeFile;
import com.fudanmed.platform.core.device.events.RCDeviceTypeFileEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceTypeFileEventsManager")
public class RCDeviceTypeFileEventsManager extends EntityEventsManager<RCDeviceTypeFile> {
  @Autowired(required = false)
  private Collection<RCDeviceTypeFileEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceTypeFileEventsListener> getListeners() {
    return listeners;
  }
}
