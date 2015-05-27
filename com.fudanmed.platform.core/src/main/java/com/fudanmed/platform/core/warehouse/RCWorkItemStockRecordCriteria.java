package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCWorkItemStockRecordCriteriaImpl.class)
public interface RCWorkItemStockRecordCriteria extends IPagedCriteria<RCWorkItemStockRecord> {
  public abstract String getSid();
  
  public abstract RCWorkItemStockRecordCriteria setSid(final String sid);
}
