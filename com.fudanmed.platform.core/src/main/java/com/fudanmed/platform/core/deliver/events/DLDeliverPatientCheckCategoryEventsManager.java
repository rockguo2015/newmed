package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.events.DLDeliverPatientCheckCategoryEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDeliverPatientCheckCategoryEventsManager")
public class DLDeliverPatientCheckCategoryEventsManager extends EntityEventsManager<DLDeliverPatientCheckCategory> {
  @Autowired(required = false)
  private Collection<DLDeliverPatientCheckCategoryEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDeliverPatientCheckCategoryEventsListener> getListeners() {
    return listeners;
  }
}
