package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.impl.RCValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCPRIMARYVALUE_TYPE")
public abstract class RCPrimaryValueImpl extends RCValueImpl implements RCPrimaryValue {
  public RCPrimaryValueImpl() {
    super();
  }
  
  public RCPrimaryValueProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
