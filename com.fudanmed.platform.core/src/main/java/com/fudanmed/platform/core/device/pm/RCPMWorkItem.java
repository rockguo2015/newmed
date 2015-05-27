package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemEvaluate;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemSMState;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemStatue;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCSupplier;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@EntityImplementation(implementBy = RCPMWorkItemImpl.class)
public interface RCPMWorkItem extends IModelObject {
  public abstract String getTitle();
  
  public abstract RCPMWorkItem setTitle(final String title);
  
  public abstract String getDescription();
  
  public abstract RCPMWorkItem setDescription(final String description);
  
  public abstract String getSid();
  
  public abstract RCPMWorkItem setSid(final String sid);
  
  public abstract Date getAssignDate();
  
  public abstract RCPMWorkItem setAssignDate(final Date assignDate);
  
  public abstract RCSupplier getSupplier();
  
  public abstract RCPMWorkItem setSupplier(final RCSupplier supplier);
  
  public abstract Collection<RCWorkItemPlanAssignment> getAssignments();
  
  public abstract RCWorkItemPlanAssignment createAndAddtoAssignments();
  
  public abstract RCPMWorkItem removeFromAssignments(final RCWorkItemPlanAssignment rCWorkItemPlanAssignment);
  
  public abstract RCPMWorkItem removeAllAssignments();
  
  public abstract Collection<RCPMWorkItemWorkerAssignment> getWorkerAssignment();
  
  public abstract RCPMWorkItemWorkerAssignment createAndAddtoWorkerAssignment();
  
  public abstract RCPMWorkItem removeFromWorkerAssignment(final RCPMWorkItemWorkerAssignment rCPMWorkItemWorkerAssignment);
  
  public abstract RCPMWorkItem removeAllWorkerAssignment();
  
  public abstract RCPMWorkItemStatue getStatus();
  
  public abstract RCPMWorkItem setStatus(final RCPMWorkItemStatue status);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCPMWorkItem setTeam(final RCMaintenanceTeam team);
  
  public abstract String getTeamComment();
  
  public abstract RCPMWorkItem setTeamComment(final String teamComment);
  
  public abstract Date getFinishDate();
  
  public abstract RCPMWorkItem setFinishDate(final Date finishDate);
  
  public abstract Date getDispatchDate();
  
  public abstract RCPMWorkItem setDispatchDate(final Date dispatchDate);
  
  public abstract RCPMWorkItemEvaluate getEvaluate();
  
  public abstract RCPMWorkItem setEvaluate(final RCPMWorkItemEvaluate evaluate);
  
  public abstract Boolean allTaskAssigned();
  
  public abstract Boolean allWorkerTaskFinished();
  
  public abstract void assignWorker(final Collection<RCWorkItemPlanAssignment> workItemPlanAssignments, final Procedure1<? super RCPMWorkItemWorkerAssignment> postInit);
  
  public abstract RCPMWorkItemSMState getSMState();
  
  public abstract void start();
  
  public abstract void assignPlan(final RCDevicePMPlan plan);
  
  public abstract void deassignPlan(final RCDevicePMPlan plan);
  
  public abstract void assignTeam();
  
  public abstract void workersAssigned();
  
  public abstract void $workerAssignmentFinish();
  
  public abstract void teamFinish(final Date finishDate, final String comment);
  
  public abstract void finish();
  
  public abstract Boolean isPlaned();
  
  public abstract Boolean isTeamAssigned();
  
  public abstract Boolean isExecuting();
  
  public abstract Boolean isTeamFinished();
  
  public abstract Boolean isFinished();
  
  public abstract Boolean isPartialExecuting();
  
  public abstract Boolean isReady4TeamFinishReport();
  
  public abstract RCPMWorkItemProxy toProxy();
}
