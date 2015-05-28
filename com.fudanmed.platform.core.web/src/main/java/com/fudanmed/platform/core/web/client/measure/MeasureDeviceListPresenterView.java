package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = MeasureDeviceListView.class)
public interface MeasureDeviceListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIMeasureDevice> results);
  
  public abstract ActionContext<UIMeasureDevice> getActionContext();
  
  public abstract void clear();
}
