package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureValuesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class MeasureValuesChangedEvent extends GwtEvent<MeasureValuesChangedHandler> {
  public static Type<MeasureValuesChangedHandler> __type__ = new Type<MeasureValuesChangedHandler>();
  
  public Type<MeasureValuesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final MeasureValuesChangedHandler handler) {
    handler.MeasureValuesChanged();
  }
  
  public MeasureValuesChangedEvent() {
    
  }
}
