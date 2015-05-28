package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListView;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = PhasedElectricMeasureDeviceListView.class)
public interface PhasedElectricMeasureDeviceListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIPhasedElectricMeasureDevice> results);
  
  public abstract ActionContext<UIPhasedElectricMeasureDevice> getActionContext();
}
