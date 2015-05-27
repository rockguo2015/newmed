package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.events.DLDeliverMaterialTypeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDeliverMaterialTypeEventsManager")
public class DLDeliverMaterialTypeEventsManager extends EntityEventsManager<DLDeliverMaterialType> {
  @Autowired(required = false)
  private Collection<DLDeliverMaterialTypeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDeliverMaterialTypeEventsListener> getListeners() {
    return listeners;
  }
}
