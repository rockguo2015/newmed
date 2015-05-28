package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class PMWorkItemWorkerAssignmentsChangedEvent extends GwtEvent<PMWorkItemWorkerAssignmentsChangedHandler> {
  public static Type<PMWorkItemWorkerAssignmentsChangedHandler> __type__ = new Type<PMWorkItemWorkerAssignmentsChangedHandler>();
  
  public Type<PMWorkItemWorkerAssignmentsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PMWorkItemWorkerAssignmentsChangedHandler handler) {
    handler.PMWorkItemWorkerAssignmentsChanged();
  }
  
  public PMWorkItemWorkerAssignmentsChangedEvent() {
    
  }
}
