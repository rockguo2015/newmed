package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.events.DLInHospitalPatientEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLInHospitalPatientEventsManager")
public class DLInHospitalPatientEventsManager extends EntityEventsManager<DLInHospitalPatient> {
  @Autowired(required = false)
  private Collection<DLInHospitalPatientEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLInHospitalPatientEventsListener> getListeners() {
    return listeners;
  }
}
