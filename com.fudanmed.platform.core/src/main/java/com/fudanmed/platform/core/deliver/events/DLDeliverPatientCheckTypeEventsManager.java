package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.events.DLDeliverPatientCheckTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDeliverPatientCheckTypeEventsManager")
public class DLDeliverPatientCheckTypeEventsManager extends EntityEventsManager<DLDeliverPatientCheckType> {
  @Autowired(required = false)
  private Collection<DLDeliverPatientCheckTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDeliverPatientCheckTypeEventsListener> getListeners() {
    return listeners;
  }
}
