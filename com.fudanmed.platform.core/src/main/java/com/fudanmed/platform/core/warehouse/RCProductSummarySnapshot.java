package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.impl.RCProductSummarySnapshotImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSummarySnapshotProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = RCProductSummarySnapshotImpl.class)
public interface RCProductSummarySnapshot extends IModelObject {
  public abstract RCProductWarehouseStorageSummary getStorageSummary();
  
  public abstract RCProductSummarySnapshot setStorageSummary(final RCProductWarehouseStorageSummary storageSummary);
  
  public abstract Integer getQuantity();
  
  public abstract RCProductSummarySnapshot setQuantity(final Integer quantity);
  
  public abstract Double getAmount();
  
  public abstract RCProductSummarySnapshot setAmount(final Double amount);
  
  public abstract Date getDate();
  
  public abstract RCProductSummarySnapshot setDate(final Date date);
  
  public abstract Integer getInStockQuantity();
  
  public abstract RCProductSummarySnapshot setInStockQuantity(final Integer inStockQuantity);
  
  public abstract Double getInStockAmount();
  
  public abstract RCProductSummarySnapshot setInStockAmount(final Double inStockAmount);
  
  public abstract Integer getOutStockQuantity();
  
  public abstract RCProductSummarySnapshot setOutStockQuantity(final Integer outStockQuantity);
  
  public abstract Double getOutStockAmount();
  
  public abstract RCProductSummarySnapshot setOutStockAmount(final Double outStockAmount);
  
  public abstract Integer getStockTakingStockQuantity();
  
  public abstract RCProductSummarySnapshot setStockTakingStockQuantity(final Integer stockTakingStockQuantity);
  
  public abstract Double getStockTakingStockAmount();
  
  public abstract RCProductSummarySnapshot setStockTakingStockAmount(final Double stockTakingStockAmount);
  
  public abstract Integer getTransferStockQuantity();
  
  public abstract RCProductSummarySnapshot setTransferStockQuantity(final Integer transferStockQuantity);
  
  public abstract Double getTransferStockAmount();
  
  public abstract RCProductSummarySnapshot setTransferStockAmount(final Double transferStockAmount);
  
  public abstract Integer getWorkitemStockQuantity();
  
  public abstract RCProductSummarySnapshot setWorkitemStockQuantity(final Integer workitemStockQuantity);
  
  public abstract Double getWorkitemStockAmount();
  
  public abstract RCProductSummarySnapshot setWorkitemStockAmount(final Double workitemStockAmount);
  
  public abstract RCProductSummarySnapshotProxy toProxy();
}
