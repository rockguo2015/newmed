package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLResourceType;
import com.fudanmed.platform.core.deliver.proxy.DLResourceTypeProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLRESOURCETYPE_TYPE")
public class DLResourceTypeImpl extends CodeImpl implements DLResourceType {
  public DLResourceTypeImpl() {
    super();
  }
  
  public static DLResourceType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLResourceType dLResourceType = new com.fudanmed.platform.core.deliver.impl.DLResourceTypeImpl(
    );
    objectFactory.create(dLResourceType);
    return dLResourceType;			
    
  }
  
  public DLResourceTypeProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLResourceTypeProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLResourceTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
