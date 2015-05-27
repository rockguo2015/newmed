package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemStatue;
import com.fudanmed.platform.core.device.pm.impl.RCPMWorkItemCriteriaImpl;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;
import java.util.Date;

@QueryImplementation(implementBy = RCPMWorkItemCriteriaImpl.class)
public interface RCPMWorkItemCriteria extends IPagedCriteria<RCPMWorkItem> {
  public abstract Date getAssignDateFrom();
  
  public abstract RCPMWorkItemCriteria setAssignDateFrom(final Date assignDateFrom);
  
  public abstract Date getAssignDateTo();
  
  public abstract RCPMWorkItemCriteria setAssignDateTo(final Date assignDateTo);
  
  public abstract RCPMWorkItemStatue getStatus();
  
  public abstract RCPMWorkItemCriteria setStatus(final RCPMWorkItemStatue status);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCPMWorkItemCriteria setTeam(final RCMaintenanceTeam team);
  
  public abstract Collection<Long> getTeams();
  
  public abstract RCPMWorkItemCriteria setTeams(final Collection<Long> teams);
  
  public abstract Boolean getIncludeFinishedItems();
  
  public abstract RCPMWorkItemCriteria setIncludeFinishedItems(final Boolean includeFinishedItems);
  
  public abstract RCPMWorkItemStatue getFinishedStatus();
  
  public abstract RCPMWorkItemCriteria setFinishedStatus(final RCPMWorkItemStatue finishedStatus);
  
  public abstract void postInitialize();
}
