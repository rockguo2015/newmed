package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCPRODUCESPECIFICATIONUNIT_TYPE")
public class RCProduceSpecificationUnitImpl extends CodeImpl implements RCProduceSpecificationUnit {
  public RCProduceSpecificationUnitImpl() {
    super();
  }
  
  public static RCProduceSpecificationUnit create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit rCProduceSpecificationUnit = new com.fudanmed.platform.core.warehouse.impl.RCProduceSpecificationUnitImpl(
    );
    objectFactory.create(rCProduceSpecificationUnit);
    return rCProduceSpecificationUnit;			
    
  }
  
  public RCProduceSpecificationUnitProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
