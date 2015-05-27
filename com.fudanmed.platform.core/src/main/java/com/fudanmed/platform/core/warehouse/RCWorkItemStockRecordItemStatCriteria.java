package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordItemStatCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCWorkItemStockRecordItemStatCriteriaImpl.class)
public interface RCWorkItemStockRecordItemStatCriteria extends IPagedCriteria<RCWorkItemStockRecordItem> {
  public abstract Date getDateFrom();
  
  public abstract RCWorkItemStockRecordItemStatCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCWorkItemStockRecordItemStatCriteria setDateTo(final Date dateTo);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCWorkItemStockRecordItemStatCriteria setTeam(final RCMaintenanceTeam team);
}
