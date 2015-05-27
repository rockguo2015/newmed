package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.impl.RCTransferTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferTransactionProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCTransferTransactionImpl.class)
public interface RCTransferTransaction extends RCProductStoreTransaction {
  public abstract RCTransferRecord getTransferRecord();
  
  public abstract RCTransferTransaction setTransferRecord(final RCTransferRecord transferRecord);
  
  public abstract String getEventRecordSid();
  
  public abstract String getTransactionTypeDesc();
  
  public abstract void transactionCommitted();
  
  public abstract RCTransferTransactionProxy toProxy();
}
