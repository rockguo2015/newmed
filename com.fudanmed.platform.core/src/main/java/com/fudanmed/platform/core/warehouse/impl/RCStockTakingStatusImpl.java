package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCStockTakingStatus;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingStatusProxy;
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
@DiscriminatorValue("RCSTOCKTAKINGSTATUS_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcstocktakingstatus")
public class RCStockTakingStatusImpl extends BaseModelObject implements RCStockTakingStatus {
  public RCStockTakingStatusImpl() {
    super();
  }
  
  private Boolean isInStockTaking = Boolean.valueOf(false);
  
  public Boolean getIsInStockTaking() {
    return this.isInStockTaking;
  }
  
  public RCStockTakingStatus setIsInStockTaking(final Boolean isInStockTaking) {
    this.isInStockTaking = isInStockTaking;
    return this;			
    
  }
  
  @JoinColumn(name = "warehouse_id")
  @ManyToOne(targetEntity = RCWarehouseImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWarehouse warehouse;
  
  public RCWarehouse getWarehouse() {
    return this.warehouse;
  }
  
  public RCStockTakingStatus setWarehouse(final RCWarehouse warehouse) {
    this.warehouse = warehouse;
    return this;			
    
  }
  
  public static RCStockTakingStatus create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCStockTakingStatus rCStockTakingStatus = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingStatusImpl(
    );
    objectFactory.create(rCStockTakingStatus);
    return rCStockTakingStatus;			
    
  }
  
  public RCStockTakingStatusProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCStockTakingStatusProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCStockTakingStatusProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
