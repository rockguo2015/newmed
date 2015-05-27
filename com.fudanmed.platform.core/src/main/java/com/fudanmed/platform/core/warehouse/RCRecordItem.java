package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.impl.RCProductEntryImpl;
import edu.fudan.mylang.pf.BaseDataType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;

public class RCRecordItem extends BaseDataType {
  public RCRecordItem() {
    super();
  }
  
  @JoinColumn(name = "productEntry_id")
  @ManyToOne(targetEntity = RCProductEntryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductEntry productEntry;
  
  public RCProductEntry getProductEntry() {
    return this.productEntry;
  }
  
  public RCRecordItem setProductEntry(final RCProductEntry productEntry) {
    this.productEntry = productEntry;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCRecordItem setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  public Double getTotalAmount() {
    Double _price = this.productEntry.getPrice();
    double _multiply = DoubleExtensions.operator_multiply(_price, this.quantity);
    return Double.valueOf(_multiply);
  }
  
  public static RCRecordItem create() {
    return new RCRecordItem();
    
    
  }
}
