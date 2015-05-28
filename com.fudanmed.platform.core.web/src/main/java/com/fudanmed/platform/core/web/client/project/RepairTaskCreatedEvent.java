package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskCreatedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class RepairTaskCreatedEvent extends GwtEvent<RepairTaskCreatedHandler> {
  public static Type<RepairTaskCreatedHandler> __type__ = new Type<RepairTaskCreatedHandler>();
  
  public Type<RepairTaskCreatedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final RepairTaskCreatedHandler handler) {
    handler.RepairTaskCreated(value);
  }
  
  private RCRepairTaskProxy value;
  
  public RepairTaskCreatedEvent(final RCRepairTaskProxy value) {
    this.value=value;
    
  }
}
