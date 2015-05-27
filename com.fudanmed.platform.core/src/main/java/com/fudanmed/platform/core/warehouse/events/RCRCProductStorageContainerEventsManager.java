package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCRCProductStorageContainer;
import com.fudanmed.platform.core.warehouse.events.RCRCProductStorageContainerEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCRCProductStorageContainerEventsManager")
public class RCRCProductStorageContainerEventsManager extends EntityEventsManager<RCRCProductStorageContainer> {
  @Autowired(required = false)
  private Collection<RCRCProductStorageContainerEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCRCProductStorageContainerEventsListener> getListeners() {
    return listeners;
  }
}
