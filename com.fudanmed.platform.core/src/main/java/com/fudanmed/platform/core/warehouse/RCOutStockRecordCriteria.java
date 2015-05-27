package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;
import java.util.Date;

@QueryImplementation(implementBy = RCOutStockRecordCriteriaImpl.class)
public interface RCOutStockRecordCriteria extends IPagedCriteria<RCOutStockRecord> {
  public abstract String getSid();
  
  public abstract RCOutStockRecordCriteria setSid(final String sid);
  
  public abstract Date getDateFrom();
  
  public abstract RCOutStockRecordCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCOutStockRecordCriteria setDateTo(final Date dateTo);
  
  public abstract Collection<Long> getStores();
  
  public abstract RCOutStockRecordCriteria setStores(final Collection<Long> stores);
}
