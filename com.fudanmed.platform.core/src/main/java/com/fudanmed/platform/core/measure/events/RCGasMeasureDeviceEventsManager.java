package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCGasMeasureDevice;
import com.fudanmed.platform.core.measure.events.RCGasMeasureDeviceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCGasMeasureDeviceEventsManager")
public class RCGasMeasureDeviceEventsManager extends EntityEventsManager<RCGasMeasureDevice> {
  @Autowired(required = false)
  private Collection<RCGasMeasureDeviceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCGasMeasureDeviceEventsListener> getListeners() {
    return listeners;
  }
}
