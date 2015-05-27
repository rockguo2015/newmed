package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMTypeImpl;
import com.fudanmed.platform.core.device.pm.impl.RCPMDeviceTypeEntryImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCPMDEFAULTINTERVALASSOCIATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcpmdefaultintervalassociation")
public class RCPMDefaultIntervalAssociationImpl extends BaseModelObject implements RCPMDefaultIntervalAssociation {
  public RCPMDefaultIntervalAssociationImpl() {
    super();
  }
  
  public RCPMDefaultIntervalAssociationImpl(final RCPMDeviceTypeEntry entry) {
    super();
    this.entry = entry;
  }
  
  @JoinColumn(name = "entry_id")
  @ManyToOne(targetEntity = RCPMDeviceTypeEntryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCPMDeviceTypeEntry entry;
  
  public RCPMDeviceTypeEntry getEntry() {
    return this.entry;
  }
  
  public RCPMDefaultIntervalAssociation setEntry(final RCPMDeviceTypeEntry entry) {
    this.entry = entry;
    return this;			
    
  }
  
  @JoinColumn(name = "type_id")
  @ManyToOne(targetEntity = RCDevicePMTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDevicePMType type;
  
  public RCDevicePMType getType() {
    return this.type;
  }
  
  public RCPMDefaultIntervalAssociation setType(final RCDevicePMType type) {
    this.type = type;
    return this;			
    
  }
  
  private Integer intervalInDays;
  
  public Integer getIntervalInDays() {
    return this.intervalInDays;
  }
  
  public RCPMDefaultIntervalAssociation setIntervalInDays(final Integer intervalInDays) {
    this.intervalInDays = intervalInDays;
    return this;			
    
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public RCPMDefaultIntervalAssociation setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  public void update(final Procedure1<? super RCPMDefaultIntervalAssociation> updater) {
    updater.apply(this);
    this.checkValid();
  }
  
  public static RCPMDefaultIntervalAssociation create(final RCPMDeviceTypeEntry entry, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation rCPMDefaultIntervalAssociation = new com.fudanmed.platform.core.device.pm.impl.RCPMDefaultIntervalAssociationImpl(
    	entry
    );
    objectFactory.create(rCPMDefaultIntervalAssociation);
    return rCPMDefaultIntervalAssociation;			
    
  }
  
  public RCPMDefaultIntervalAssociationProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
