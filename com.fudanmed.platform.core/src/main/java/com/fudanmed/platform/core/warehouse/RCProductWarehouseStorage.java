package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCProductWarehouseStorageImpl.class)
public interface RCProductWarehouseStorage extends RCProductStorage {
  public abstract RCWarehouse getStore();
  
  public abstract RCProductWarehouseStorage setStore(final RCWarehouse store);
  
  public abstract RCProductWarehouseStorageSummary getSummary();
  
  public abstract RCProductWarehouseStorageProxy toProxy();
}
