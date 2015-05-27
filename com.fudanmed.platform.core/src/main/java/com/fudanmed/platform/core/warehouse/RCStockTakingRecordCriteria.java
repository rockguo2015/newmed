package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCStockTakingRecordCriteriaImpl.class)
public interface RCStockTakingRecordCriteria extends IPagedCriteria<RCStockTakingRecord> {
  public abstract String getSid();
  
  public abstract RCStockTakingRecordCriteria setSid(final String sid);
  
  public abstract Date getDateFrom();
  
  public abstract RCStockTakingRecordCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCStockTakingRecordCriteria setDateTo(final Date dateTo);
}
