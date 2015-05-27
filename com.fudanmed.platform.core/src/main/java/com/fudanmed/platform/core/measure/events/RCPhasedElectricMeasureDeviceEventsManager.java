package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.measure.events.RCPhasedElectricMeasureDeviceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCPhasedElectricMeasureDeviceEventsManager")
public class RCPhasedElectricMeasureDeviceEventsManager extends EntityEventsManager<RCPhasedElectricMeasureDevice> {
  @Autowired(required = false)
  private Collection<RCPhasedElectricMeasureDeviceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPhasedElectricMeasureDeviceEventsListener> getListeners() {
    return listeners;
  }
}
