package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Collection;

@QueryImplementation(implementBy = RCProductWarehouseStorageSummaryCriteriaImpl.class)
public interface RCProductWarehouseStorageSummaryCriteria extends IPagedCriteria<RCProductWarehouseStorageSummary> {
  public abstract RCWarehouse getStore();
  
  public abstract RCProductWarehouseStorageSummaryCriteria setStore(final RCWarehouse store);
  
  public abstract RCProductSpecification getProductSpec();
  
  public abstract RCProductWarehouseStorageSummaryCriteria setProductSpec(final RCProductSpecification productSpec);
  
  public abstract RCProductType getProductType();
  
  public abstract RCProductWarehouseStorageSummaryCriteria setProductType(final RCProductType productType);
  
  public abstract String getProductInfo();
  
  public abstract RCProductWarehouseStorageSummaryCriteria setProductInfo(final String productInfo);
  
  public abstract Collection<Long> getStores();
  
  public abstract RCProductWarehouseStorageSummaryCriteria setStores(final Collection<Long> stores);
}
