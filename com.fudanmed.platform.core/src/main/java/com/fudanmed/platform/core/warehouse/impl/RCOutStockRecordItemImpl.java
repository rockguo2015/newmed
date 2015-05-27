package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordItemProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCOUTSTOCKRECORDITEM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcoutstockrecorditem")
public class RCOutStockRecordItemImpl extends BaseModelObject implements RCOutStockRecordItem {
  public RCOutStockRecordItemImpl() {
    super();
  }
  
  public RCOutStockRecordItemImpl(final RCOutStockRecord record) {
    super();
    this.record = record;
  }
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "quantity", column = @Column(name = "recordItem_quantity") ), @AttributeOverride(name = "workaround", column = @Column(name = "recordItem_workaround") ) } )
  @AssociationOverrides(value = @AssociationOverride(name = "productEntry", joinColumns = @JoinColumn(name = "recordItem_productEntry") ) )
  private RCRecordItem recordItem = com.fudanmed.platform.core.warehouse.RCRecordItem.create();
  
  public RCRecordItem getRecordItem() {
    return this.recordItem;
  }
  
  public RCOutStockRecordItem setRecordItem(final RCRecordItem recordItem) {
    this.recordItem = recordItem;
    return this;			
    
  }
  
  @JoinColumn(name = "record_id")
  @ManyToOne(targetEntity = RCOutStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOutStockRecord record;
  
  public RCOutStockRecord getRecord() {
    return this.record;
  }
  
  public RCOutStockRecordItem setRecord(final RCOutStockRecord record) {
    this.record = record;
    return this;			
    
  }
  
  public static RCOutStockRecordItem create(final RCOutStockRecord record, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCOutStockRecordItem rCOutStockRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordItemImpl(
    	record
    );
    objectFactory.create(rCOutStockRecordItem);
    return rCOutStockRecordItem;			
    
  }
  
  public RCOutStockRecordItemProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordItemProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordItemProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
