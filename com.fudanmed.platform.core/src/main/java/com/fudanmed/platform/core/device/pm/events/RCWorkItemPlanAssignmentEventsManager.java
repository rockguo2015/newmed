package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.events.RCWorkItemPlanAssignmentEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCWorkItemPlanAssignmentEventsManager")
public class RCWorkItemPlanAssignmentEventsManager extends EntityEventsManager<RCWorkItemPlanAssignment> {
  @Autowired(required = false)
  private Collection<RCWorkItemPlanAssignmentEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemPlanAssignmentEventsListener> getListeners() {
    return listeners;
  }
}
