package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCElectricMeasureValue;
import com.fudanmed.platform.core.measure.events.RCElectricMeasureValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCElectricMeasureValueEventsManager")
public class RCElectricMeasureValueEventsManager extends EntityEventsManager<RCElectricMeasureValue> {
  @Autowired(required = false)
  private Collection<RCElectricMeasureValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCElectricMeasureValueEventsListener> getListeners() {
    return listeners;
  }
}
