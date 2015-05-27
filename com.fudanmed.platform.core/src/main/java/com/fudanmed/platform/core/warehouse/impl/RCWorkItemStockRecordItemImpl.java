package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordItemProxy;
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
@DiscriminatorValue("RCWORKITEMSTOCKRECORDITEM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcworkitemstockrecorditem")
public class RCWorkItemStockRecordItemImpl extends BaseModelObject implements RCWorkItemStockRecordItem {
  public RCWorkItemStockRecordItemImpl() {
    super();
  }
  
  public RCWorkItemStockRecordItemImpl(final RCWorkItemStockRecord record) {
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
  
  public RCWorkItemStockRecordItem setRecordItem(final RCRecordItem recordItem) {
    this.recordItem = recordItem;
    return this;			
    
  }
  
  @JoinColumn(name = "record_id")
  @ManyToOne(targetEntity = RCWorkItemStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWorkItemStockRecord record;
  
  public RCWorkItemStockRecord getRecord() {
    return this.record;
  }
  
  public RCWorkItemStockRecordItem setRecord(final RCWorkItemStockRecord record) {
    this.record = record;
    return this;			
    
  }
  
  public static RCWorkItemStockRecordItem create(final RCWorkItemStockRecord record, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem rCWorkItemStockRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordItemImpl(
    	record
    );
    objectFactory.create(rCWorkItemStockRecordItem);
    return rCWorkItemStockRecordItem;			
    
  }
  
  public RCWorkItemStockRecordItemProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordItemProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordItemProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
