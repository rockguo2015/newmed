package com.fudanmed.platform.core.domain.rest;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.impl.RCFinishedWorkItemTaskCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCFinishedWorkItemTaskCriteriaImpl.class)
public interface RCFinishedWorkItemTaskCriteria extends IPagedCriteria<RCWorkItemTask> {
  public abstract RCEmployee getOwner();
  
  public abstract RCFinishedWorkItemTaskCriteria setOwner(final RCEmployee owner);
  
  public abstract Date getStartDate();
  
  public abstract RCFinishedWorkItemTaskCriteria setStartDate(final Date startDate);
  
  public abstract Date getEndDate();
  
  public abstract RCFinishedWorkItemTaskCriteria setEndDate(final Date endDate);
  
  public abstract RCWorkItemTaskStatus getProcessingStatus();
  
  public abstract RCFinishedWorkItemTaskCriteria setProcessingStatus(final RCWorkItemTaskStatus processingStatus);
  
  public abstract RCWorkItemTaskStatus getOutsourcingStatus();
  
  public abstract RCFinishedWorkItemTaskCriteria setOutsourcingStatus(final RCWorkItemTaskStatus outsourcingStatus);
  
  public abstract RCWorkItemTaskStatus getPendingStatus();
  
  public abstract RCFinishedWorkItemTaskCriteria setPendingStatus(final RCWorkItemTaskStatus pendingStatus);
  
  public abstract RCWorkItemTaskStatus getFollowupingStatus();
  
  public abstract RCFinishedWorkItemTaskCriteria setFollowupingStatus(final RCWorkItemTaskStatus followupingStatus);
  
  public abstract void postInitialize();
}
