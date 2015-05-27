package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCAcquireType;
import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCACQUIRETYPE_TYPE")
public class RCAcquireTypeImpl extends CodeImpl implements RCAcquireType {
  public RCAcquireTypeImpl() {
    super();
  }
  
  public static RCAcquireType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.device.RCAcquireType rCAcquireType = new com.fudanmed.platform.core.device.impl.RCAcquireTypeImpl(
    );
    objectFactory.create(rCAcquireType);
    return rCAcquireType;			
    
  }
  
  public RCAcquireTypeProxy toProxy() {
    com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy proxy = new com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
