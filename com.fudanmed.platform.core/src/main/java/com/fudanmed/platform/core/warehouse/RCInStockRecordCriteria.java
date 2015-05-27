package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.impl.RCInStockRecordCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;
import java.util.Date;

@QueryImplementation(implementBy = RCInStockRecordCriteriaImpl.class)
public interface RCInStockRecordCriteria extends IPagedCriteria<RCInStockRecord> {
  public abstract String getSid();
  
  public abstract RCInStockRecordCriteria setSid(final String sid);
  
  public abstract Date getDateFrom();
  
  public abstract RCInStockRecordCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCInStockRecordCriteria setDateTo(final Date dateTo);
  
  public abstract Collection<Long> getStores();
  
  public abstract RCInStockRecordCriteria setStores(final Collection<Long> stores);
}
