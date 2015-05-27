package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCProductStoreTransactionCriteriaImpl.class)
public interface RCProductStoreTransactionCriteria extends IPagedCriteria<RCProductStoreTransaction> {
  public abstract RCProductStorage getProductStorage();
  
  public abstract RCProductStoreTransactionCriteria setProductStorage(final RCProductStorage productStorage);
}
