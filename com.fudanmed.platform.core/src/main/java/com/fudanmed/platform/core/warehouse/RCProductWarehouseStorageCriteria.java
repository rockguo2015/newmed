package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCProductWarehouseStorageCriteriaImpl.class)
public interface RCProductWarehouseStorageCriteria extends IPagedCriteria<RCProductWarehouseStorage> {
  public abstract String getProductInfo();
  
  public abstract RCProductWarehouseStorageCriteria setProductInfo(final String productInfo);
  
  public abstract RCWarehouse getStore();
  
  public abstract RCProductWarehouseStorageCriteria setStore(final RCWarehouse store);
  
  public abstract RCProductSpecification getProductSpec();
  
  public abstract RCProductWarehouseStorageCriteria setProductSpec(final RCProductSpecification productSpec);
}
