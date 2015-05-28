package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTasksChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class GroupTasksChangedEvent extends GwtEvent<GroupTasksChangedHandler> {
  public static Type<GroupTasksChangedHandler> __type__ = new Type<GroupTasksChangedHandler>();
  
  public Type<GroupTasksChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final GroupTasksChangedHandler handler) {
    handler.GroupTasksChanged();
  }
  
  public GroupTasksChangedEvent() {
    
  }
}
