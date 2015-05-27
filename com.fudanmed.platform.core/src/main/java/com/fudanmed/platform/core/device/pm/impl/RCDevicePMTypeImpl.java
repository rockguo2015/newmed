package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCDEVICEPMTYPE_TYPE")
public class RCDevicePMTypeImpl extends CodeImpl implements RCDevicePMType {
  public RCDevicePMTypeImpl() {
    super();
  }
  
  public static RCDevicePMType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.pm.RCDevicePMType rCDevicePMType = new com.fudanmed.platform.core.device.pm.impl.RCDevicePMTypeImpl(
    );
    objectFactory.create(rCDevicePMType);
    return rCDevicePMType;			
    
  }
  
  public RCDevicePMTypeProxy toProxy() {
    com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy proxy = new com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
