package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationDAO;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.impl.RCPMDefaultIntervalAssociationImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCPMDEVICETYPEENTRY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcpmdevicetypeentry")
public class RCPMDeviceTypeEntryImpl extends BaseModelObject implements RCPMDeviceTypeEntry {
  public RCPMDeviceTypeEntryImpl() {
    super();
  }
  
  @JoinColumn(name = "deviceType_id")
  @ManyToOne(targetEntity = RCDeviceTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCDeviceType deviceType;
  
  public RCDeviceType getDeviceType() {
    return this.deviceType;
  }
  
  public RCPMDeviceTypeEntry setDeviceType(final RCDeviceType deviceType) {
    this.deviceType = deviceType;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCPMDefaultIntervalAssociationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "entry")
  private Collection<RCPMDefaultIntervalAssociation> intervals = new java.util.ArrayList<com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation>();;
  
  public Collection<RCPMDefaultIntervalAssociation> getIntervals() {
    return this.intervals;
  }
  
  public RCPMDefaultIntervalAssociation createAndAddtoIntervals() {
    getIntervals().size();
    com.fudanmed.platform.core.device.pm.RCPMDefaultIntervalAssociation rCPMDefaultIntervalAssociation = new com.fudanmed.platform.core.device.pm.impl.RCPMDefaultIntervalAssociationImpl(this);
    getObjectFactory().create(rCPMDefaultIntervalAssociation);
    getIntervals().add(rCPMDefaultIntervalAssociation);
    return rCPMDefaultIntervalAssociation;
    
  }
  
  public RCPMDeviceTypeEntry removeAllIntervals() {
    for(RCPMDefaultIntervalAssociation obj : this.intervals){
    	getObjectFactory().delete(obj);
    }
    this.intervals.clear();
    return this;	
    
  }
  
  public RCPMDeviceTypeEntry removeFromIntervals(final RCPMDefaultIntervalAssociation rCPMDefaultIntervalAssociation) {
    this.intervals.remove(rCPMDefaultIntervalAssociation);
    getObjectFactory().delete(rCPMDefaultIntervalAssociation);
    return this;
    
  }
  
  public RCPMDefaultIntervalAssociation createInterval(final Procedure1<? super RCPMDefaultIntervalAssociation> init) {
    RCPMDefaultIntervalAssociation _createAndAddtoIntervals = this.createAndAddtoIntervals();
    final Procedure1<RCPMDefaultIntervalAssociation> _function = new Procedure1<RCPMDefaultIntervalAssociation>() {
        public void apply(final RCPMDefaultIntervalAssociation it) {
          init.apply(it);
          it.checkValid();
        }
      };
    RCPMDefaultIntervalAssociation _doubleArrow = ObjectExtensions.<RCPMDefaultIntervalAssociation>operator_doubleArrow(_createAndAddtoIntervals, _function);
    return _doubleArrow;
  }
  
  public void removeInterval(final RCPMDefaultIntervalAssociation interval) {
    this.removeFromIntervals(interval);
  }
  
  public void populateToDevice(final RCDevice device) {
    RCDeviceType _deviceType = device.getDeviceType();
    boolean _equals = Objects.equal(_deviceType, this.deviceType);
    Validates.Assert(_equals, "\u8BBE\u5907\u7C7B\u578B\u5FC5\u987B\u4E00\u81F4");
    BeanFactory _beanFactory = this.getBeanFactory();
    final RCDevicePMSpecificationDAO dao = _beanFactory.<RCDevicePMSpecificationDAO>getBean(RCDevicePMSpecificationDAO.class);
    final Procedure1<RCPMDefaultIntervalAssociation> _function = new Procedure1<RCPMDefaultIntervalAssociation>() {
        public void apply(final RCPMDefaultIntervalAssociation interval) {
          final Procedure1<RCDevicePMSpecification> _function = new Procedure1<RCDevicePMSpecification>() {
              public void apply(final RCDevicePMSpecification it) {
                it.setDevice(device);
                RCDevicePMType _type = interval.getType();
                it.setPmType(_type);
                Integer _intervalInDays = interval.getIntervalInDays();
                it.setIntervalInDays(_intervalInDays);
                String _description = interval.getDescription();
                it.setDescription(_description);
              }
            };
          dao.create(_function);
        }
      };
    IterableExtensions.<RCPMDefaultIntervalAssociation>forEach(this.intervals, _function);
  }
  
  public static RCPMDeviceTypeEntry create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry rCPMDeviceTypeEntry = new com.fudanmed.platform.core.device.pm.impl.RCPMDeviceTypeEntryImpl(
    );
    objectFactory.create(rCPMDeviceTypeEntry);
    return rCPMDeviceTypeEntry;			
    
  }
  
  public RCPMDeviceTypeEntryProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
