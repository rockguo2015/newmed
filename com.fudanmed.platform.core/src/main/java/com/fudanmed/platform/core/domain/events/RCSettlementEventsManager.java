package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.events.RCSettlementEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCSettlementEventsManager")
public class RCSettlementEventsManager extends EntityEventsManager<RCSettlement> {
  @Autowired(required = false)
  private Collection<RCSettlementEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCSettlementEventsListener> getListeners() {
    return listeners;
  }
}
