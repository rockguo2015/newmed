package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.impl.RCInStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy;
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
@DiscriminatorValue("RCPRODUCTENTRY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductentry")
public class RCProductEntryImpl extends BaseModelObject implements RCProductEntry {
  public RCProductEntryImpl() {
    super();
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCProductEntry setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  @JoinColumn(name = "productSpec_id")
  @ManyToOne(targetEntity = RCProductSpecificationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCProductEntry setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  @JoinColumn(name = "inStockRecord_id")
  @ManyToOne(targetEntity = RCInStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCInStockRecord inStockRecord;
  
  public RCInStockRecord getInStockRecord() {
    return this.inStockRecord;
  }
  
  public RCProductEntry setInStockRecord(final RCInStockRecord inStockRecord) {
    this.inStockRecord = inStockRecord;
    return this;			
    
  }
  
  private Double price;
  
  public Double getPrice() {
    return this.price;
  }
  
  public RCProductEntry setPrice(final Double price) {
    this.price = price;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCProductEntry setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  public String getEntityName() {
    String _name = this.productSpec.getName();
    return _name;
  }
  
  public static RCProductEntry create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductEntry rCProductEntry = new com.fudanmed.platform.core.warehouse.impl.RCProductEntryImpl(
    );
    objectFactory.create(rCProductEntry);
    return rCProductEntry;			
    
  }
  
  public RCProductEntryProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
