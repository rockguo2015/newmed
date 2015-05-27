package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLTaskProtocalSource;
import com.fudanmed.platform.core.deliver.events.DLTaskProtocalSourceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLTaskProtocalSourceEventsManager")
public class DLTaskProtocalSourceEventsManager extends EntityEventsManager<DLTaskProtocalSource> {
  @Autowired(required = false)
  private Collection<DLTaskProtocalSourceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLTaskProtocalSourceEventsListener> getListeners() {
    return listeners;
  }
}
