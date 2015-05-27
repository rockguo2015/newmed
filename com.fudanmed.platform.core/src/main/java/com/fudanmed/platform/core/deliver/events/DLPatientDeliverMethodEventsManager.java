package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.events.DLPatientDeliverMethodEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLPatientDeliverMethodEventsManager")
public class DLPatientDeliverMethodEventsManager extends EntityEventsManager<DLPatientDeliverMethod> {
  @Autowired(required = false)
  private Collection<DLPatientDeliverMethodEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLPatientDeliverMethodEventsListener> getListeners() {
    return listeners;
  }
}
