package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.events.DLDeliverMaterialCategoryEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDeliverMaterialCategoryEventsManager")
public class DLDeliverMaterialCategoryEventsManager extends EntityEventsManager<DLDeliverMaterialCategory> {
  @Autowired(required = false)
  private Collection<DLDeliverMaterialCategoryEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDeliverMaterialCategoryEventsListener> getListeners() {
    return listeners;
  }
}
