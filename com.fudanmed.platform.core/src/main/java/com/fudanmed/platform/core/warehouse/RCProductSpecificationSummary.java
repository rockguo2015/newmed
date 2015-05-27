package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl;
import edu.fudan.mylang.pf.BaseDataType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RCProductSpecificationSummary extends BaseDataType {
  public RCProductSpecificationSummary() {
    super();
  }
  
  @JoinColumn(name = "productSpec_id")
  @ManyToOne(targetEntity = RCProductSpecificationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCProductSpecificationSummary setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCProductSpecificationSummary setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  public static RCProductSpecificationSummary create() {
    return new RCProductSpecificationSummary();
    
    
  }
}
