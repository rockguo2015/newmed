package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCElectricMeasureDevice;
import com.fudanmed.platform.core.measure.events.RCElectricMeasureDeviceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCElectricMeasureDeviceEventsManager")
public class RCElectricMeasureDeviceEventsManager extends EntityEventsManager<RCElectricMeasureDevice> {
  @Autowired(required = false)
  private Collection<RCElectricMeasureDeviceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCElectricMeasureDeviceEventsListener> getListeners() {
    return listeners;
  }
}
