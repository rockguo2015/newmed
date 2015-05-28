package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListView;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = ElectricMeasureDeviceListView.class)
public interface ElectricMeasureDeviceListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIElectricMeasureDevice> results);
  
  public abstract ActionContext<UIElectricMeasureDevice> getActionContext();
}
