package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.events.DLResourceEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLResourceEventsManager")
public class DLResourceEventsManager extends EntityEventsManager<DLResource> {
  @Autowired(required = false)
  private Collection<DLResourceEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLResourceEventsListener> getListeners() {
    return listeners;
  }
  
  public void fireRepair(final DLResource entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLResourceEventsListener)listener).repair(entity,comment);
    }
    
  }
  
  public void fireBorrow(final DLResource entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLResourceEventsListener)listener).borrow(entity);
    }
    
  }
  
  public void fireDoReturn(final DLResource entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLResourceEventsListener)listener).doReturn(entity);
    }
    
  }
  
  public void fireExtBorrow(final DLResource entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLResourceEventsListener)listener).extBorrow(entity,comment);
    }
    
  }
  
  public void fireDoExtReturn(final DLResource entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLResourceEventsListener)listener).doExtReturn(entity);
    }
    
  }
  
  public void fireUnregister(final DLResource entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLResourceEventsListener)listener).unregister(entity,comment);
    }
    
  }
  
  public void fireFinishRepair(final DLResource entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLResourceEventsListener)listener).finishRepair(entity,comment);
    }
    
  }
}
