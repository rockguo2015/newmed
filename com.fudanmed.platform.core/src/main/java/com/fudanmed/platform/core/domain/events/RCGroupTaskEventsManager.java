package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.events.RCGroupTaskEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCGroupTaskEventsManager")
public class RCGroupTaskEventsManager extends EntityEventsManager<RCGroupTask> {
  @Autowired(required = false)
  private Collection<RCGroupTaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCGroupTaskEventsListener> getListeners() {
    return listeners;
  }
  
  public void fireReportFinish(final RCGroupTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCGroupTaskEventsListener)listener).reportFinish(entity);
    }
    
  }
  
  public void fireTaskFinished(final RCGroupTask entity, final RCWorkItemTask task) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCGroupTaskEventsListener)listener).taskFinished(entity,task);
    }
    
  }
  
  public void fireTaskCreated(final RCGroupTask entity, final RCWorkItemTask task) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCGroupTaskEventsListener)listener).taskCreated(entity,task);
    }
    
  }
  
  public void fireReportMisdispatch(final RCGroupTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCGroupTaskEventsListener)listener).reportMisdispatch(entity);
    }
    
  }
  
  public void fireCancel(final RCGroupTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCGroupTaskEventsListener)listener).cancel(entity);
    }
    
  }
}
