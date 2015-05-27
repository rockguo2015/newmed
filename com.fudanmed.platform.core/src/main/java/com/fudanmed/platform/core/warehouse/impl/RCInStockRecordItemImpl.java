package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCInStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.impl.RCInStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordItemProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCINSTOCKRECORDITEM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcinstockrecorditem")
public class RCInStockRecordItemImpl extends BaseModelObject implements RCInStockRecordItem {
  public RCInStockRecordItemImpl() {
    super();
  }
  
  public RCInStockRecordItemImpl(final RCInStockRecord inStockRecord) {
    super();
    this.inStockRecord = inStockRecord;
  }
  
  @JoinColumn(name = "inStockRecord_id")
  @ManyToOne(targetEntity = RCInStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCInStockRecord inStockRecord;
  
  public RCInStockRecord getInStockRecord() {
    return this.inStockRecord;
  }
  
  public RCInStockRecordItem setInStockRecord(final RCInStockRecord inStockRecord) {
    this.inStockRecord = inStockRecord;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCInStockRecordItem setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "productSpec_id")
  @ManyToOne(targetEntity = RCProductSpecificationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCInStockRecordItem setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  private Double price;
  
  public Double getPrice() {
    return this.price;
  }
  
  public RCInStockRecordItem setPrice(final Double price) {
    this.price = price;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCInStockRecordItem setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  public static RCInStockRecordItem create(final RCInStockRecord inStockRecord, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCInStockRecordItem rCInStockRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCInStockRecordItemImpl(
    	inStockRecord
    );
    objectFactory.create(rCInStockRecordItem);
    return rCInStockRecordItem;			
    
  }
  
  public RCInStockRecordItemProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordItemProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordItemProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
