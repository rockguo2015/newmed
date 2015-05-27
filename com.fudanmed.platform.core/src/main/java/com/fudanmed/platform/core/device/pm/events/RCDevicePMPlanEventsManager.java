package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.events.RCDevicePMPlanEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCDevicePMPlanEventsManager")
public class RCDevicePMPlanEventsManager extends EntityEventsManager<RCDevicePMPlan> {
  @Autowired(required = false)
  private Collection<RCDevicePMPlanEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCDevicePMPlanEventsListener> getListeners() {
    return listeners;
  }
  
  public void fireAssign(final RCDevicePMPlan entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCDevicePMPlanEventsListener)listener).assign(entity);
    }
    
  }
  
  public void fireReportInfo(final RCDevicePMPlan entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCDevicePMPlanEventsListener)listener).reportInfo(entity,comment);
    }
    
  }
  
  public void fireFinish(final RCDevicePMPlan entity, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCDevicePMPlanEventsListener)listener).finish(entity,comment);
    }
    
  }
  
  public void fireCancelAssign(final RCDevicePMPlan entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCDevicePMPlanEventsListener)listener).cancelAssign(entity);
    }
    
  }
  
  public void fireAssignWorker(final RCDevicePMPlan entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCDevicePMPlanEventsListener)listener).assignWorker(entity);
    }
    
  }
}
