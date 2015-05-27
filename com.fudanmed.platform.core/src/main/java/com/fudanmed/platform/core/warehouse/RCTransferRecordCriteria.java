package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCTransferRecordCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;
import java.util.Date;

@QueryImplementation(implementBy = RCTransferRecordCriteriaImpl.class)
public interface RCTransferRecordCriteria extends IPagedCriteria<RCTransferRecord> {
  public abstract RCWarehouse getTargetStore();
  
  public abstract RCTransferRecordCriteria setTargetStore(final RCWarehouse targetStore);
  
  public abstract Date getDateFrom();
  
  public abstract RCTransferRecordCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract RCTransferRecordCriteria setDateTo(final Date dateTo);
  
  public abstract Collection<Long> getStores();
  
  public abstract RCTransferRecordCriteria setStores(final Collection<Long> stores);
}
