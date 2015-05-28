package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = MeasureDeviceTypeListView.class)
public interface MeasureDeviceTypeListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIMeasureDeviceType> results);
  
  public abstract ActionContext<UIMeasureDeviceType> getActionContext();
}
