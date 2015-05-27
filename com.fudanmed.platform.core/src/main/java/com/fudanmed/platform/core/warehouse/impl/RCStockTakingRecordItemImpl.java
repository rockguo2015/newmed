package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordItemProxy;
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
@DiscriminatorValue("RCSTOCKTAKINGRECORDITEM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcstocktakingrecorditem")
public class RCStockTakingRecordItemImpl extends BaseModelObject implements RCStockTakingRecordItem {
  public RCStockTakingRecordItemImpl() {
    super();
  }
  
  public RCStockTakingRecordItemImpl(final RCStockTakingRecord record) {
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
  
  public RCStockTakingRecordItem setRecordItem(final RCRecordItem recordItem) {
    this.recordItem = recordItem;
    return this;			
    
  }
  
  @JoinColumn(name = "record_id")
  @ManyToOne(targetEntity = RCStockTakingRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCStockTakingRecord record;
  
  public RCStockTakingRecord getRecord() {
    return this.record;
  }
  
  public RCStockTakingRecordItem setRecord(final RCStockTakingRecord record) {
    this.record = record;
    return this;			
    
  }
  
  public static RCStockTakingRecordItem create(final RCStockTakingRecord record, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem rCStockTakingRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordItemImpl(
    	record
    );
    objectFactory.create(rCStockTakingRecordItem);
    return rCStockTakingRecordItem;			
    
  }
  
  public RCStockTakingRecordItemProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordItemProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordItemProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
