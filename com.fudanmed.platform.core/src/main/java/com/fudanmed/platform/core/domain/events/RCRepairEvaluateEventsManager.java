package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.domain.events.RCRepairEvaluateEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCRepairEvaluateEventsManager")
public class RCRepairEvaluateEventsManager extends EntityEventsManager<RCRepairEvaluate> {
  @Autowired(required = false)
  private Collection<RCRepairEvaluateEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCRepairEvaluateEventsListener> getListeners() {
    return listeners;
  }
}
