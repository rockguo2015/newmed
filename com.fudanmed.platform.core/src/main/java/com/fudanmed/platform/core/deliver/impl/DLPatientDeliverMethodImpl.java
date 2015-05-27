package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLPATIENTDELIVERMETHOD_TYPE")
public class DLPatientDeliverMethodImpl extends CodeImpl implements DLPatientDeliverMethod {
  public DLPatientDeliverMethodImpl() {
    super();
  }
  
  public static DLPatientDeliverMethod create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLPatientDeliverMethod dLPatientDeliverMethod = new com.fudanmed.platform.core.deliver.impl.DLPatientDeliverMethodImpl(
    );
    objectFactory.create(dLPatientDeliverMethod);
    return dLPatientDeliverMethod;			
    
  }
  
  public DLPatientDeliverMethodProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
