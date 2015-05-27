package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLWeeklyRoutineProtocal;
import com.fudanmed.platform.core.deliver.events.DLWeeklyRoutineProtocalEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLWeeklyRoutineProtocalEventsManager")
public class DLWeeklyRoutineProtocalEventsManager extends EntityEventsManager<DLWeeklyRoutineProtocal> {
  @Autowired(required = false)
  private Collection<DLWeeklyRoutineProtocalEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLWeeklyRoutineProtocalEventsListener> getListeners() {
    return listeners;
  }
}
