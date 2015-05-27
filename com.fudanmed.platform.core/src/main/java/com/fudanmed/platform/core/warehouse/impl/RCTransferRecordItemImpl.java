package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCRecordItem;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCTransferRecordItem;
import com.fudanmed.platform.core.warehouse.impl.RCTransferRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordItemProxy;
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
@DiscriminatorValue("RCTRANSFERRECORDITEM_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rctransferrecorditem")
public class RCTransferRecordItemImpl extends BaseModelObject implements RCTransferRecordItem {
  public RCTransferRecordItemImpl() {
    super();
  }
  
  public RCTransferRecordItemImpl(final RCTransferRecord transferRecord) {
    super();
    this.transferRecord = transferRecord;
  }
  
  @JoinColumn(name = "transferRecord_id")
  @ManyToOne(targetEntity = RCTransferRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCTransferRecord transferRecord;
  
  public RCTransferRecord getTransferRecord() {
    return this.transferRecord;
  }
  
  public RCTransferRecordItem setTransferRecord(final RCTransferRecord transferRecord) {
    this.transferRecord = transferRecord;
    return this;			
    
  }
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "quantity", column = @Column(name = "recordItem_quantity") ), @AttributeOverride(name = "workaround", column = @Column(name = "recordItem_workaround") ) } )
  @AssociationOverrides(value = @AssociationOverride(name = "productEntry", joinColumns = @JoinColumn(name = "recordItem_productEntry") ) )
  private RCRecordItem recordItem = com.fudanmed.platform.core.warehouse.RCRecordItem.create();
  
  public RCRecordItem getRecordItem() {
    return this.recordItem;
  }
  
  public RCTransferRecordItem setRecordItem(final RCRecordItem recordItem) {
    this.recordItem = recordItem;
    return this;			
    
  }
  
  public static RCTransferRecordItem create(final RCTransferRecord transferRecord, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCTransferRecordItem rCTransferRecordItem = new com.fudanmed.platform.core.warehouse.impl.RCTransferRecordItemImpl(
    	transferRecord
    );
    objectFactory.create(rCTransferRecordItem);
    return rCTransferRecordItem;			
    
  }
  
  public RCTransferRecordItemProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordItemProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordItemProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
