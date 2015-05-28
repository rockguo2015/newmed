package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.WaterMeasureDevicesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class WaterMeasureDevicesChangedEvent extends GwtEvent<WaterMeasureDevicesChangedHandler> {
  public static Type<WaterMeasureDevicesChangedHandler> __type__ = new Type<WaterMeasureDevicesChangedHandler>();
  
  public Type<WaterMeasureDevicesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final WaterMeasureDevicesChangedHandler handler) {
    handler.WaterMeasureDevicesChanged();
  }
  
  public WaterMeasureDevicesChangedEvent() {
    
  }
}
