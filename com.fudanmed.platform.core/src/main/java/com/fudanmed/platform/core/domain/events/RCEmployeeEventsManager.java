package com.fudanmed.platform.core.domain.events;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.events.RCEmployeeEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.events.RCEmployeeEventsManager")
public class RCEmployeeEventsManager extends EntityEventsManager<RCEmployee> {
  @Autowired(required = false)
  private Collection<RCEmployeeEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCEmployeeEventsListener> getListeners() {
    return listeners;
  }
  
  public void fireLeaveJob(final RCEmployee entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCEmployeeEventsListener)listener).leaveJob(entity);
    }
    
  }
  
  public void fireReturnJob(final RCEmployee entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCEmployeeEventsListener)listener).returnJob(entity);
    }
    
  }
}
