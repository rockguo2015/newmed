package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEventType;
import com.fudanmed.platform.core.deliver.DLTaskEvent;
import com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverTaskEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverTaskEventProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLPatientCheckDeliverTaskEventImpl.class)
public interface DLPatientCheckDeliverTaskEvent extends DLTaskEvent {
  public abstract String getComment();
  
  public abstract DLPatientCheckDeliverTaskEvent setComment(final String comment);
  
  public abstract DLPatientCheckDeliverTaskEventType getEventType();
  
  public abstract DLPatientCheckDeliverTaskEvent setEventType(final DLPatientCheckDeliverTaskEventType eventType);
  
  public abstract String getDescription();
  
  public abstract DLPatientCheckDeliverTaskEventProxy toProxy();
}
