package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class WorkItemPlanAssignmentsChangedEvent extends GwtEvent<WorkItemPlanAssignmentsChangedHandler> {
  public static Type<WorkItemPlanAssignmentsChangedHandler> __type__ = new Type<WorkItemPlanAssignmentsChangedHandler>();
  
  public Type<WorkItemPlanAssignmentsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final WorkItemPlanAssignmentsChangedHandler handler) {
    handler.WorkItemPlanAssignmentsChanged();
  }
  
  public WorkItemPlanAssignmentsChangedEvent() {
    
  }
}
