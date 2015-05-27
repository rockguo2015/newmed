package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLMaterialDeliver;
import com.fudanmed.platform.core.deliver.events.DLMaterialDeliverEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLMaterialDeliverEventsManager")
public class DLMaterialDeliverEventsManager extends EntityEventsManager<DLMaterialDeliver> {
  @Autowired(required = false)
  private Collection<DLMaterialDeliverEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLMaterialDeliverEventsListener> getListeners() {
    return listeners;
  }
}
