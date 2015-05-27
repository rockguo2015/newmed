package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.events.DLPatientCheckDeliverEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLPatientCheckDeliverEventsManager")
public class DLPatientCheckDeliverEventsManager extends EntityEventsManager<DLPatientCheckDeliver> {
  @Autowired(required = false)
  private Collection<DLPatientCheckDeliverEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLPatientCheckDeliverEventsListener> getListeners() {
    return listeners;
  }
}
