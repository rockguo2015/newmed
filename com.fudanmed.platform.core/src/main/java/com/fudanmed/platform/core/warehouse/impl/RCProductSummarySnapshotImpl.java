package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSummarySnapshotProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCPRODUCTSUMMARYSNAPSHOT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductsummarysnapshot")
public class RCProductSummarySnapshotImpl extends BaseModelObject implements RCProductSummarySnapshot {
  public RCProductSummarySnapshotImpl() {
    super();
  }
  
  @JoinColumn(name = "storageSummary_id")
  @ManyToOne(targetEntity = RCProductWarehouseStorageSummaryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductWarehouseStorageSummary storageSummary;
  
  public RCProductWarehouseStorageSummary getStorageSummary() {
    return this.storageSummary;
  }
  
  public RCProductSummarySnapshot setStorageSummary(final RCProductWarehouseStorageSummary storageSummary) {
    this.storageSummary = storageSummary;
    return this;			
    
  }
  
  private Integer quantity = Integer.valueOf(0);
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCProductSummarySnapshot setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  private Double amount = Double.valueOf(0d);
  
  public Double getAmount() {
    return this.amount;
  }
  
  public RCProductSummarySnapshot setAmount(final Double amount) {
    this.amount = amount;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCProductSummarySnapshot setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private Integer inStockQuantity = Integer.valueOf(0);
  
  public Integer getInStockQuantity() {
    return this.inStockQuantity;
  }
  
  public RCProductSummarySnapshot setInStockQuantity(final Integer inStockQuantity) {
    this.inStockQuantity = inStockQuantity;
    return this;			
    
  }
  
  private Double inStockAmount = Double.valueOf(0d);
  
  public Double getInStockAmount() {
    return this.inStockAmount;
  }
  
  public RCProductSummarySnapshot setInStockAmount(final Double inStockAmount) {
    this.inStockAmount = inStockAmount;
    return this;			
    
  }
  
  private Integer outStockQuantity = Integer.valueOf(0);
  
  public Integer getOutStockQuantity() {
    return this.outStockQuantity;
  }
  
  public RCProductSummarySnapshot setOutStockQuantity(final Integer outStockQuantity) {
    this.outStockQuantity = outStockQuantity;
    return this;			
    
  }
  
  private Double outStockAmount = Double.valueOf(0d);
  
  public Double getOutStockAmount() {
    return this.outStockAmount;
  }
  
  public RCProductSummarySnapshot setOutStockAmount(final Double outStockAmount) {
    this.outStockAmount = outStockAmount;
    return this;			
    
  }
  
  private Integer stockTakingStockQuantity = Integer.valueOf(0);
  
  public Integer getStockTakingStockQuantity() {
    return this.stockTakingStockQuantity;
  }
  
  public RCProductSummarySnapshot setStockTakingStockQuantity(final Integer stockTakingStockQuantity) {
    this.stockTakingStockQuantity = stockTakingStockQuantity;
    return this;			
    
  }
  
  private Double stockTakingStockAmount = Double.valueOf(0d);
  
  public Double getStockTakingStockAmount() {
    return this.stockTakingStockAmount;
  }
  
  public RCProductSummarySnapshot setStockTakingStockAmount(final Double stockTakingStockAmount) {
    this.stockTakingStockAmount = stockTakingStockAmount;
    return this;			
    
  }
  
  private Integer transferStockQuantity = Integer.valueOf(0);
  
  public Integer getTransferStockQuantity() {
    return this.transferStockQuantity;
  }
  
  public RCProductSummarySnapshot setTransferStockQuantity(final Integer transferStockQuantity) {
    this.transferStockQuantity = transferStockQuantity;
    return this;			
    
  }
  
  private Double transferStockAmount = Double.valueOf(0d);
  
  public Double getTransferStockAmount() {
    return this.transferStockAmount;
  }
  
  public RCProductSummarySnapshot setTransferStockAmount(final Double transferStockAmount) {
    this.transferStockAmount = transferStockAmount;
    return this;			
    
  }
  
  private Integer workitemStockQuantity = Integer.valueOf(0);
  
  public Integer getWorkitemStockQuantity() {
    return this.workitemStockQuantity;
  }
  
  public RCProductSummarySnapshot setWorkitemStockQuantity(final Integer workitemStockQuantity) {
    this.workitemStockQuantity = workitemStockQuantity;
    return this;			
    
  }
  
  private Double workitemStockAmount = Double.valueOf(0d);
  
  public Double getWorkitemStockAmount() {
    return this.workitemStockAmount;
  }
  
  public RCProductSummarySnapshot setWorkitemStockAmount(final Double workitemStockAmount) {
    this.workitemStockAmount = workitemStockAmount;
    return this;			
    
  }
  
  public static RCProductSummarySnapshot create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot rCProductSummarySnapshot = new com.fudanmed.platform.core.warehouse.impl.RCProductSummarySnapshotImpl(
    );
    objectFactory.create(rCProductSummarySnapshot);
    return rCProductSummarySnapshot;			
    
  }
  
  public RCProductSummarySnapshotProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductSummarySnapshotProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductSummarySnapshotProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
