package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCInStoreType;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCINSTORETYPE_TYPE")
public class RCInStoreTypeImpl extends CodeImpl implements RCInStoreType {
  public RCInStoreTypeImpl() {
    super();
  }
  
  public static RCInStoreType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCInStoreType rCInStoreType = new com.fudanmed.platform.core.warehouse.impl.RCInStoreTypeImpl(
    );
    objectFactory.create(rCInStoreType);
    return rCInStoreType;			
    
  }
  
  public RCInStoreTypeProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
