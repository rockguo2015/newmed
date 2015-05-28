package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceManagementView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = ElectricMeasureDeviceManagementView.class)
public interface ElectricMeasureDeviceManagementPresenterView extends Viewer {
  public abstract void setContext(final RCElectricMeasureDeviceTypeProxy context);
  
  public abstract void setQueryListPresenter(final ElectricMeasureDeviceListPresenter queryListPresenter);
}
