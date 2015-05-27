package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent;
import com.fudanmed.platform.core.deliver.impl.DLResourceExtBorrowEventCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = DLResourceExtBorrowEventCriteriaImpl.class)
public interface DLResourceExtBorrowEventCriteria extends IPagedCriteria<DLResourceExtBorrowEvent> {
  public abstract Boolean getReturned();
  
  public abstract DLResourceExtBorrowEventCriteria setReturned(final Boolean returned);
  
  public abstract Date getDateFrom();
  
  public abstract DLResourceExtBorrowEventCriteria setDateFrom(final Date dateFrom);
  
  public abstract Date getDateTo();
  
  public abstract DLResourceExtBorrowEventCriteria setDateTo(final Date dateTo);
}
