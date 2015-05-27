package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.events.RCRepairTaskEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager")
public class RCRepairTaskEventsManager extends EntityEventsManager<RCRepairTask> {
  @Autowired(required = false)
  private Collection<RCRepairTaskEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCRepairTaskEventsListener> getListeners() {
    return listeners;
  }
  
  public void fireCancel(final RCRepairTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCRepairTaskEventsListener)listener).cancel(entity);
    }
    
  }
  
  public void fireClose(final RCRepairTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCRepairTaskEventsListener)listener).close(entity);
    }
    
  }
  
  public void fireUpdated(final RCRepairTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCRepairTaskEventsListener)listener).updated(entity);
    }
    
  }
  
  public void fireGroupTaskFinished(final RCRepairTask entity, final RCGroupTask groupTask) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCRepairTaskEventsListener)listener).groupTaskFinished(entity,groupTask);
    }
    
  }
  
  public void fireCreateGroupTask(final RCRepairTask entity, final RCMaintenanceTeam team) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCRepairTaskEventsListener)listener).createGroupTask(entity,team);
    }
    
  }
  
  public void fireMisdispatch(final RCRepairTask entity, final RCGroupTask groupTask) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCRepairTaskEventsListener)listener).misdispatch(entity,groupTask);
    }
    
  }
  
  public void fireFirstWorkItemCreated(final RCRepairTask entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCRepairTaskEventsListener)listener).firstWorkItemCreated(entity);
    }
    
  }
}
