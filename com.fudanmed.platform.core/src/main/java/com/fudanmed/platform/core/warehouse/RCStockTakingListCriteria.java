package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingListCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;
import java.util.Date;

@QueryImplementation(implementBy = RCStockTakingListCriteriaImpl.class)
public interface RCStockTakingListCriteria extends IPagedCriteria<RCStockTakingList> {
  public abstract RCWarehouse getWarehouse();
  
  public abstract RCStockTakingListCriteria setWarehouse(final RCWarehouse warehouse);
  
  public abstract Date getDateFrom();
  
  public abstract RCStockTakingListCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCStockTakingListCriteria setDateTo(final Date dateTo);
  
  public abstract Collection<Long> getStores();
  
  public abstract RCStockTakingListCriteria setStores(final Collection<Long> stores);
}
