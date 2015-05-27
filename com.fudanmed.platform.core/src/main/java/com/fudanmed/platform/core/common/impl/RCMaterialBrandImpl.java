package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCMaterialBrand;
import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCMATERIALBRAND_TYPE")
public class RCMaterialBrandImpl extends CodeImpl implements RCMaterialBrand {
  public RCMaterialBrandImpl() {
    super();
  }
  
  public static RCMaterialBrand create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCMaterialBrand rCMaterialBrand = new com.fudanmed.platform.core.common.impl.RCMaterialBrandImpl(
    );
    objectFactory.create(rCMaterialBrand);
    return rCMaterialBrand;			
    
  }
  
  public RCMaterialBrandProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy proxy = new com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
