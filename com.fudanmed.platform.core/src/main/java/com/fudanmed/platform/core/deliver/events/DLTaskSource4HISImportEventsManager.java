package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLTaskSource4HISImport;
import com.fudanmed.platform.core.deliver.events.DLTaskSource4HISImportEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLTaskSource4HISImportEventsManager")
public class DLTaskSource4HISImportEventsManager extends EntityEventsManager<DLTaskSource4HISImport> {
  @Autowired(required = false)
  private Collection<DLTaskSource4HISImportEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLTaskSource4HISImportEventsListener> getListeners() {
    return listeners;
  }
}
