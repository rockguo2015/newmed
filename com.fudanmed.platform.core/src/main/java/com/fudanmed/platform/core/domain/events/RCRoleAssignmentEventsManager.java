package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCRoleAssignment;
import com.fudanmed.platform.core.domain.events.RCRoleAssignmentEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCRoleAssignmentEventsManager")
public class RCRoleAssignmentEventsManager extends EntityEventsManager<RCRoleAssignment> {
  @Autowired(required = false)
  private Collection<RCRoleAssignmentEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCRoleAssignmentEventsListener> getListeners() {
    return listeners;
  }
}
