package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDeliverEmergency;
import com.fudanmed.platform.core.deliver.events.DLDeliverEmergencyEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDeliverEmergencyEventsManager")
public class DLDeliverEmergencyEventsManager extends EntityEventsManager<DLDeliverEmergency> {
  @Autowired(required = false)
  private Collection<DLDeliverEmergencyEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDeliverEmergencyEventsListener> getListeners() {
    return listeners;
  }
}
