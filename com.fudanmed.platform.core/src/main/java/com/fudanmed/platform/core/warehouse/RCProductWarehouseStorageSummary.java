package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCProductWarehouseStorageSummaryImpl.class)
public interface RCProductWarehouseStorageSummary extends IModelObject {
  public abstract RCWarehouse getStore();
  
  public abstract RCProductWarehouseStorageSummary setStore(final RCWarehouse store);
  
  public abstract RCProductSpecification getProductSpec();
  
  public abstract RCProductWarehouseStorageSummary setProductSpec(final RCProductSpecification productSpec);
  
  public abstract Integer getQuantity();
  
  public abstract RCProductWarehouseStorageSummary setQuantity(final Integer quantity);
  
  public abstract Double getAmount();
  
  public abstract RCProductWarehouseStorageSummary setAmount(final Double amount);
  
  public abstract Collection<RCProductStoreTransaction> getTransactions();
  
  public abstract Collection<RCProductWarehouseStorage> getProductWarehouseStorages();
  
  public abstract RCProductWarehouseStorageSummaryProxy toProxy();
}
