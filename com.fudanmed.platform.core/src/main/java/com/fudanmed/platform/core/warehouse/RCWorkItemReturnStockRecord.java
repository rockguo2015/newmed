package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemReturnStockRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import java.util.Collection;

@EntityImplementation(implementBy = RCWorkItemReturnStockRecordImpl.class)
public interface RCWorkItemReturnStockRecord extends RCWorkItemStockRecord {
  public abstract String getTypeName();
  
  public abstract void initItemsFromSummary(final Collection<RCProductSpecificationSummary> summaryItems);
  
  public abstract void commit(final RCEmployee operator);
  
  public abstract RCWorkItemReturnStockRecordProxy toProxy();
}
