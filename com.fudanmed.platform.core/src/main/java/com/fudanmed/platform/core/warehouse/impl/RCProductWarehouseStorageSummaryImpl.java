package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.google.common.collect.Iterables;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCPRODUCTWAREHOUSESTORAGESUMMARY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductwarehousestoragesummary")
public class RCProductWarehouseStorageSummaryImpl extends BaseModelObject implements RCProductWarehouseStorageSummary {
  public RCProductWarehouseStorageSummaryImpl() {
    super();
  }
  
  @JoinColumn(name = "store_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse store;
  
  public RCWarehouse getStore() {
    return this.store;
  }
  
  public RCProductWarehouseStorageSummary setStore(final RCWarehouse store) {
    this.store = store;
    return this;			
    
  }
  
  @JoinColumn(name = "productSpec_id")
  @ManyToOne(targetEntity = RCProductSpecificationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCProductWarehouseStorageSummary setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCProductWarehouseStorageSummary setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  private Double amount;
  
  public Double getAmount() {
    return this.amount;
  }
  
  public RCProductWarehouseStorageSummary setAmount(final Double amount) {
    this.amount = amount;
    return this;			
    
  }
  
  public Collection<RCProductStoreTransaction> getTransactions() {
    Collection<RCProductWarehouseStorage> _productWarehouseStorages = this.getProductWarehouseStorages();
    final Function1<RCProductWarehouseStorage,Collection<RCProductStoreTransaction>> _function = new Function1<RCProductWarehouseStorage,Collection<RCProductStoreTransaction>>() {
        public Collection<RCProductStoreTransaction> apply(final RCProductWarehouseStorage it) {
          Collection<RCProductStoreTransaction> _transactions = it.getTransactions();
          return _transactions;
        }
      };
    Iterable<Collection<RCProductStoreTransaction>> _map = IterableExtensions.<RCProductWarehouseStorage, Collection<RCProductStoreTransaction>>map(_productWarehouseStorages, _function);
    Iterable<RCProductStoreTransaction> _flatten = Iterables.<RCProductStoreTransaction>concat(_map);
    final Function1<RCProductStoreTransaction,Date> _function_1 = new Function1<RCProductStoreTransaction,Date>() {
        public Date apply(final RCProductStoreTransaction it) {
          Date _date = it.getDate();
          return _date;
        }
      };
    List<RCProductStoreTransaction> _sortBy = IterableExtensions.<RCProductStoreTransaction, Date>sortBy(_flatten, _function_1);
    List<RCProductStoreTransaction> _reverse = ListExtensions.<RCProductStoreTransaction>reverse(_sortBy);
    return _reverse;
  }
  
  public Collection<RCProductWarehouseStorage> getProductWarehouseStorages() {
    IGenericQuery<RCProductWarehouseStorage> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorage.class,"select w from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl as w   where ((w.store = :store) and (w.productEntry.productSpec = :productSpec)) and  w.active = 1      ").setParameter("store",store).setParameter("productSpec",productSpec);
    Collection<RCProductWarehouseStorage> _list = query.list();
    return _list;
  }
  
  public static RCProductWarehouseStorageSummary create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary rCProductWarehouseStorageSummary = new com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl(
    );
    objectFactory.create(rCProductWarehouseStorageSummary);
    return rCProductWarehouseStorageSummary;			
    
  }
  
  public RCProductWarehouseStorageSummaryProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
