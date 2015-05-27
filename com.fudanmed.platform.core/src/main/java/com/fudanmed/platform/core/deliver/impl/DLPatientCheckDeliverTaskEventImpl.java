package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEventType;
import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.impl.DLTaskEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverTaskEventProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLPATIENTCHECKDELIVERTASKEVENT_TYPE")
public class DLPatientCheckDeliverTaskEventImpl extends DLTaskEventImpl implements DLPatientCheckDeliverTaskEvent {
  public DLPatientCheckDeliverTaskEventImpl() {
    super();
  }
  
  public DLPatientCheckDeliverTaskEventImpl(final DLTask task) {
    super( task);
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public DLPatientCheckDeliverTaskEvent setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private DLPatientCheckDeliverTaskEventType eventType;
  
  public DLPatientCheckDeliverTaskEventType getEventType() {
    return this.eventType;
  }
  
  public DLPatientCheckDeliverTaskEvent setEventType(final DLPatientCheckDeliverTaskEventType eventType) {
    this.eventType = eventType;
    return this;			
    
  }
  
  public String getDescription() {
    return this.comment;
  }
  
  public static DLPatientCheckDeliverTaskEvent create(final DLTask task, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent dLPatientCheckDeliverTaskEvent = new com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverTaskEventImpl(
    	task
    );
    objectFactory.create(dLPatientCheckDeliverTaskEvent);
    return dLPatientCheckDeliverTaskEvent;			
    
  }
  
  public DLPatientCheckDeliverTaskEventProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverTaskEventProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverTaskEventProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
