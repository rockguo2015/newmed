package com.fudanmed.platform.core.device.pm.events;

import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.events.RCPMWorkItemWorkerAssignmentEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.events.RCPMWorkItemWorkerAssignmentEventsManager")
public class RCPMWorkItemWorkerAssignmentEventsManager extends EntityEventsManager<RCPMWorkItemWorkerAssignment> {
  @Autowired(required = false)
  private Collection<RCPMWorkItemWorkerAssignmentEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCPMWorkItemWorkerAssignmentEventsListener> getListeners() {
    return listeners;
  }
  
  public void firePend(final RCPMWorkItemWorkerAssignment entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemWorkerAssignmentEventsListener)listener).pend(entity);
    }
    
  }
  
  public void fireFinish(final RCPMWorkItemWorkerAssignment entity) {
    for (edu.fudan.mylang.pf.event.IEntityEventsListner<?> listener : listeners) {
    	((RCPMWorkItemWorkerAssignmentEventsListener)listener).finish(entity);
    }
    
  }
}
