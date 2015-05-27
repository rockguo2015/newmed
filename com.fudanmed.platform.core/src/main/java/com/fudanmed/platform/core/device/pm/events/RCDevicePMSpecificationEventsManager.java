package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.events.RCDevicePMSpecificationEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCDevicePMSpecificationEventsManager")
public class RCDevicePMSpecificationEventsManager extends EntityEventsManager<RCDevicePMSpecification> {
  @Autowired(required = false)
  private Collection<RCDevicePMSpecificationEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDevicePMSpecificationEventsListener> getListeners() {
    return listeners;
  }
}
