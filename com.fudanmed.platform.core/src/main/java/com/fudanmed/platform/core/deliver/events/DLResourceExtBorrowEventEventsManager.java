package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent;
import com.fudanmed.platform.core.deliver.events.DLResourceExtBorrowEventEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLResourceExtBorrowEventEventsManager")
public class DLResourceExtBorrowEventEventsManager extends EntityEventsManager<DLResourceExtBorrowEvent> {
  @Autowired(required = false)
  private Collection<DLResourceExtBorrowEventEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLResourceExtBorrowEventEventsListener> getListeners() {
    return listeners;
  }
}
