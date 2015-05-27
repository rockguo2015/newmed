package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCCredentialType;
import com.fudanmed.platform.core.common.proxy.RCCredentialTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCCREDENTIALTYPE_TYPE")
public class RCCredentialTypeImpl extends CodeImpl implements RCCredentialType {
  public RCCredentialTypeImpl() {
    super();
  }
  
  public static RCCredentialType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCCredentialType rCCredentialType = new com.fudanmed.platform.core.common.impl.RCCredentialTypeImpl(
    );
    objectFactory.create(rCCredentialType);
    return rCCredentialType;			
    
  }
  
  public RCCredentialTypeProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCCredentialTypeProxy proxy = new com.fudanmed.platform.core.common.proxy.RCCredentialTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
