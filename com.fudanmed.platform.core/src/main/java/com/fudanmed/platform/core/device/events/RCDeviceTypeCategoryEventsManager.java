package com.fudanmed.platform.core.device.events;

import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.events.RCDeviceTypeCategoryEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.events.RCDeviceTypeCategoryEventsManager")
public class RCDeviceTypeCategoryEventsManager extends EntityEventsManager<RCDeviceTypeCategory> {
  @Autowired(required = false)
  private Collection<RCDeviceTypeCategoryEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDeviceTypeCategoryEventsListener> getListeners() {
    return listeners;
  }
}
