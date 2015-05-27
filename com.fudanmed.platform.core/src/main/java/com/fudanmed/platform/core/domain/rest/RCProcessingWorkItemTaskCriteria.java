package com.fudanmed.platform.core.domain.rest;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.impl.RCProcessingWorkItemTaskCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCProcessingWorkItemTaskCriteriaImpl.class)
public interface RCProcessingWorkItemTaskCriteria extends IPagedCriteria<RCWorkItemTask> {
  public abstract RCEmployee getOwner();
  
  public abstract RCProcessingWorkItemTaskCriteria setOwner(final RCEmployee owner);
  
  public abstract RCWorkItemTaskStatus getProcessingStatus();
  
  public abstract RCProcessingWorkItemTaskCriteria setProcessingStatus(final RCWorkItemTaskStatus processingStatus);
  
  public abstract RCWorkItemTaskStatus getOutsourcingStatus();
  
  public abstract RCProcessingWorkItemTaskCriteria setOutsourcingStatus(final RCWorkItemTaskStatus outsourcingStatus);
  
  public abstract RCWorkItemTaskStatus getPendingStatus();
  
  public abstract RCProcessingWorkItemTaskCriteria setPendingStatus(final RCWorkItemTaskStatus pendingStatus);
  
  public abstract RCWorkItemTaskStatus getFollowupingStatus();
  
  public abstract RCProcessingWorkItemTaskCriteria setFollowupingStatus(final RCWorkItemTaskStatus followupingStatus);
  
  public abstract void postInitialize();
}
