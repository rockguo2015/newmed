package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue;
import com.fudanmed.platform.core.measure.events.RCPhasedElectricMeasureValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCPhasedElectricMeasureValueEventsManager")
public class RCPhasedElectricMeasureValueEventsManager extends EntityEventsManager<RCPhasedElectricMeasureValue> {
  @Autowired(required = false)
  private Collection<RCPhasedElectricMeasureValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPhasedElectricMeasureValueEventsListener> getListeners() {
    return listeners;
  }
}
