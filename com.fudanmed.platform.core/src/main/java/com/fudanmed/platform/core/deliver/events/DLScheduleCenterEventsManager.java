package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLScheduleCenter;
import com.fudanmed.platform.core.deliver.events.DLScheduleCenterEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLScheduleCenterEventsManager")
public class DLScheduleCenterEventsManager extends EntityEventsManager<DLScheduleCenter> {
  @Autowired(required = false)
  private Collection<DLScheduleCenterEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLScheduleCenterEventsListener> getListeners() {
    return listeners;
  }
}
