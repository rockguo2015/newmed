package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCProductEntryImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCPRODUCTSTORAGE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductstorage")
public class RCProductStorageImpl extends BaseModelObject implements RCProductStorage {
  public RCProductStorageImpl() {
    super();
  }
  
  @JoinColumn(name = "productEntry_id")
  @ManyToOne(targetEntity = RCProductEntryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductEntry productEntry;
  
  public RCProductEntry getProductEntry() {
    return this.productEntry;
  }
  
  public RCProductStorage setProductEntry(final RCProductEntry productEntry) {
    this.productEntry = productEntry;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCProductStorage setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCProductStoreTransactionImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "productStorage")
  private Collection<RCProductStoreTransaction> transactions = new java.util.ArrayList<com.fudanmed.platform.core.warehouse.RCProductStoreTransaction>();;
  
  public Collection<RCProductStoreTransaction> getTransactions() {
    return this.transactions;
  }
  
  public RCProductStorage removeAllTransactions() {
    for(RCProductStoreTransaction obj : this.transactions){
    	getObjectFactory().delete(obj);
    }
    this.transactions.clear();
    return this;	
    
  }
  
  public RCProductStorage removeFromTransactions(final RCProductStoreTransaction rCProductStoreTransaction) {
    this.transactions.remove(rCProductStoreTransaction);
    getObjectFactory().delete(rCProductStoreTransaction);
    return this;
    
  }
  
  public String getEntityName() {
    RCProductSpecification _productSpec = this.productEntry.getProductSpec();
    String _name = _productSpec.getName();
    return _name;
  }
  
  public Double getAmount() {
    Double _price = this.productEntry.getPrice();
    double _multiply = DoubleExtensions.operator_multiply(_price, this.quantity);
    return Double.valueOf(_multiply);
  }
  
  public static RCProductStorage create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductStorage rCProductStorage = new com.fudanmed.platform.core.warehouse.impl.RCProductStorageImpl(
    );
    objectFactory.create(rCProductStorage);
    return rCProductStorage;			
    
  }
  
  public RCProductStorageProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
