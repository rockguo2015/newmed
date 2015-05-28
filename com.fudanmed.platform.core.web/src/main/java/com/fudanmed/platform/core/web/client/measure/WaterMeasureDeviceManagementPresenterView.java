package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceManagementView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = WaterMeasureDeviceManagementView.class)
public interface WaterMeasureDeviceManagementPresenterView extends Viewer {
  public abstract void setContext(final RCWaterMeasureDeviceTypeProxy context);
  
  public abstract void setQueryListPresenter(final WaterMeasureDeviceListPresenter queryListPresenter);
}
