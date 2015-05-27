package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockTransactionProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCWorkItemStockTransactionImpl.class)
public interface RCWorkItemStockTransaction extends RCProductStoreTransaction {
  public abstract RCWorkItemStockRecord getRecord();
  
  public abstract RCWorkItemStockTransaction setRecord(final RCWorkItemStockRecord record);
  
  public abstract String getEventRecordSid();
  
  public abstract String getTransactionTypeDesc();
  
  public abstract void transactionCommitted();
  
  public abstract RCWorkItemStockTransactionProxy toProxy();
}
