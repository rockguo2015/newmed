package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCFaultEmergencyLevel;
import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCFAULTEMERGENCYLEVEL_TYPE")
public class RCFaultEmergencyLevelImpl extends CodeImpl implements RCFaultEmergencyLevel {
  public RCFaultEmergencyLevelImpl() {
    super();
  }
  
  public static RCFaultEmergencyLevel create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCFaultEmergencyLevel rCFaultEmergencyLevel = new com.fudanmed.platform.core.common.impl.RCFaultEmergencyLevelImpl(
    );
    objectFactory.create(rCFaultEmergencyLevel);
    return rCFaultEmergencyLevel;			
    
  }
  
  public RCFaultEmergencyLevelProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy proxy = new com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
