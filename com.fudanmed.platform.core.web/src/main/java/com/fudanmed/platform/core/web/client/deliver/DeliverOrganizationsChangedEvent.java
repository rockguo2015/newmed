package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeliverOrganizationsChangedEvent extends GwtEvent<DeliverOrganizationsChangedHandler> {
  public static Type<DeliverOrganizationsChangedHandler> __type__ = new Type<DeliverOrganizationsChangedHandler>();
  
  public Type<DeliverOrganizationsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeliverOrganizationsChangedHandler handler) {
    handler.DeliverOrganizationsChanged();
  }
  
  public DeliverOrganizationsChangedEvent() {
    
  }
}
