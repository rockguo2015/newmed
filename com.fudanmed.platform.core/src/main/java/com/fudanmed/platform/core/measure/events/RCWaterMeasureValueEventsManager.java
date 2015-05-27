package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.measure.events.RCWaterMeasureValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCWaterMeasureValueEventsManager")
public class RCWaterMeasureValueEventsManager extends EntityEventsManager<RCWaterMeasureValue> {
  @Autowired(required = false)
  private Collection<RCWaterMeasureValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWaterMeasureValueEventsListener> getListeners() {
    return listeners;
  }
}
