package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCGasMeasureDeviceType;
import com.fudanmed.platform.core.measure.events.RCGasMeasureDeviceTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCGasMeasureDeviceTypeEventsManager")
public class RCGasMeasureDeviceTypeEventsManager extends EntityEventsManager<RCGasMeasureDeviceType> {
  @Autowired(required = false)
  private Collection<RCGasMeasureDeviceTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCGasMeasureDeviceTypeEventsListener> getListeners() {
    return listeners;
  }
}
