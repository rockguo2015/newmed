package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType;
import com.fudanmed.platform.core.measure.events.RCWaterMeasureDeviceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCWaterMeasureDeviceTypeEventsManager")
public class RCWaterMeasureDeviceTypeEventsManager extends EntityEventsManager<RCWaterMeasureDeviceType> {
  @Autowired(required = false)
  private Collection<RCWaterMeasureDeviceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWaterMeasureDeviceTypeEventsListener> getListeners() {
    return listeners;
  }
}
