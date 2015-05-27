package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverEmergency;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLDELIVEREMERGENCY_TYPE")
public class DLDeliverEmergencyImpl extends CodeImpl implements DLDeliverEmergency {
  public DLDeliverEmergencyImpl() {
    super();
  }
  
  public static DLDeliverEmergency create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverEmergency dLDeliverEmergency = new com.fudanmed.platform.core.deliver.impl.DLDeliverEmergencyImpl(
    );
    objectFactory.create(dLDeliverEmergency);
    return dLDeliverEmergency;			
    
  }
  
  public DLDeliverEmergencyProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
