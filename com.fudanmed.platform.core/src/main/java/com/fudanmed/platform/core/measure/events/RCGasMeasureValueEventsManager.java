package com.fudanmed.platform.core.measure.events;

import com.fudanmed.platform.core.measure.RCGasMeasureValue;
import com.fudanmed.platform.core.measure.events.RCGasMeasureValueEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.events.RCGasMeasureValueEventsManager")
public class RCGasMeasureValueEventsManager extends EntityEventsManager<RCGasMeasureValue> {
  @Autowired(required = false)
  private Collection<RCGasMeasureValueEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCGasMeasureValueEventsListener> getListeners() {
    return listeners;
  }
}
