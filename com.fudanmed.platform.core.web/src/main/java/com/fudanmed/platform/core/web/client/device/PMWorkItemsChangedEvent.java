package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class PMWorkItemsChangedEvent extends GwtEvent<PMWorkItemsChangedHandler> {
  public static Type<PMWorkItemsChangedHandler> __type__ = new Type<PMWorkItemsChangedHandler>();
  
  public Type<PMWorkItemsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PMWorkItemsChangedHandler handler) {
    handler.PMWorkItemsChanged();
  }
  
  public PMWorkItemsChangedEvent() {
    
  }
}
