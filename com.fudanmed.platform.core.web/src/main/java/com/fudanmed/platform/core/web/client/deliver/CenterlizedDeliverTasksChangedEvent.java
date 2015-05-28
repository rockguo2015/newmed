package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class CenterlizedDeliverTasksChangedEvent extends GwtEvent<CenterlizedDeliverTasksChangedHandler> {
  public static Type<CenterlizedDeliverTasksChangedHandler> __type__ = new Type<CenterlizedDeliverTasksChangedHandler>();
  
  public Type<CenterlizedDeliverTasksChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final CenterlizedDeliverTasksChangedHandler handler) {
    handler.CenterlizedDeliverTasksChanged();
  }
  
  public CenterlizedDeliverTasksChangedEvent() {
    
  }
}
