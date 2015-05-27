package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.events.RCOrganizationEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCOrganizationEventsManager")
public class RCOrganizationEventsManager extends EntityEventsManager<RCOrganization> {
  @Autowired(required = false)
  private Collection<RCOrganizationEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCOrganizationEventsListener> getListeners() {
    return listeners;
  }
}
