package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.events.RCPhasedElectricMeasureDeviceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCPhasedElectricMeasureDeviceTypeEventsManager")
public class RCPhasedElectricMeasureDeviceTypeEventsManager extends EntityEventsManager<RCPhasedElectricMeasureDeviceType> {
  @Autowired(required = false)
  private Collection<RCPhasedElectricMeasureDeviceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPhasedElectricMeasureDeviceTypeEventsListener> getListeners() {
    return listeners;
  }
}
