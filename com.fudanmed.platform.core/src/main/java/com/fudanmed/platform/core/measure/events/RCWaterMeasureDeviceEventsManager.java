package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCWaterMeasureDevice;
import com.fudanmed.platform.core.measure.events.RCWaterMeasureDeviceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCWaterMeasureDeviceEventsManager")
public class RCWaterMeasureDeviceEventsManager extends EntityEventsManager<RCWaterMeasureDevice> {
  @Autowired(required = false)
  private Collection<RCWaterMeasureDeviceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWaterMeasureDeviceEventsListener> getListeners() {
    return listeners;
  }
}
