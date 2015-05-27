package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLSingleDayProtocal;
import com.fudanmed.platform.core.deliver.events.DLSingleDayProtocalEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLSingleDayProtocalEventsManager")
public class DLSingleDayProtocalEventsManager extends EntityEventsManager<DLSingleDayProtocal> {
  @Autowired(required = false)
  private Collection<DLSingleDayProtocalEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLSingleDayProtocalEventsListener> getListeners() {
    return listeners;
  }
}
