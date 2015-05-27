package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.events.RCProduceSpecificationUnitEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProduceSpecificationUnitEventsManager")
public class RCProduceSpecificationUnitEventsManager extends EntityEventsManager<RCProduceSpecificationUnit> {
  @Autowired(required = false)
  private Collection<RCProduceSpecificationUnitEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProduceSpecificationUnitEventsListener> getListeners() {
    return listeners;
  }
}
