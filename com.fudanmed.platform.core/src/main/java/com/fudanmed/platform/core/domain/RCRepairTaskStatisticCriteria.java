package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import com.fudanmed.platform.core.domain.impl.RCRepairTaskStatisticCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCRepairTaskStatisticCriteriaImpl.class)
public interface RCRepairTaskStatisticCriteria extends IPagedCriteria<RCRepairTask> {
  public abstract RCOrganization getReportOrg();
  
  public abstract RCRepairTaskStatisticCriteria setReportOrg(final RCOrganization reportOrg);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCRepairTaskStatisticCriteria setTeam(final RCMaintenanceTeam team);
  
  public abstract RCEmployee getWorker();
  
  public abstract RCRepairTaskStatisticCriteria setWorker(final RCEmployee worker);
  
  public abstract String getComment();
  
  public abstract RCRepairTaskStatisticCriteria setComment(final String comment);
  
  public abstract RCRepairTaskStatus getStatus();
  
  public abstract RCRepairTaskStatisticCriteria setStatus(final RCRepairTaskStatus status);
  
  public abstract Date getReportDateFrom();
  
  public abstract RCRepairTaskStatisticCriteria setReportDateFrom(final Date reportDateFrom);
  
  public abstract Date getReportDateTo();
  
  public abstract RCRepairTaskStatisticCriteria setReportDateTo(final Date reportDateTo);
}
