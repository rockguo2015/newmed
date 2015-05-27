package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;

public class RCProductSummarySnapshotStatCriteriaData {
  public RCProductSummarySnapshotStatCriteriaData(final RCProductWarehouseStorageSummary storageSummary, final Long inStockQuantity, final Double inStockAmount, final Long outStockQuantity, final Double outStockAmount, final Long stockTakingStockQuantity, final Double stockTakingStockAmount, final Long transferStockQuantity, final Double transferStockAmount, final Long workitemStockQuantity, final Double workitemStockAmount) {
    this.storageSummary=storageSummary;
    this.inStockQuantity=inStockQuantity;
    this.inStockAmount=inStockAmount;
    this.outStockQuantity=outStockQuantity;
    this.outStockAmount=outStockAmount;
    this.stockTakingStockQuantity=stockTakingStockQuantity;
    this.stockTakingStockAmount=stockTakingStockAmount;
    this.transferStockQuantity=transferStockQuantity;
    this.transferStockAmount=transferStockAmount;
    this.workitemStockQuantity=workitemStockQuantity;
    this.workitemStockAmount=workitemStockAmount;
    
  }
  
  private RCProductWarehouseStorageSummary storageSummary;
  
  public RCProductWarehouseStorageSummary getStorageSummary() {
    return this.storageSummary;
  }
  
  private Long inStockQuantity;
  
  public Long getInStockQuantity() {
    return this.inStockQuantity;
  }
  
  private Double inStockAmount;
  
  public Double getInStockAmount() {
    return this.inStockAmount;
  }
  
  private Long outStockQuantity;
  
  public Long getOutStockQuantity() {
    return this.outStockQuantity;
  }
  
  private Double outStockAmount;
  
  public Double getOutStockAmount() {
    return this.outStockAmount;
  }
  
  private Long stockTakingStockQuantity;
  
  public Long getStockTakingStockQuantity() {
    return this.stockTakingStockQuantity;
  }
  
  private Double stockTakingStockAmount;
  
  public Double getStockTakingStockAmount() {
    return this.stockTakingStockAmount;
  }
  
  private Long transferStockQuantity;
  
  public Long getTransferStockQuantity() {
    return this.transferStockQuantity;
  }
  
  private Double transferStockAmount;
  
  public Double getTransferStockAmount() {
    return this.transferStockAmount;
  }
  
  private Long workitemStockQuantity;
  
  public Long getWorkitemStockQuantity() {
    return this.workitemStockQuantity;
  }
  
  private Double workitemStockAmount;
  
  public Double getWorkitemStockAmount() {
    return this.workitemStockAmount;
  }
}
