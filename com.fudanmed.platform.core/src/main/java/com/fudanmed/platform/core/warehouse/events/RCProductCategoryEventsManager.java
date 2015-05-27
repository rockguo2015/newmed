package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.events.RCProductCategoryEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductCategoryEventsManager")
public class RCProductCategoryEventsManager extends EntityEventsManager<RCProductCategory> {
  @Autowired(required = false)
  private Collection<RCProductCategoryEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductCategoryEventsListener> getListeners() {
    return listeners;
  }
}
