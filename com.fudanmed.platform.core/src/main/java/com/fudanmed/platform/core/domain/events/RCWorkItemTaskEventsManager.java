package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCWorkItemTaskEventsManager")
public class RCWorkItemTaskEventsManager extends EntityEventsManager<RCWorkItemTask> {
  @Autowired(required = false)
  private Collection<RCWorkItemTaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemTaskEventsListener> getListeners() {
    return listeners;
  }
  
  public void firePend(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).pend(entity);
    }
    
  }
  
  public void fireCancelPend(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).cancelPend(entity);
    }
    
  }
  
  public void fireOutsource(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).outsource(entity);
    }
    
  }
  
  public void fireFollowup(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).followup(entity);
    }
    
  }
  
  public void fireFinishOutsource(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).finishOutsource(entity);
    }
    
  }
  
  public void fireMisDispatching(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).misDispatching(entity);
    }
    
  }
  
  public void fireFinish(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).finish(entity);
    }
    
  }
  
  public void fireCancel(final RCWorkItemTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCWorkItemTaskEventsListener)listener).cancel(entity);
    }
    
  }
}
