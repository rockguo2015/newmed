package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.events.RCEmployeeUserEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCEmployeeUserEventsManager")
public class RCEmployeeUserEventsManager extends EntityEventsManager<RCEmployeeUser> {
  @Autowired(required = false)
  private Collection<RCEmployeeUserEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCEmployeeUserEventsListener> getListeners() {
    return listeners;
  }
}
