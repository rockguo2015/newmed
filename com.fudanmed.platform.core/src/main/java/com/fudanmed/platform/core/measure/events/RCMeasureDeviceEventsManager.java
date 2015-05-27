package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.events.RCMeasureDeviceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCMeasureDeviceEventsManager")
public class RCMeasureDeviceEventsManager extends EntityEventsManager<RCMeasureDevice> {
  @Autowired(required = false)
  private Collection<RCMeasureDeviceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCMeasureDeviceEventsListener> getListeners() {
    return listeners;
  }
}
