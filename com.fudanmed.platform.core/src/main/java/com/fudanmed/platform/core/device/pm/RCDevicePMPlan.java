package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlanSMStatus;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanStatus;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = RCDevicePMPlanImpl.class)
public interface RCDevicePMPlan extends IModelObject {
  public abstract RCDevicePMSpecification getSpec();
  
  public abstract RCDevicePMPlan setSpec(final RCDevicePMSpecification spec);
  
  public abstract Date getPlanDate();
  
  public abstract RCDevicePMPlan setPlanDate(final Date planDate);
  
  public abstract Date getFinishDate();
  
  public abstract RCDevicePMPlan setFinishDate(final Date finishDate);
  
  public abstract String getComment();
  
  public abstract RCDevicePMPlan setComment(final String comment);
  
  public abstract RCDevicePMPlanStatus getStatus();
  
  public abstract RCDevicePMPlan setStatus(final RCDevicePMPlanStatus status);
  
  public abstract Boolean hasAssignedWorker();
  
  public abstract RCDevicePMPlanSMStatus getSMStatus();
  
  public abstract void start();
  
  public abstract void assign();
  
  public abstract void assignWorker();
  
  public abstract void cancelAssign();
  
  public abstract void finish(final String comment);
  
  public abstract void reportInfo(final String comment);
  
  public abstract Boolean isPlaned();
  
  public abstract Boolean isAssigned();
  
  public abstract Boolean isFinished();
  
  public abstract Boolean isWorkerAssigned();
  
  public abstract RCDevicePMPlanProxy toProxy();
}
