package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCWorkType;
import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCWORKTYPE_TYPE")
public class RCWorkTypeImpl extends CodeImpl implements RCWorkType {
  public RCWorkTypeImpl() {
    super();
  }
  
  public static RCWorkType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCWorkType rCWorkType = new com.fudanmed.platform.core.common.impl.RCWorkTypeImpl(
    );
    objectFactory.create(rCWorkType);
    return rCWorkType;			
    
  }
  
  public RCWorkTypeProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy proxy = new com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
