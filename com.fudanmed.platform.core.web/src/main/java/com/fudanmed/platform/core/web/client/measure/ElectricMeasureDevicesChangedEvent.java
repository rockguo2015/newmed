package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDevicesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ElectricMeasureDevicesChangedEvent extends GwtEvent<ElectricMeasureDevicesChangedHandler> {
  public static Type<ElectricMeasureDevicesChangedHandler> __type__ = new Type<ElectricMeasureDevicesChangedHandler>();
  
  public Type<ElectricMeasureDevicesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ElectricMeasureDevicesChangedHandler handler) {
    handler.ElectricMeasureDevicesChanged();
  }
  
  public ElectricMeasureDevicesChangedEvent() {
    
  }
}
