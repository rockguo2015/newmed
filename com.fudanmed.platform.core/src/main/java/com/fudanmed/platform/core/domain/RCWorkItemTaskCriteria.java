package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.impl.RCWorkItemTaskCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;

@QueryImplementation(implementBy = RCWorkItemTaskCriteriaImpl.class)
public interface RCWorkItemTaskCriteria extends IPagedCriteria<RCWorkItemTask> {
  public abstract String getSid();
  
  public abstract RCWorkItemTaskCriteria setSid(final String sid);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCWorkItemTaskCriteria setTeam(final RCMaintenanceTeam team);
  
  public abstract Boolean getShowAll();
  
  public abstract RCWorkItemTaskCriteria setShowAll(final Boolean showAll);
  
  public abstract RCWorkItemTaskStatus getProcessingStatus();
  
  public abstract RCWorkItemTaskCriteria setProcessingStatus(final RCWorkItemTaskStatus processingStatus);
  
  public abstract Collection<Long> getTeams();
  
  public abstract RCWorkItemTaskCriteria setTeams(final Collection<Long> teams);
  
  public abstract void postInitialize();
}
