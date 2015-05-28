package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairEvaluatesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class RepairEvaluatesChangedEvent extends GwtEvent<RepairEvaluatesChangedHandler> {
  public static Type<RepairEvaluatesChangedHandler> __type__ = new Type<RepairEvaluatesChangedHandler>();
  
  public Type<RepairEvaluatesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final RepairEvaluatesChangedHandler handler) {
    handler.RepairEvaluatesChanged();
  }
  
  public RepairEvaluatesChangedEvent() {
    
  }
}
