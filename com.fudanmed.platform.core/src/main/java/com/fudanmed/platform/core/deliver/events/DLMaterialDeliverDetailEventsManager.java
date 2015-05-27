package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLMaterialDeliverDetail;
import com.fudanmed.platform.core.deliver.events.DLMaterialDeliverDetailEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLMaterialDeliverDetailEventsManager")
public class DLMaterialDeliverDetailEventsManager extends EntityEventsManager<DLMaterialDeliverDetail> {
  @Autowired(required = false)
  private Collection<DLMaterialDeliverDetailEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLMaterialDeliverDetailEventsListener> getListeners() {
    return listeners;
  }
}
