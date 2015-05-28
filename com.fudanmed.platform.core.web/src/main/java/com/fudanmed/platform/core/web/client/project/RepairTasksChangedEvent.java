package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTasksChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class RepairTasksChangedEvent extends GwtEvent<RepairTasksChangedHandler> {
  public static Type<RepairTasksChangedHandler> __type__ = new Type<RepairTasksChangedHandler>();
  
  public Type<RepairTasksChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final RepairTasksChangedHandler handler) {
    handler.RepairTasksChanged();
  }
  
  public RepairTasksChangedEvent() {
    
  }
}
