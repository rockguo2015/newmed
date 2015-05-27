package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockTransactionProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCOutStockTransactionImpl.class)
public interface RCOutStockTransaction extends RCProductStoreTransaction {
  public abstract RCOutStockRecord getOutStockRecord();
  
  public abstract RCOutStockTransaction setOutStockRecord(final RCOutStockRecord outStockRecord);
  
  public abstract String getEventRecordSid();
  
  public abstract String getTransactionTypeDesc();
  
  public abstract void transactionCommitted();
  
  public abstract RCOutStockTransactionProxy toProxy();
}
