package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCPMWorkItemEventsManager")
public class RCPMWorkItemEventsManager extends EntityEventsManager<RCPMWorkItem> {
  @Autowired(required = false)
  private Collection<RCPMWorkItemEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPMWorkItemEventsListener> getListeners() {
    return listeners;
  }
  
  public void fireAssignTeam(final RCPMWorkItem entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemEventsListener)listener).assignTeam(entity);
    }
    
  }
  
  public void fireWorkersAssigned(final RCPMWorkItem entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemEventsListener)listener).workersAssigned(entity);
    }
    
  }
  
  public void fireTeamFinish(final RCPMWorkItem entity, final Date finishDate, final String comment) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemEventsListener)listener).teamFinish(entity,finishDate,comment);
    }
    
  }
  
  public void fireFinish(final RCPMWorkItem entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemEventsListener)listener).finish(entity);
    }
    
  }
  
  public void fireAssignPlan(final RCPMWorkItem entity, final RCDevicePMPlan plan) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemEventsListener)listener).assignPlan(entity,plan);
    }
    
  }
  
  public void fireDeassignPlan(final RCPMWorkItem entity, final RCDevicePMPlan plan) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemEventsListener)listener).deassignPlan(entity,plan);
    }
    
  }
  
  public void fire$workerAssignmentFinish(final RCPMWorkItem entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemEventsListener)listener).$workerAssignmentFinish(entity);
    }
    
  }
}
