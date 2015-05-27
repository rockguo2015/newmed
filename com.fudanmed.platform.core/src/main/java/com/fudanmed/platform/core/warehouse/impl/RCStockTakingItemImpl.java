package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingListImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingItemProxy;
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
@DiscriminatorValue("RCSTOCKTAKINGITEM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcstocktakingitem")
public class RCStockTakingItemImpl extends BaseModelObject implements RCStockTakingItem {
  public RCStockTakingItemImpl() {
    super();
  }
  
  public RCStockTakingItemImpl(final RCStockTakingList takingList) {
    super();
    this.takingList = takingList;
  }
  
  @JoinColumn(name = "takingList_id")
  @ManyToOne(targetEntity = RCStockTakingListImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCStockTakingList takingList;
  
  public RCStockTakingList getTakingList() {
    return this.takingList;
  }
  
  public RCStockTakingItem setTakingList(final RCStockTakingList takingList) {
    this.takingList = takingList;
    return this;			
    
  }
  
  @JoinColumn(name = "productSpec_id")
  @ManyToOne(targetEntity = RCProductSpecificationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCStockTakingItem setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCStockTakingItem setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  private Integer realQuantity;
  
  public Integer getRealQuantity() {
    return this.realQuantity;
  }
  
  public RCStockTakingItem setRealQuantity(final Integer realQuantity) {
    this.realQuantity = realQuantity;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCStockTakingItem setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  public static RCStockTakingItem create(final RCStockTakingList takingList, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCStockTakingItem rCStockTakingItem = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingItemImpl(
    	takingList
    );
    objectFactory.create(rCStockTakingItem);
    return rCStockTakingItem;			
    
  }
  
  public RCStockTakingItemProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCStockTakingItemProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCStockTakingItemProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
