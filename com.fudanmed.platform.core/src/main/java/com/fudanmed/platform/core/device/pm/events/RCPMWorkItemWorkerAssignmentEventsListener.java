package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import edu.fudan.mylang.pf.event.IEntityEventsListner;

public interface RCPMWorkItemWorkerAssignmentEventsListener extends IEntityEventsListner<RCPMWorkItemWorkerAssignment> {
  public abstract void pend(final RCPMWorkItemWorkerAssignment entity);
  
  public abstract void finish(final RCPMWorkItemWorkerAssignment entity);
}
