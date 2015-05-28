package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DocumentStoragesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DocumentStoragesChangedEvent extends GwtEvent<DocumentStoragesChangedHandler> {
  public static Type<DocumentStoragesChangedHandler> __type__ = new Type<DocumentStoragesChangedHandler>();
  
  public Type<DocumentStoragesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DocumentStoragesChangedHandler handler) {
    handler.DocumentStoragesChanged();
  }
  
  public DocumentStoragesChangedEvent() {
    
  }
}
