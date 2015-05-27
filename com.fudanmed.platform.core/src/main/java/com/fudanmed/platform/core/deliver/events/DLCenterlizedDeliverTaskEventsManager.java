package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsListener;
import com.fudanmed.platform.core.domain.RCEmployee;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsManager")
public class DLCenterlizedDeliverTaskEventsManager extends EntityEventsManager<DLCenterlizedDeliverTask> {
  @Autowired(required = false)
  private Collection<DLCenterlizedDeliverTaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLCenterlizedDeliverTaskEventsListener> getListeners() {
    return listeners;
  }
  
  public void firePerformUpdate(final DLCenterlizedDeliverTask entity, final Procedure1<? super DLCenterlizedDeliverTask> updater) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLCenterlizedDeliverTaskEventsListener)listener).performUpdate(entity,updater);
    }
    
  }
  
  public void fireDispatch(final DLCenterlizedDeliverTask entity, final Collection<RCEmployee> performers) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLCenterlizedDeliverTaskEventsListener)listener).dispatch(entity,performers);
    }
    
  }
  
  public void fireCancel(final DLCenterlizedDeliverTask entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLCenterlizedDeliverTaskEventsListener)listener).cancel(entity,comment);
    }
    
  }
  
  public void fireCancelDispatch(final DLCenterlizedDeliverTask entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLCenterlizedDeliverTaskEventsListener)listener).cancelDispatch(entity,comment);
    }
    
  }
  
  public void fireFinish(final DLCenterlizedDeliverTask entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((DLCenterlizedDeliverTaskEventsListener)listener).finish(entity,comment);
    }
    
  }
}
