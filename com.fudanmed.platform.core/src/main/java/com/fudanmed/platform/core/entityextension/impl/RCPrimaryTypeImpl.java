package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCPRIMARYTYPE_TYPE")
public abstract class RCPrimaryTypeImpl extends RCTypeImpl implements RCPrimaryType {
  public RCPrimaryTypeImpl() {
    super();
  }
  
  public RCType cloneType(final RCExtensiableEntityType extensiableEntity) {
    return this;
  }
  
  public RCPrimaryTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
