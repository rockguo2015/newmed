package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCMEASUREDEVICETYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcmeasuredevicetype")
public class RCMeasureDeviceTypeImpl extends BaseModelObject implements RCMeasureDeviceType {
  public RCMeasureDeviceTypeImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCMeasureDeviceType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCMeasureDeviceType setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  public Collection<RCMeasureDevice> getMeasureDevices() {
    IGenericQuery<RCMeasureDevice> query=getObjectFactory().createGenericQuery(RCMeasureDevice.class,"select e from com.fudanmed.platform.core.measure.impl.RCMeasureDeviceImpl as e   where (e.deviceType = :this) and  e.active = 1      ").setParameter("this",this);
    Collection<RCMeasureDevice> _list = query.list();
    return _list;
  }
  
  public static RCMeasureDeviceType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.measure.RCMeasureDeviceType rCMeasureDeviceType = new com.fudanmed.platform.core.measure.impl.RCMeasureDeviceTypeImpl(
    );
    objectFactory.create(rCMeasureDeviceType);
    return rCMeasureDeviceType;			
    
  }
  
  public RCMeasureDeviceTypeProxy toProxy() {
    com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy proxy = new com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
