package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCGroupTaskStatus;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCGroupTaskCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;
import java.util.Date;

@QueryImplementation(implementBy = RCGroupTaskCriteriaImpl.class)
public interface RCGroupTaskCriteria extends IPagedCriteria<RCGroupTask> {
  public abstract Date getDateFrom();
  
  public abstract RCGroupTaskCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCGroupTaskCriteria setDateTo(final Date dateTo);
  
  public abstract Boolean getIncludeFinishedTask();
  
  public abstract RCGroupTaskCriteria setIncludeFinishedTask(final Boolean includeFinishedTask);
  
  public abstract RCGroupTaskStatus getFinishedStatus();
  
  public abstract RCGroupTaskCriteria setFinishedStatus(final RCGroupTaskStatus finishedStatus);
  
  public abstract RCGroupTaskStatus getMisDispatchedStatus();
  
  public abstract RCGroupTaskCriteria setMisDispatchedStatus(final RCGroupTaskStatus misDispatchedStatus);
  
  public abstract RCGroupTaskStatus getCancelStatus();
  
  public abstract RCGroupTaskCriteria setCancelStatus(final RCGroupTaskStatus cancelStatus);
  
  public abstract Collection<Long> getTeams();
  
  public abstract RCGroupTaskCriteria setTeams(final Collection<Long> teams);
  
  public abstract RCGroupTaskStatus getStatus();
  
  public abstract RCGroupTaskCriteria setStatus(final RCGroupTaskStatus status);
  
  public abstract RCOrganization getReportOrg();
  
  public abstract RCGroupTaskCriteria setReportOrg(final RCOrganization reportOrg);
  
  public abstract RCFaultReportSource getFaultReportSource();
  
  public abstract RCGroupTaskCriteria setFaultReportSource(final RCFaultReportSource faultReportSource);
  
  public abstract String getMonth();
  
  public abstract RCGroupTaskCriteria setMonth(final String month);
}
