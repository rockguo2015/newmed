package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingTransactionProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCStockTakingTransactionImpl.class)
public interface RCStockTakingTransaction extends RCProductStoreTransaction {
  public abstract RCStockTakingRecord getStockTakingRecord();
  
  public abstract RCStockTakingTransaction setStockTakingRecord(final RCStockTakingRecord stockTakingRecord);
  
  public abstract String getEventRecordSid();
  
  public abstract String getTransactionTypeDesc();
  
  public abstract void transactionCommitted();
  
  public abstract RCStockTakingTransactionProxy toProxy();
}
