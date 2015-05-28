package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceManagementView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = GasMeasureDeviceManagementView.class)
public interface GasMeasureDeviceManagementPresenterView extends Viewer {
  public abstract void setContext(final RCGasMeasureDeviceTypeProxy context);
  
  public abstract void setQueryListPresenter(final GasMeasureDeviceListPresenter queryListPresenter);
}
