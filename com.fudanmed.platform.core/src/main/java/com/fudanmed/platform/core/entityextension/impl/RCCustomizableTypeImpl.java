package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCCUSTOMIZABLETYPE_TYPE")
public abstract class RCCustomizableTypeImpl extends RCPrimaryTypeImpl implements RCCustomizableType {
  public RCCustomizableTypeImpl() {
    super();
  }
  
  public RCCustomizableTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
