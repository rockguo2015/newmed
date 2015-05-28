package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceManagementView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = PhasedElectricMeasureDeviceManagementView.class)
public interface PhasedElectricMeasureDeviceManagementPresenterView extends Viewer {
  public abstract void setContext(final RCPhasedElectricMeasureDeviceTypeProxy context);
  
  public abstract void setQueryListPresenter(final PhasedElectricMeasureDeviceListPresenter queryListPresenter);
}
