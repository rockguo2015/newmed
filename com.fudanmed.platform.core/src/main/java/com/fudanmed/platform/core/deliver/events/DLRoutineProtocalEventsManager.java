package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.events.DLRoutineProtocalEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLRoutineProtocalEventsManager")
public class DLRoutineProtocalEventsManager extends EntityEventsManager<DLRoutineProtocal> {
  @Autowired(required = false)
  private Collection<DLRoutineProtocalEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLRoutineProtocalEventsListener> getListeners() {
    return listeners;
  }
}
