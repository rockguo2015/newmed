package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDevicePicture;
import com.fudanmed.platform.core.device.events.RCDevicePictureEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDevicePictureEventsManager")
public class RCDevicePictureEventsManager extends EntityEventsManager<RCDevicePicture> {
  @Autowired(required = false)
  private Collection<RCDevicePictureEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDevicePictureEventsListener> getListeners() {
    return listeners;
  }
}
