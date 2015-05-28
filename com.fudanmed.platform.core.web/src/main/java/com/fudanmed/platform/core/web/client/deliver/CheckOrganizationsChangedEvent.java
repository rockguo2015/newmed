package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class CheckOrganizationsChangedEvent extends GwtEvent<CheckOrganizationsChangedHandler> {
  public static Type<CheckOrganizationsChangedHandler> __type__ = new Type<CheckOrganizationsChangedHandler>();
  
  public Type<CheckOrganizationsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final CheckOrganizationsChangedHandler handler) {
    handler.CheckOrganizationsChanged();
  }
  
  public CheckOrganizationsChangedEvent() {
    
  }
}
