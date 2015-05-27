package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCFAULTLEVEL_TYPE")
public class RCFaultLevelImpl extends CodeImpl implements RCFaultLevel {
  public RCFaultLevelImpl() {
    super();
  }
  
  public static RCFaultLevel create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCFaultLevel rCFaultLevel = new com.fudanmed.platform.core.common.impl.RCFaultLevelImpl(
    );
    objectFactory.create(rCFaultLevel);
    return rCFaultLevel;			
    
  }
  
  public RCFaultLevelProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy proxy = new com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
