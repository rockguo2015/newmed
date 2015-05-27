package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.events.RCMeasureValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCMeasureValueEventsManager")
public class RCMeasureValueEventsManager extends EntityEventsManager<RCMeasureValue> {
  @Autowired(required = false)
  private Collection<RCMeasureValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCMeasureValueEventsListener> getListeners() {
    return listeners;
  }
}
