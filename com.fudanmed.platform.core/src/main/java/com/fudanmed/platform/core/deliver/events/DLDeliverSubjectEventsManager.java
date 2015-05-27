package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.events.DLDeliverSubjectEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDeliverSubjectEventsManager")
public class DLDeliverSubjectEventsManager extends EntityEventsManager<DLDeliverSubject> {
  @Autowired(required = false)
  private Collection<DLDeliverSubjectEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDeliverSubjectEventsListener> getListeners() {
    return listeners;
  }
}
