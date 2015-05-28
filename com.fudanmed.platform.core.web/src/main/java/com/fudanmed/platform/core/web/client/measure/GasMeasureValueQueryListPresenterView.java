package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.GasMeasureValueQueryListView;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = GasMeasureValueQueryListView.class)
public interface GasMeasureValueQueryListPresenterView extends Viewer, IContextProvider<UIGasMeasureValue> {
  public abstract void showResults(final IPagedResult<UIGasMeasureValue> results);
  
  public abstract void refresh();
  
  public abstract void setMeasureDevice(final RCMeasureDeviceProxy device);
  
  public abstract void filterRequest(final RequestHandler1<UIMeasureValueCriteria> requestHandler);
  
  public abstract ActionContext<UIGasMeasureValue> getActionContext();
}
