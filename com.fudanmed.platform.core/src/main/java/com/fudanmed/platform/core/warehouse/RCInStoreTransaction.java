package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCInStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTransactionProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCInStoreTransactionImpl.class)
public interface RCInStoreTransaction extends RCProductStoreTransaction {
  public abstract RCInStockRecord getInStoreRecord();
  
  public abstract RCInStoreTransaction setInStoreRecord(final RCInStockRecord inStoreRecord);
  
  public abstract String getEventRecordSid();
  
  public abstract String getTransactionTypeDesc();
  
  public abstract void transactionCommitted();
  
  public abstract RCInStoreTransactionProxy toProxy();
}
