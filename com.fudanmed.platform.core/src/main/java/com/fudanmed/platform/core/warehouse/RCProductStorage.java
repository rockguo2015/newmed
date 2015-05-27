package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCProductStorageImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCProductStorageImpl.class)
public interface RCProductStorage extends IModelObject, INamedModelObject {
  public abstract RCProductEntry getProductEntry();
  
  public abstract RCProductStorage setProductEntry(final RCProductEntry productEntry);
  
  public abstract Integer getQuantity();
  
  public abstract RCProductStorage setQuantity(final Integer quantity);
  
  public abstract Collection<RCProductStoreTransaction> getTransactions();
  
  public abstract RCProductStorage removeFromTransactions(final RCProductStoreTransaction rCProductStoreTransaction);
  
  public abstract RCProductStorage removeAllTransactions();
  
  public abstract String getEntityName();
  
  public abstract Double getAmount();
  
  public abstract RCProductStorageProxy toProxy();
}
