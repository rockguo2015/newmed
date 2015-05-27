package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockStatisticsCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCWorkItemStockStatisticsCriteriaImpl.class)
public interface RCWorkItemStockStatisticsCriteria extends IPagedCriteria<RCWorkItemStockRecordItem> {
  public abstract Date getReportDateFrom();
  
  public abstract RCWorkItemStockStatisticsCriteria setReportDateFrom(final Date reportDateFrom);
  
  public abstract Date getReportDateTo();
  
  public abstract RCWorkItemStockStatisticsCriteria setReportDateTo(final Date reportDateTo);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCWorkItemStockStatisticsCriteria setTeam(final RCMaintenanceTeam team);
  
  public abstract RCOrganization getReportOrg();
  
  public abstract RCWorkItemStockStatisticsCriteria setReportOrg(final RCOrganization reportOrg);
}
