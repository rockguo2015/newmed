package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCProductStorageImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageProxy;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCPRODUCTWAREHOUSESTORAGE_TYPE")
public class RCProductWarehouseStorageImpl extends RCProductStorageImpl implements RCProductWarehouseStorage {
  public RCProductWarehouseStorageImpl() {
    super();
  }
  
  @JoinColumn(name = "store_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse store;
  
  public RCWarehouse getStore() {
    return this.store;
  }
  
  public RCProductWarehouseStorage setStore(final RCWarehouse store) {
    this.store = store;
    return this;			
    
  }
  
  public RCProductWarehouseStorageSummary getSummary() {
    RCProductEntry _productEntry = this.getProductEntry();
    RCProductSpecification _productSpec = _productEntry.getProductSpec();
    IGenericQuery<RCProductWarehouseStorageSummary> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorageSummary.class,"select e from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl as e   where ((e.productSpec = :_productSpec) and (e.store = :store)) and  e.active = 1      ").setParameter("_productSpec",_productSpec).setParameter("store",store);
    RCProductWarehouseStorageSummary _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public static RCProductWarehouseStorage create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage rCProductWarehouseStorage = new com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl(
    );
    objectFactory.create(rCProductWarehouseStorage);
    return rCProductWarehouseStorage;			
    
  }
  
  public RCProductWarehouseStorageProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
