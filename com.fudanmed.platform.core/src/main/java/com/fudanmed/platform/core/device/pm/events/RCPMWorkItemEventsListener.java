package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import edu.fudan.mylang.pf.event.IEntityEventsListner;
import java.util.Date;

public interface RCPMWorkItemEventsListener extends IEntityEventsListner<RCPMWorkItem> {
  public abstract void assignTeam(final RCPMWorkItem entity);
  
  public abstract void workersAssigned(final RCPMWorkItem entity);
  
  public abstract void teamFinish(final RCPMWorkItem entity, final Date finishDate, final String comment);
  
  public abstract void finish(final RCPMWorkItem entity);
  
  public abstract void assignPlan(final RCPMWorkItem entity, final RCDevicePMPlan plan);
  
  public abstract void deassignPlan(final RCPMWorkItem entity, final RCDevicePMPlan plan);
  
  public abstract void $workerAssignmentFinish(final RCPMWorkItem entity);
}
