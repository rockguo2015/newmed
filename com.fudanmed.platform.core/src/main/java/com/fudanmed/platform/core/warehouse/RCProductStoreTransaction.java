package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@EntityImplementation(implementBy = RCProductStoreTransactionImpl.class)
public interface RCProductStoreTransaction extends IModelObject {
  public abstract RCProductStorage getProductStorage();
  
  public abstract RCProductStoreTransaction setProductStorage(final RCProductStorage productStorage);
  
  public abstract Date getDate();
  
  public abstract RCProductStoreTransaction setDate(final Date date);
  
  public abstract Integer getQuantity();
  
  public abstract RCProductStoreTransaction setQuantity(final Integer quantity);
  
  public abstract RCEmployee getOperator();
  
  public abstract RCProductStoreTransaction setOperator(final RCEmployee operator);
  
  public abstract String getTransactionTypeDesc();
  
  public abstract String getEventRecordSid();
  
  public abstract void transactionCommitted(final Procedure3<? super RCProductSummarySnapshot,? super Integer,? super Double> init);
  
  public abstract void transactionCommitted();
  
  public abstract RCProductStoreTransactionProxy toProxy();
}
