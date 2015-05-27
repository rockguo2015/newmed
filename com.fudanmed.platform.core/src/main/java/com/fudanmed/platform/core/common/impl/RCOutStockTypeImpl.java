package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCOutStockType;
import com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCOUTSTOCKTYPE_TYPE")
public class RCOutStockTypeImpl extends CodeImpl implements RCOutStockType {
  public RCOutStockTypeImpl() {
    super();
  }
  
  public static RCOutStockType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCOutStockType rCOutStockType = new com.fudanmed.platform.core.common.impl.RCOutStockTypeImpl(
    );
    objectFactory.create(rCOutStockType);
    return rCOutStockType;			
    
  }
  
  public RCOutStockTypeProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy proxy = new com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
