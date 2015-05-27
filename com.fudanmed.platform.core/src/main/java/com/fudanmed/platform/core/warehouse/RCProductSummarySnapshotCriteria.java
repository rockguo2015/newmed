package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCProductSummarySnapshotCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCProductSummarySnapshotCriteriaImpl.class)
public interface RCProductSummarySnapshotCriteria extends IPagedCriteria<RCProductSummarySnapshot> {
  public abstract Date getDateFrom();
  
  public abstract RCProductSummarySnapshotCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCProductSummarySnapshotCriteria setDateTo(final Date dateTo);
  
  public abstract RCWarehouse getStore();
  
  public abstract RCProductSummarySnapshotCriteria setStore(final RCWarehouse store);
  
  public abstract RCProductSpecification getProductSpec();
  
  public abstract RCProductSummarySnapshotCriteria setProductSpec(final RCProductSpecification productSpec);
}
