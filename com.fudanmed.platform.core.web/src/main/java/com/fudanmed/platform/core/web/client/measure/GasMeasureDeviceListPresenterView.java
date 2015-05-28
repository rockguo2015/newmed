package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListView;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = GasMeasureDeviceListView.class)
public interface GasMeasureDeviceListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIGasMeasureDevice> results);
  
  public abstract ActionContext<UIGasMeasureDevice> getActionContext();
}
