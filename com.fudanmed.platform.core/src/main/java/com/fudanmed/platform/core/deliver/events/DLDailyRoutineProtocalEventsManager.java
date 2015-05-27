package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDailyRoutineProtocal;
import com.fudanmed.platform.core.deliver.events.DLDailyRoutineProtocalEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDailyRoutineProtocalEventsManager")
public class DLDailyRoutineProtocalEventsManager extends EntityEventsManager<DLDailyRoutineProtocal> {
  @Autowired(required = false)
  private Collection<DLDailyRoutineProtocalEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDailyRoutineProtocalEventsListener> getListeners() {
    return listeners;
  }
}
