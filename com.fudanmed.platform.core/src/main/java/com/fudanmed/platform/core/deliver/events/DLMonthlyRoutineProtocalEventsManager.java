package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLMonthlyRoutineProtocal;
import com.fudanmed.platform.core.deliver.events.DLMonthlyRoutineProtocalEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLMonthlyRoutineProtocalEventsManager")
public class DLMonthlyRoutineProtocalEventsManager extends EntityEventsManager<DLMonthlyRoutineProtocal> {
  @Autowired(required = false)
  private Collection<DLMonthlyRoutineProtocalEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLMonthlyRoutineProtocalEventsListener> getListeners() {
    return listeners;
  }
}
