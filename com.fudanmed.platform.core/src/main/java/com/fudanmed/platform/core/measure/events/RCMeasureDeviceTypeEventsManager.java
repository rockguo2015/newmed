package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.events.RCMeasureDeviceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCMeasureDeviceTypeEventsManager")
public class RCMeasureDeviceTypeEventsManager extends EntityEventsManager<RCMeasureDeviceType> {
  @Autowired(required = false)
  private Collection<RCMeasureDeviceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCMeasureDeviceTypeEventsListener> getListeners() {
    return listeners;
  }
}
