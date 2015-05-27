package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.events.RCElectricMeasureDeviceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCElectricMeasureDeviceTypeEventsManager")
public class RCElectricMeasureDeviceTypeEventsManager extends EntityEventsManager<RCElectricMeasureDeviceType> {
  @Autowired(required = false)
  private Collection<RCElectricMeasureDeviceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCElectricMeasureDeviceTypeEventsListener> getListeners() {
    return listeners;
  }
}
