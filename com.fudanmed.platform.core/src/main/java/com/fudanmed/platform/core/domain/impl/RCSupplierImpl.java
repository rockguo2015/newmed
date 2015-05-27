package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierType;
import com.fudanmed.platform.core.domain.impl.RCEnterpriseImpl;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCSUPPLIER_TYPE")
public class RCSupplierImpl extends RCEnterpriseImpl implements RCSupplier {
  public RCSupplierImpl() {
    super();
  }
  
  private RCSupplierType type;
  
  public RCSupplierType getType() {
    return this.type;
  }
  
  public RCSupplier setType(final RCSupplierType type) {
    this.type = type;
    return this;			
    
  }
  
  public static RCSupplier create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCSupplier rCSupplier = new com.fudanmed.platform.core.domain.impl.RCSupplierImpl(
    );
    objectFactory.create(rCSupplier);
    return rCSupplier;			
    
  }
  
  public RCSupplierProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCSupplierProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCSupplierProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
