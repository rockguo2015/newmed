package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.events.DLInHospitalLocationEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLInHospitalLocationEventsManager")
public class DLInHospitalLocationEventsManager extends EntityEventsManager<DLInHospitalLocation> {
  @Autowired(required = false)
  private Collection<DLInHospitalLocationEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLInHospitalLocationEventsListener> getListeners() {
    return listeners;
  }
}
