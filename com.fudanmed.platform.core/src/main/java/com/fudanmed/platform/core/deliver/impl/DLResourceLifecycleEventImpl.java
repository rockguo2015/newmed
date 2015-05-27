package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.DLResourceEventType;
import com.fudanmed.platform.core.deliver.DLResourceLifecycleEvent;
import com.fudanmed.platform.core.deliver.impl.DLResourceEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceLifecycleEventProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLRESOURCELIFECYCLEEVENT_TYPE")
public class DLResourceLifecycleEventImpl extends DLResourceEventImpl implements DLResourceLifecycleEvent {
  public DLResourceLifecycleEventImpl() {
    super();
  }
  
  public DLResourceLifecycleEventImpl(final DLResource resource) {
    super( resource);
    
  }
  
  private DLResourceEventType type;
  
  public DLResourceEventType getType() {
    return this.type;
  }
  
  public DLResourceLifecycleEvent setType(final DLResourceEventType type) {
    this.type = type;
    return this;			
    
  }
  
  public static DLResourceLifecycleEvent create(final DLResource resource, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLResourceLifecycleEvent dLResourceLifecycleEvent = new com.fudanmed.platform.core.deliver.impl.DLResourceLifecycleEventImpl(
    	resource
    );
    objectFactory.create(dLResourceLifecycleEvent);
    return dLResourceLifecycleEvent;			
    
  }
  
  public DLResourceLifecycleEventProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLResourceLifecycleEventProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLResourceLifecycleEventProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
