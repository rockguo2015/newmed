package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceManagementView;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = MeasureDeviceManagementView.class)
public interface MeasureDeviceManagementPresenterView extends Viewer {
  public abstract void setMeasureDeviceTypeListPresenter(final MeasureDeviceTypeListPresenter measureDeviceTypeListPresenter);
  
  public abstract void setMeasureDeviceListPresenter(final MeasureDeviceListPresenter measureDeviceListPresenter);
}
