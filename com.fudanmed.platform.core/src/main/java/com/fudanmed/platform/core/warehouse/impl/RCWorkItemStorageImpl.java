package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.warehouse.impl.RCProductStorageImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStorageProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCWORKITEMSTORAGE_TYPE")
public class RCWorkItemStorageImpl extends RCProductStorageImpl implements RCWorkItemStorage {
  public RCWorkItemStorageImpl() {
    super();
  }
  
  @JoinColumn(name = "workItem_id")
  @ManyToOne(targetEntity = RCWorkItemTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWorkItemTask workItem;
  
  public RCWorkItemTask getWorkItem() {
    return this.workItem;
  }
  
  public RCWorkItemStorage setWorkItem(final RCWorkItemTask workItem) {
    this.workItem = workItem;
    return this;			
    
  }
  
  public static RCWorkItemStorage create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCWorkItemStorage rCWorkItemStorage = new com.fudanmed.platform.core.warehouse.impl.RCWorkItemStorageImpl(
    );
    objectFactory.create(rCWorkItemStorage);
    return rCWorkItemStorage;			
    
  }
  
  public RCWorkItemStorageProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStorageProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStorageProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
