package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent;
import com.fudanmed.platform.core.deliver.events.DLPatientCheckDeliverTaskEventEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLPatientCheckDeliverTaskEventEventsManager")
public class DLPatientCheckDeliverTaskEventEventsManager extends EntityEventsManager<DLPatientCheckDeliverTaskEvent> {
  @Autowired(required = false)
  private Collection<DLPatientCheckDeliverTaskEventEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLPatientCheckDeliverTaskEventEventsListener> getListeners() {
    return listeners;
  }
}
