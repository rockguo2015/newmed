package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListView;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = WaterMeasureDeviceListView.class)
public interface WaterMeasureDeviceListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIWaterMeasureDevice> results);
  
  public abstract ActionContext<UIWaterMeasureDevice> getActionContext();
}
