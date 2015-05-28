package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.GasMeasureDevicesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class GasMeasureDevicesChangedEvent extends GwtEvent<GasMeasureDevicesChangedHandler> {
  public static Type<GasMeasureDevicesChangedHandler> __type__ = new Type<GasMeasureDevicesChangedHandler>();
  
  public Type<GasMeasureDevicesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final GasMeasureDevicesChangedHandler handler) {
    handler.GasMeasureDevicesChanged();
  }
  
  public GasMeasureDevicesChangedEvent() {
    
  }
}
