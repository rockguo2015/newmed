package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLResourceEvent;
import com.fudanmed.platform.core.deliver.DLResourceEventType;
import com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent;
import com.fudanmed.platform.core.deliver.DLResourceStatus;
import com.fudanmed.platform.core.deliver.DLResourceType;
import com.fudanmed.platform.core.deliver.impl.DLResourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = DLResourceImpl.class)
public interface DLResource extends IModelObject {
  public abstract String getSid();
  
  public abstract DLResource setSid(final String sid);
  
  public abstract DLResourceType getType();
  
  public abstract DLResource setType(final DLResourceType type);
  
  public abstract String getDescription();
  
  public abstract DLResource setDescription(final String description);
  
  public abstract Collection<DLResourceEvent> getEvents();
  
  public abstract DLResourceEvent createAndAddtoEvents();
  
  public abstract DLResource removeFromEvents(final DLResourceEvent dLResourceEvent);
  
  public abstract DLResource removeAllEvents();
  
  public abstract DLResourceEvent createLifeCycleEvent(final DLResourceEventType type);
  
  public abstract DLResourceExtBorrowEvent createExtBorrowEvent(final String comment);
  
  public abstract DLResourceStatus getStatus();
  
  public abstract void start();
  
  public abstract void repair(final String comment);
  
  public abstract void borrow();
  
  public abstract void extBorrow(final String comment);
  
  public abstract void unregister(final String comment);
  
  public abstract void finishRepair(final String comment);
  
  public abstract void doExtReturn();
  
  public abstract void doReturn();
  
  public abstract Boolean isReady4use();
  
  public abstract Boolean isBorrowed();
  
  public abstract Boolean isExtBorrowed();
  
  public abstract Boolean isRepairing();
  
  public abstract Boolean isUnregistered();
  
  public abstract DLResourceProxy toProxy();
}
