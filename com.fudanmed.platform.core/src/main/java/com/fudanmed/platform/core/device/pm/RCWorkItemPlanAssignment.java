package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.impl.RCWorkItemPlanAssignmentImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCWorkItemPlanAssignmentImpl.class)
public interface RCWorkItemPlanAssignment extends IModelObject {
  public abstract RCDevicePMPlan getPlan();
  
  public abstract RCWorkItemPlanAssignment setPlan(final RCDevicePMPlan plan);
  
  public abstract RCPMWorkItem getWorkitem();
  
  public abstract RCWorkItemPlanAssignment setWorkitem(final RCPMWorkItem workitem);
  
  public abstract RCPMWorkItemWorkerAssignment getWorkerAssignment();
  
  public abstract RCWorkItemPlanAssignment setWorkerAssignment(final RCPMWorkItemWorkerAssignment workerAssignment);
  
  public abstract RCWorkItemPlanAssignmentProxy toProxy();
}
