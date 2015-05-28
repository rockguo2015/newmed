package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDevicesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class PhasedElectricMeasureDevicesChangedEvent extends GwtEvent<PhasedElectricMeasureDevicesChangedHandler> {
  public static Type<PhasedElectricMeasureDevicesChangedHandler> __type__ = new Type<PhasedElectricMeasureDevicesChangedHandler>();
  
  public Type<PhasedElectricMeasureDevicesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PhasedElectricMeasureDevicesChangedHandler handler) {
    handler.PhasedElectricMeasureDevicesChanged();
  }
  
  public PhasedElectricMeasureDevicesChangedEvent() {
    
  }
}
