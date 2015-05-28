package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class WorkItemTasksChangedEvent extends GwtEvent<WorkItemTasksChangedHandler> {
  public static Type<WorkItemTasksChangedHandler> __type__ = new Type<WorkItemTasksChangedHandler>();
  
  public Type<WorkItemTasksChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final WorkItemTasksChangedHandler handler) {
    handler.WorkItemTasksChanged();
  }
  
  public WorkItemTasksChangedEvent() {
    
  }
}
