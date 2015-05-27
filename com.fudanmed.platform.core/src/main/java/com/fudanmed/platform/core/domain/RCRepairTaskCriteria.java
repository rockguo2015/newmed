package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.domain.RCEvaluateState;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import com.fudanmed.platform.core.domain.impl.RCRepairTaskCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCRepairTaskCriteriaImpl.class)
public interface RCRepairTaskCriteria extends IPagedCriteria<RCRepairTask> {
  public abstract String getComment();
  
  public abstract RCRepairTaskCriteria setComment(final String comment);
  
  public abstract RCOrganization getReportOrg();
  
  public abstract RCRepairTaskCriteria setReportOrg(final RCOrganization reportOrg);
  
  public abstract Boolean getIncludeFinishedTask();
  
  public abstract RCRepairTaskCriteria setIncludeFinishedTask(final Boolean includeFinishedTask);
  
  public abstract Boolean getIncludeFinishedTask4Reporter();
  
  public abstract RCRepairTaskCriteria setIncludeFinishedTask4Reporter(final Boolean includeFinishedTask4Reporter);
  
  public abstract RCRepairTaskStatus getCloseStatus();
  
  public abstract RCRepairTaskCriteria setCloseStatus(final RCRepairTaskStatus closeStatus);
  
  public abstract RCRepairTaskStatus getCancelStatus();
  
  public abstract RCRepairTaskCriteria setCancelStatus(final RCRepairTaskStatus cancelStatus);
  
  public abstract RCEvaluateState getFinishState();
  
  public abstract RCRepairTaskCriteria setFinishState(final RCEvaluateState finishState);
  
  public abstract RCEvaluateState getAutoCommitState();
  
  public abstract RCRepairTaskCriteria setAutoCommitState(final RCEvaluateState autoCommitState);
  
  public abstract RCFaultReportSource getFaultReportSource();
  
  public abstract RCRepairTaskCriteria setFaultReportSource(final RCFaultReportSource faultReportSource);
  
  public abstract Date getReportDateFrom();
  
  public abstract RCRepairTaskCriteria setReportDateFrom(final Date reportDateFrom);
  
  public abstract Date getReportDateTo();
  
  public abstract RCRepairTaskCriteria setReportDateTo(final Date reportDateTo);
  
  public abstract RCRepairTaskStatus getStatus();
  
  public abstract RCRepairTaskCriteria setStatus(final RCRepairTaskStatus status);
  
  public abstract String getMonth();
  
  public abstract RCRepairTaskCriteria setMonth(final String month);
}
