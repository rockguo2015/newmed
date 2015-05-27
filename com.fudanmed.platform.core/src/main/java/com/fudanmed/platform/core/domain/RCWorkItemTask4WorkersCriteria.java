package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.impl.RCWorkItemTask4WorkersCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCWorkItemTask4WorkersCriteriaImpl.class)
public interface RCWorkItemTask4WorkersCriteria extends IPagedCriteria<RCWorkItemTask> {
  public abstract Date getDateFrom();
  
  public abstract RCWorkItemTask4WorkersCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCWorkItemTask4WorkersCriteria setDateTo(final Date dateTo);
  
  public abstract RCMaintenanceTeam getDepartment();
  
  public abstract RCWorkItemTask4WorkersCriteria setDepartment(final RCMaintenanceTeam department);
}
