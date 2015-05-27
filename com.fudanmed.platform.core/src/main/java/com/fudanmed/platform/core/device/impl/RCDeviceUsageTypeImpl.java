package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDeviceUsageType;
import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCDEVICEUSAGETYPE_TYPE")
public class RCDeviceUsageTypeImpl extends CodeImpl implements RCDeviceUsageType {
  public RCDeviceUsageTypeImpl() {
    super();
  }
  
  public static RCDeviceUsageType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDeviceUsageType rCDeviceUsageType = new com.fudanmed.platform.core.device.impl.RCDeviceUsageTypeImpl(
    );
    objectFactory.create(rCDeviceUsageType);
    return rCDeviceUsageType;			
    
  }
  
  public RCDeviceUsageTypeProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
