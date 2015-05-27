package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLTaskSource4CustomerRequest;
import com.fudanmed.platform.core.deliver.events.DLTaskSource4CustomerRequestEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLTaskSource4CustomerRequestEventsManager")
public class DLTaskSource4CustomerRequestEventsManager extends EntityEventsManager<DLTaskSource4CustomerRequest> {
  @Autowired(required = false)
  private Collection<DLTaskSource4CustomerRequestEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLTaskSource4CustomerRequestEventsListener> getListeners() {
    return listeners;
  }
}
