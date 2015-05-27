package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDeviceTypePicture;
import com.fudanmed.platform.core.device.events.RCDeviceTypePictureEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceTypePictureEventsManager")
public class RCDeviceTypePictureEventsManager extends EntityEventsManager<RCDeviceTypePicture> {
  @Autowired(required = false)
  private Collection<RCDeviceTypePictureEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceTypePictureEventsListener> getListeners() {
    return listeners;
  }
}
