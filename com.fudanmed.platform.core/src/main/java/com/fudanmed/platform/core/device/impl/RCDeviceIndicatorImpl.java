package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDeviceIndicator;
import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCDEVICEINDICATOR_TYPE")
public class RCDeviceIndicatorImpl extends CodeImpl implements RCDeviceIndicator {
  public RCDeviceIndicatorImpl() {
    super();
  }
  
  public static RCDeviceIndicator create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCDeviceIndicator rCDeviceIndicator = new com.fudanmed.platform.core.device.impl.RCDeviceIndicatorImpl(
    );
    objectFactory.create(rCDeviceIndicator);
    return rCDeviceIndicator;			
    
  }
  
  public RCDeviceIndicatorProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy proxy = new com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
