package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentSMState;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignmentStatus;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemWorkerAssignmentImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;

@EntityImplementation(implementBy = RCPMWorkItemWorkerAssignmentImpl.class)
public interface RCPMWorkItemWorkerAssignment extends IModelObject {
  public abstract RCPMWorkItem getWorkitem();
  
  public abstract RCPMWorkItemWorkerAssignment setWorkitem(final RCPMWorkItem workitem);
  
  public abstract Collection<RCEmployee> getWorkers();
  
  public abstract RCPMWorkItemWorkerAssignment addtoWorkers(final RCEmployee rCEmployee);
  
  public abstract RCPMWorkItemWorkerAssignment setWorkers(final Iterable<RCEmployee> workers);
  
  public abstract RCPMWorkItemWorkerAssignment removeFromWorkers(final RCEmployee rCEmployee);
  
  public abstract RCPMWorkItemWorkerAssignment removeAllWorkers();
  
  public abstract Date getAssignDate();
  
  public abstract RCPMWorkItemWorkerAssignment setAssignDate(final Date assignDate);
  
  public abstract Date getFinishDate();
  
  public abstract RCPMWorkItemWorkerAssignment setFinishDate(final Date finishDate);
  
  public abstract String getComment();
  
  public abstract RCPMWorkItemWorkerAssignment setComment(final String comment);
  
  public abstract String getFinalComment();
  
  public abstract RCPMWorkItemWorkerAssignment setFinalComment(final String finalComment);
  
  public abstract RCPMWorkItemWorkerAssignmentStatus getStatus();
  
  public abstract RCPMWorkItemWorkerAssignment setStatus(final RCPMWorkItemWorkerAssignmentStatus status);
  
  public abstract Collection<RCWorkItemPlanAssignment> getWorkItemPlanAssignments();
  
  public abstract Boolean getAllTaskFinished();
  
  public abstract RCPMWorkItemWorkerAssignmentSMState getSMState();
  
  public abstract void start();
  
  public abstract void pend();
  
  public abstract void finish();
  
  public abstract Boolean isPlaned();
  
  public abstract Boolean isPending();
  
  public abstract Boolean isFinished();
  
  public abstract RCPMWorkItemWorkerAssignmentProxy toProxy();
}
